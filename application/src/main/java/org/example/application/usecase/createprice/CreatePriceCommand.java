package org.example.application.usecase.createprice;


import org.example.application.cqrs.Command;

import java.util.Date;

public record CreatePriceCommand(String brandId, Date startDate, Date enDate, String priceList, String productId, String priority, double price, String curr) implements Command {}
