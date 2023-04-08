package com.synrgy.commit.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqItemDetail {
    private String id;
    private String name;
    private int price;
    private int quantity = 1;
}
