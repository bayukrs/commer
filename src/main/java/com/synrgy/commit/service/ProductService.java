package com.synrgy.commit.service;

import com.synrgy.commit.dao.request.ReqCallbackTransaction;
import com.synrgy.commit.dao.response.BaseResponse;
import com.synrgy.commit.dao.response.ResHistoryTransaction;
import com.synrgy.commit.dao.response.ResProductDto;

import java.security.Principal;
import java.util.List;

public interface ProductService {
    List<ResProductDto> getListProduct();
    ResProductDto getDetailProduct(Long id);
    BaseResponse<?> buyProduct(Long id, Principal principal);
    List<ResHistoryTransaction> historyTransaction(Principal principal);
    ResHistoryTransaction detailHistoryTransaction(Long id);

    String updateStatus(ReqCallbackTransaction transactionDetails);
}
