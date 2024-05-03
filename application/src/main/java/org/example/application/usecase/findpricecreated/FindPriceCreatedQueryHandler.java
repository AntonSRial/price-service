package org.example.application.usecase.findpricecreated;


import org.example.application.cqrs.QueryHandler;

import java.util.List;

public interface FindPriceCreatedQueryHandler extends QueryHandler<FoundPriceCreated, FindPriceCreatedQuery> {
    FoundPriceList handle(FindPriceCreatedQuery query);
}
