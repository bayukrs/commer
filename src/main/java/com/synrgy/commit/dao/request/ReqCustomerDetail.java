package com.synrgy.commit.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqCustomerDetail {
    @JsonProperty(value = "first_name")
    private String first_name;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "phone")
    private String phone;
}
