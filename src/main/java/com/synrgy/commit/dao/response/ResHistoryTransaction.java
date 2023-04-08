package com.synrgy.commit.dao.response;

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
public class ResHistoryTransaction {

    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ResProductDto product;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String link;
    private Boolean isPaid;
    private String amount;
}
