package org.example.ddbb;

import org.example.domain.model.pricecreateddomain.PriceCreatedDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceCreatedDomainMapper {

    PriceCreatedDomainMapper INSTANCE = Mappers.getMapper(PriceCreatedDomainMapper.class);

    PriceCreatedDomain priceEntityToQueryPriceDomain(PriceEntity PriceEntity);

    PriceEntity queryPriceDomainToPriceEntity(PriceCreatedDomain existingPrice);

    List<PriceCreatedDomain> priceEntityListToQueryPriceDomainList(List<PriceEntity> PriceEntityList);

    List<PriceEntity> queryPriceDomainListToPriceEntityList(List<PriceCreatedDomain> existingPriceList);
}
