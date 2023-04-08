package com.synrgy.commit.dao.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqTransactionDetail {
    @JsonProperty("order_id")
    private String order_id;
    @JsonProperty("gross_amount")
    private int gross_amount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("payment_link_id")
    private String payment_link_id;
}
