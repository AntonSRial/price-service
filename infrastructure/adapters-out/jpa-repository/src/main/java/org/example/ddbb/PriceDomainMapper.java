package org.example.ddbb;

import org.example.domain.model.pricedomain.PriceDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceDomainMapper {

    PriceDomainMapper INSTANCE = Mappers.getMapper(PriceDomainMapper.class);

    PriceDomain priceEntityToPriceDomain(PriceEntity priceEntity);

    PriceEntity priceDomainToPriceEntity(PriceDomain price);

    List<PriceDomain> priceEntityListToPriceDomainList(List<PriceEntity> priceEntityList);

    List<PriceEntity> priceDomainListToPriceEntityList(List<PriceDomain> priceDomainList);
}
