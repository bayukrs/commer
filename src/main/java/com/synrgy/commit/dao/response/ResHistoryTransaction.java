package com.synrgy.commit.dao.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productName;
    private Boolean isPaid;
    private String amount;
    private Date date;
}
