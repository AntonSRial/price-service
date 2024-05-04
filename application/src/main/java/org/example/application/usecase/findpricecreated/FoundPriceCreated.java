package org.example.application.usecase.findpricecreated;

import java.util.Date;

public record FoundPriceCreated(String brandId, Date startDate, Date enDate, String priceList, String productId, String priority, double price, String curr) {
}
