package com.synrgy.commit.dao.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResProductDto {

    private Long id;
    private String name;
    private String images;
    private String price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;
}
