package org.example.domain.model.pricecreateddomain;


import java.util.Date;
import java.util.List;

public interface PriceCreatedDomainPersistencePort {

    List<PriceCreatedDomain> find(String productId, String brandId, Date applicationDate);

}
