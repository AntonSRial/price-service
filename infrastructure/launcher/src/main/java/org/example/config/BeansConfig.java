package org.example.config;

import org.example.application.usecase.createprice.CreatePriceCommandHandler;
import org.example.application.usecase.createprice.CreatePriceCommandHandlerImpl;
import org.example.application.usecase.findpricecreated.FindPriceCreatedQueryHandler;
import org.example.application.usecase.findpricecreated.FindPriceCreatedQueryHandlerImpl;
import org.example.domain.model.pricecreateddomain.PriceCreatedDomainPersistencePort;
import org.example.domain.model.pricedomain.PriceDomainPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.price-service")
public class BeansConfig {

	@Bean
	CreatePriceCommandHandler getGreetingPriceService(PriceDomainPersistencePort outputPort) {
		return new CreatePriceCommandHandlerImpl(outputPort);
	}

	@Bean
	FindPriceCreatedQueryHandler getListExistingPriceService(PriceCreatedDomainPersistencePort outputPort) {
		return new FindPriceCreatedQueryHandlerImpl(outputPort);
	}

}
