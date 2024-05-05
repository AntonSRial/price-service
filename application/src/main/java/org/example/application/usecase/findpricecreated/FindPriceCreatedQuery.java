package org.example.application.usecase.findpricecreated;


import org.example.application.cqrs.Query;

import java.util.Date;

public record FindPriceCreatedQuery(String productId, String brandId, Date applicationDate) implements Query<FoundPriceCreated> {


}
