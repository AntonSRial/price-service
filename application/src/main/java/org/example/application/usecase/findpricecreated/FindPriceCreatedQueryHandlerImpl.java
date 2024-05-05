package org.example.application.usecase.findpricecreated;


import org.example.domain.model.pricecreateddomain.PriceCreatedDomainPersistencePort;

import java.util.List;
import java.util.stream.Collectors;

public class FindPriceCreatedQueryHandlerImpl implements FindPriceCreatedQueryHandler {

    private final PriceCreatedDomainPersistencePort priceCreatedDomainPersistencePort;

    public FindPriceCreatedQueryHandlerImpl(PriceCreatedDomainPersistencePort outputPort) {
        this.priceCreatedDomainPersistencePort = outputPort;
    }

    @Override
    public FoundPriceList handle(FindPriceCreatedQuery query) {
        List<FoundPriceCreated> result  =  priceCreatedDomainPersistencePort.find(query.productId(), query.brandId(), query.applicationDate()).parallelStream().map(item -> new FoundPriceCreated(
                item.getBrandId(), item.getStartDate(), item.getEnDate(), item.getPriceList(), item.getProductId(), item.getPrice())).collect(Collectors.toList());
        return new FoundPriceList(result);
    }

}
