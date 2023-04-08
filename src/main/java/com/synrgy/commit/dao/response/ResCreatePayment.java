package com.synrgy.commit.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResCreatePayment {

    @JsonProperty(value = "order_id")
    private String order_id;
    @JsonProperty(value = "payment_url")
    private String payment_url;
}
