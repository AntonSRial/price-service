package org.example.application.usecase.findpricecreated;

import java.util.Date;

public record FoundPriceCreated(String brandId, Date startDate, Date endDate, String priceList, String productId, int priority, double price, String curr) {
}
