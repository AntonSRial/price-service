package org.example.domain.model.pricedomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceDomain {

    private String brandId;

    private Date startDate;

    private Date enDate;

    private String priceList;

    private String productId;

    private double price;

    private String curr;


}
