package org.example.application.usecase.findpricecreated;


import org.example.application.cqrs.Query;

public record FindPriceCreatedQuery(String productId, String brandId) implements Query<FoundPriceCreated> {


}
