package org.example.application.usecase.findpricecreated;


import org.example.domain.model.pricecreateddomain.PriceCreatedDomainPersistencePort;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindPriceCreatedQueryHandlerImpl implements FindPriceCreatedQueryHandler {

    private final PriceCreatedDomainPersistencePort priceCreatedDomainPersistencePort;

    public FindPriceCreatedQueryHandlerImpl(PriceCreatedDomainPersistencePort outputPort) {
        this.priceCreatedDomainPersistencePort = outputPort;
    }

    @Override
    public FoundPriceList handle(FindPriceCreatedQuery query) {
        List<FoundPriceCreated> result  =  priceCreatedDomainPersistencePort.find(query.productId(), query.brandId(), query.applicationDate()).parallelStream().map(item -> new FoundPriceCreated(
                item.getBrandId(), item.getStartDate(), item.getEnDate(), item.getPriceList(), item.getProductId(), item.getPriority(), item.getPrice(), item.getCurr())).toList();

        if(query.applicationDate() == null) {
            return new FoundPriceList(result);
        }
        List<FoundPriceCreated> filteredList = result.stream()
                .filter(item -> result.stream()
                        .filter(otherItem -> Objects.equals(item.productId(), otherItem.productId()))
                        .mapToDouble(FoundPriceCreated::priority)
                        .max()
                        .orElse(-1) == item.priority())
                .collect(Collectors.toList());

        return new FoundPriceList(filteredList);
    }

}
