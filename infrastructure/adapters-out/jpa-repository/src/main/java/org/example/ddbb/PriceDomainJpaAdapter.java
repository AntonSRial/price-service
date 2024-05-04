package org.example.ddbb;

import org.example.domain.model.pricecreateddomain.PriceCreatedDomain;
import org.example.domain.model.pricecreateddomain.PriceCreatedDomainPersistencePort;
import org.example.domain.model.pricedomain.PriceDomain;
import org.example.domain.model.pricedomain.PriceDomainPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceDomainJpaAdapter implements PriceDomainPersistencePort, PriceCreatedDomainPersistencePort {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public void save(PriceDomain price) {
        PriceEntity priceEntity = PriceDomainMapper.INSTANCE.priceDomainToPriceEntity(price);
        priceRepository.save(priceEntity);
    }

    @Override
    public List<PriceCreatedDomain> find(String productId, String brandId) {
        List<PriceEntity> priceEntityList = priceRepository.findAll();
        return PriceCreatedDomainMapper.INSTANCE.priceEntityListToQueryPriceDomainList(priceEntityList);
    }

}
