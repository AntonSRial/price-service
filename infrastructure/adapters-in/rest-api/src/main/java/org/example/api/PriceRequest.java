package org.example.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PriceRequest {
    private String brandId;

    private Date startDate;

    private Date enDate;

    private String priceList;

    private String productId;

    private String priority;

    private double price;

    private String curr;

}
