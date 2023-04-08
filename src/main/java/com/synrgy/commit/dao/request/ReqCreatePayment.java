package com.synrgy.commit.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqCreatePayment {
    @JsonProperty("transaction_details")
    private ReqTransactionDetail transaction_details;
    @JsonProperty("customer_details")
    private ReqCustomerDetail customer_details;
    @JsonProperty("item_details")
    private List<ReqItemDetail> item_details;
}
