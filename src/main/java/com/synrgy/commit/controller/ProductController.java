package com.synrgy.commit.controller;

import com.synrgy.commit.dao.request.ReqCallbackTransaction;
import com.synrgy.commit.dao.request.ReqCreatePayment;
import com.synrgy.commit.dao.request.ReqTransactionDetail;
import com.synrgy.commit.dao.response.BaseResponse;
import com.synrgy.commit.dao.response.ResHistoryTransaction;
import com.synrgy.commit.dao.response.ResProductDto;
import com.synrgy.commit.model.oauth.User;
import com.synrgy.commit.service.ProductService;
import com.synrgy.commit.service.oauth.Oauth2UserDetailsService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<ResProductDto>>> getProductsSells(){
        return ResponseEntity.ok(BaseResponse.<List<ResProductDto>>builder()
                .status("Success")
                .message("Success Get Data")
                .data(productService.getListProduct())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ResProductDto>> getDetailProduct(@PathVariable("id") Long id){
        ResProductDto response = productService.getDetailProduct(id);
        if (response == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(BaseResponse.<ResProductDto>builder()
                .status("Success")
                .message("Success Get Data")
                .data(response)
                .build());
    }

    @GetMapping("/buy/{id}")
    public ResponseEntity<BaseResponse<?>> buyProduct(@PathVariable("id") Long id,
                                                      Principal principal){
        BaseResponse<?> response = productService.buyProduct(id, principal);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<BaseResponse<List<ResHistoryTransaction>>> getHistoryAll(Principal principal){
        List<ResHistoryTransaction> resHistoryTransactions = productService.historyTransaction(principal);
        if (resHistoryTransactions == null){
            return ResponseEntity.badRequest().body(
                    BaseResponse.<List<ResHistoryTransaction>>builder()
                            .status("Failed")
                            .message("Failed Get Data History")
                            .build()
            );
        }
        return ResponseEntity.badRequest().body(
                BaseResponse.<List<ResHistoryTransaction>>builder()
                        .status("Success")
                        .message("Success Get Data History")
                        .data(resHistoryTransactions)
                        .build()
        );
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<BaseResponse<ResHistoryTransaction>> getHistoryDetail(
            Principal principal,
            @PathVariable("id") Long id){
        ResHistoryTransaction resHistoryTransactions = productService.detailHistoryTransaction(id);
        if (resHistoryTransactions == null){
            return ResponseEntity.badRequest().body(
                    BaseResponse.<ResHistoryTransaction>builder()
                            .status("Failed")
                            .message("Failed Get Data History")
                            .build()
            );
        }
        return ResponseEntity.badRequest().body(
                BaseResponse.<ResHistoryTransaction>builder()
                        .status("Success")
                        .message("Success Get Data History")
                        .data(resHistoryTransactions)
                        .build()
        );
    }

    @PostMapping("/callback")
    private ResponseEntity<BaseResponse<?>> getStatusTransaction(@RequestBody ReqCallbackTransaction reqCreatePayment){
        String result = productService.updateStatus(reqCreatePayment);
        if (result == null){
            return ResponseEntity.status(400).body(BaseResponse.builder()
                    .status("False")
                    .message("Order Id Not Found")
                    .build());
        }
        return ResponseEntity.status(401).body(BaseResponse.builder()
                .status("True")
                .message("Success Update Status")
                .build());
    }

    @GetMapping(value = "/image/profile/{image}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody byte[] getImage(@PathVariable("image") String image) throws IOException {
        File file = new File("/product/" + image);
//        InputStream in = getClass().getResourceAsStream("/payment/"+image);
        InputStream in = new BufferedInputStream(Files.newInputStream(file.toPath()));
        System.out.println("Input : " + in);
        return IOUtils.toByteArray(in);
    }
}
