package org.example.application.usecase.createprice;


import org.example.domain.model.pricedomain.PriceDomain;
import org.example.domain.model.pricedomain.PriceDomainPersistencePort;

public class CreatePriceCommandHandlerImpl implements CreatePriceCommandHandler {

    private final PriceDomainPersistencePort pricePersistencePort;


    public CreatePriceCommandHandlerImpl(PriceDomainPersistencePort outputPort) {
        this.pricePersistencePort = outputPort;
    }

    @Override
    public void handle(CreatePriceCommand command) {
        PriceDomain priceDomain = new PriceDomain(command.brandId(), command.startDate(), command.enDate(), command.priceList(), command.productId(), command.priority(), command.price(), command.curr());
        pricePersistencePort.save(priceDomain);
    }

}
