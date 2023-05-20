package com.synrgy.commit.controller;

import com.synrgy.commit.dao.response.BaseResponse;
import com.synrgy.commit.dao.response.ResHistoryTransaction;
import com.synrgy.commit.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/history")
public class HistoryController {
    private final ProductService productService;

    @Autowired
    public HistoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<BaseResponse<List<ResHistoryTransaction>>> getHistoryAll(Principal principal, @RequestParam(value = "userId", required = false) String userId){
        List<ResHistoryTransaction> resHistoryTransactions = new ArrayList<>();
        if (userId != null){
            resHistoryTransactions = productService.historyTransaction(Long.parseLong(userId));
            log.info("History By User Id");
        }else{
            resHistoryTransactions = productService.historyTransaction(principal);
            log.info("History By User Login");
        }
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

    @GetMapping("/{id}")
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
}
