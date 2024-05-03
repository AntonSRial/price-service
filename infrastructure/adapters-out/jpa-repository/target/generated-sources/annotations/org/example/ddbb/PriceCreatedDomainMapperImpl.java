package org.example.ddbb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.domain.model.pricecreateddomain.PriceCreatedDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T17:47:55+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Red Hat, Inc.)"
)
public class PriceCreatedDomainMapperImpl implements PriceCreatedDomainMapper {

    @Override
    public PriceCreatedDomain priceEntityToQueryPriceDomain(PriceEntity PriceEntity) {
        if ( PriceEntity == null ) {
            return null;
        }

        PriceCreatedDomain priceCreatedDomain = new PriceCreatedDomain();

        priceCreatedDomain.setBrandId( PriceEntity.getBrandId() );
        priceCreatedDomain.setStartDate( PriceEntity.getStartDate() );
        priceCreatedDomain.setEnDate( PriceEntity.getEnDate() );
        priceCreatedDomain.setPriceList( PriceEntity.getPriceList() );
        priceCreatedDomain.setProductId( PriceEntity.getProductId() );
        priceCreatedDomain.setPrice( PriceEntity.getPrice() );
        priceCreatedDomain.setCurr( PriceEntity.getCurr() );

        return priceCreatedDomain;
    }

    @Override
    public PriceEntity queryPriceDomainToPriceEntity(PriceCreatedDomain existingPrice) {
        if ( existingPrice == null ) {
            return null;
        }

        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setBrandId( existingPrice.getBrandId() );
        priceEntity.setStartDate( existingPrice.getStartDate() );
        priceEntity.setEnDate( existingPrice.getEnDate() );
        priceEntity.setPriceList( existingPrice.getPriceList() );
        priceEntity.setProductId( existingPrice.getProductId() );
        priceEntity.setPrice( existingPrice.getPrice() );
        priceEntity.setCurr( existingPrice.getCurr() );

        return priceEntity;
    }

    @Override
    public List<PriceCreatedDomain> priceEntityListToQueryPriceDomainList(List<PriceEntity> PriceEntityList) {
        if ( PriceEntityList == null ) {
            return null;
        }

        List<PriceCreatedDomain> list = new ArrayList<PriceCreatedDomain>( PriceEntityList.size() );
        for ( PriceEntity priceEntity : PriceEntityList ) {
            list.add( priceEntityToQueryPriceDomain( priceEntity ) );
        }

        return list;
    }

    @Override
    public List<PriceEntity> queryPriceDomainListToPriceEntityList(List<PriceCreatedDomain> existingPriceList) {
        if ( existingPriceList == null ) {
            return null;
        }

        List<PriceEntity> list = new ArrayList<PriceEntity>( existingPriceList.size() );
        for ( PriceCreatedDomain priceCreatedDomain : existingPriceList ) {
            list.add( queryPriceDomainToPriceEntity( priceCreatedDomain ) );
        }

        return list;
    }
}
