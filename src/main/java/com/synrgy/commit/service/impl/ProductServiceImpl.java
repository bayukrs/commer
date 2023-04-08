package com.synrgy.commit.service.impl;

import com.synrgy.commit.dao.request.*;
import com.synrgy.commit.dao.response.BaseResponse;
import com.synrgy.commit.dao.response.ResCreatePayment;
import com.synrgy.commit.dao.response.ResHistoryTransaction;
import com.synrgy.commit.dao.response.ResProductDto;
import com.synrgy.commit.model.HistoryEntity;
import com.synrgy.commit.model.ProductEntity;
import com.synrgy.commit.model.oauth.User;
import com.synrgy.commit.repository.HistoryRepository;
import com.synrgy.commit.repository.ProductRepository;
import com.synrgy.commit.repository.oauth.UserRepository;
import com.synrgy.commit.service.ProductService;
import com.synrgy.commit.service.oauth.Oauth2UserDetailsService;
import com.synrgy.commit.util.IdrFormatMoney;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.*;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final Oauth2UserDetailsService userDetailsService;
    private final HistoryRepository historyRepository;

    private final RestTemplate restTemplate;

    @Value("${mid-trans.key}")
    private String clientKey;
    @Value("${mid-trans.url}")
    private String urlMidTrans;
    @Value("${mid-trans.password}")
    private String midTransPassword;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              UserRepository userRepository,
                              Oauth2UserDetailsService userDetailsService,
                              HistoryRepository historyRepository,
                              RestTemplateBuilder templateBuilder) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.historyRepository = historyRepository;
        this.restTemplate = templateBuilder.build();
    }

    @Override
    public List<ResProductDto> getListProduct() {
        List<ProductEntity> productEntities = productRepository.findBySold(false);
        List<ResProductDto> productDtos = new ArrayList<>();
        productEntities.forEach(p -> {
            ResProductDto dto = ResProductDto.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .images(p.getImage())
                    .price(IdrFormatMoney.currencyIdrFromDouble(p.getPrice()))
                    .build();
            productDtos.add(dto);
        });
        return productDtos;
    }

    @Override
    public ResProductDto getDetailProduct(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (!productEntity.isPresent()){
            return null;
        }
        ProductEntity p = productEntity.get();
        return ResProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .images(p.getImage())
                .price(IdrFormatMoney.currencyIdrFromDouble(p.getPrice()))
                .desc(p.getDesc())
                .build();
    }

    @Override
    public BaseResponse<?> buyProduct(Long id, Principal principal) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (!productEntity.isPresent()){
            return BaseResponse.<String>builder()
                    .status("failed")
                    .message("product not found")
                    .data(null).build();
        }
        User user = getUserIdToken(principal, userDetailsService);
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (!userOptional.isPresent()){
            return BaseResponse.<String>builder()
                    .status("failed")
                    .message("user not found")
                    .data(null).build();
        }
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setProduct(productEntity.get());
        historyEntity.setPayed(false);
        historyEntity.setUser(userOptional.get());
        historyEntity = historyRepository.save(historyEntity);
        ReqTransactionDetail transactionDetail = ReqTransactionDetail.builder()
                .order_id(historyEntity.getId().toString())
                .gross_amount(Math.toIntExact(productEntity.get().getPrice()))
                .payment_link_id(userOptional.get().getFullname() + "-" + historyEntity.getId())
                .build();
        ReqCustomerDetail customerDetail = ReqCustomerDetail.builder()
                .first_name(userOptional.get().getFullname())
                .email(userOptional.get().getUsername())
                .phone(userOptional.get().getPhone_number())
                .build();
        ReqItemDetail itemDetail = ReqItemDetail.builder()
                .id(productEntity.get().getId().toString())
                .name(productEntity.get().getName())
                .price(Math.toIntExact(productEntity.get().getPrice()))
                .quantity(1)
                .build();
        ReqCreatePayment createPayment = ReqCreatePayment.builder()
                .transaction_details(transactionDetail)
                .customer_details(customerDetail)
                .item_details(Collections.singletonList(itemDetail))
                .build();
        log.info("Request : " + createPayment);
        String auth = clientKey
                .concat(":");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8)));
        HttpEntity<ReqCreatePayment> http = new HttpEntity<>(createPayment, headers);
        ParameterizedTypeReference<ResCreatePayment> typeReference =
                new ParameterizedTypeReference<ResCreatePayment>() {};
        ResponseEntity<ResCreatePayment> response = restTemplate.exchange(urlMidTrans, HttpMethod.POST,
                http, typeReference);
        ResCreatePayment resCreatePayment = response.getBody();
        historyEntity.setLinkPayment(resCreatePayment.getPayment_url());
        historyRepository.save(historyEntity);
        productEntity.get().setSold(true);
        productRepository.save(productEntity.get());
        return BaseResponse.<ResCreatePayment>builder()
                .status("success")
                .message("Success Buy Product")
                .data(resCreatePayment).build();
    }

    @Override
    public List<ResHistoryTransaction> historyTransaction(Principal principal) {

        User user = getUserIdToken(principal, userDetailsService);
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (!userOptional.isPresent()){
            return null;
        }
        List<ResHistoryTransaction> historyTransactions = new ArrayList<>();
        List<HistoryEntity> historyEntity = userOptional.get().getHistoryEntities();
        historyEntity.forEach(h -> {
//            ResProductDto productDto = ResProductDto.builder()
//                    .name(h.getProduct().getName())
//                    .images(h.getProduct().getImage())
//                    .desc(h.getProduct().getImage())
//                    .price(IdrFormatMoney.currencyIdrFromDouble(h.getProduct().getPrice()))
//                    .build();
            ResHistoryTransaction historyTransaction = ResHistoryTransaction.builder()
                    .id(h.getId())
                    .amount(IdrFormatMoney.currencyIdrFromDouble(h.getProduct().getPrice()))
                    .isPaid(h.getPayed())
//                    .link(h.getLinkPayment())
                    .build();
            historyTransactions.add(historyTransaction);
        });
        return historyTransactions;
    }

    @Override
    public ResHistoryTransaction detailHistoryTransaction(Long id) {
        Optional<HistoryEntity> history = historyRepository.findById(id);
        if (!history.isPresent()){
            return null;
        }
        HistoryEntity h = history.get();
        ResProductDto productDto = ResProductDto.builder()
                .id(h.getProduct().getId())
                    .name(h.getProduct().getName())
                    .images(h.getProduct().getImage())
                    .desc(h.getProduct().getDesc())
                    .price(IdrFormatMoney.currencyIdrFromDouble(h.getProduct().getPrice()))
                    .build();
        ResHistoryTransaction historyTransaction = ResHistoryTransaction.builder()
                .id(h.getId())
                .amount(IdrFormatMoney.currencyIdrFromDouble(h.getProduct().getPrice()))
                .isPaid(h.getPayed())
                .link(h.getLinkPayment())
                .product(productDto)
                .build();
        return historyTransaction;
    }

    @Override
    public String updateStatus(ReqCallbackTransaction transactionDetails) {
        String[] id = transactionDetails.getOrder_id().split("-");
        Optional<HistoryEntity> historyEntityOptional = historyRepository.findById(Long.valueOf(id[0]));
        if (!historyEntityOptional.isPresent()){
            return null;
        }
        HistoryEntity historyEntity = historyEntityOptional.get();
        historyEntity.setPayed(true);
        historyRepository.save(historyEntity);
        return "success";
    }

    private User getUserIdToken(Principal principal, Oauth2UserDetailsService userDetailsService) {
        UserDetails user = null;
        String username = principal.getName();
        if (!StringUtils.isEmpty(username)) {
            user = userDetailsService.loadUserByUsername(username);
        }

        if (null == user) {
            throw new UsernameNotFoundException("User not found");
        }
        User idUser = userRepository.findOneByUsername(user.getUsername());
        if (null == idUser) {
            throw new UsernameNotFoundException("User name not found");
        }
        return idUser;
    }
}
