package org.example.application.usecase.findpricecreated;


import org.example.application.cqrs.QueryHandler;

public interface FindPriceCreatedQueryHandler extends QueryHandler<FoundPriceCreated, FindPriceCreatedQuery> {
    FoundPriceList handle(FindPriceCreatedQuery query);
}
