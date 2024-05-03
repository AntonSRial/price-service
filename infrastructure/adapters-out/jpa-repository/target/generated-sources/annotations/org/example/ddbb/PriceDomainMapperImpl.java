package org.example.ddbb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.domain.model.pricedomain.PriceDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T17:47:55+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Red Hat, Inc.)"
)
public class PriceDomainMapperImpl implements PriceDomainMapper {

    @Override
    public PriceDomain priceEntityToPriceDomain(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }

        PriceDomain priceDomain = new PriceDomain();

        priceDomain.setBrandId( priceEntity.getBrandId() );
        priceDomain.setStartDate( priceEntity.getStartDate() );
        priceDomain.setEnDate( priceEntity.getEnDate() );
        priceDomain.setPriceList( priceEntity.getPriceList() );
        priceDomain.setProductId( priceEntity.getProductId() );
        priceDomain.setPrice( priceEntity.getPrice() );
        priceDomain.setCurr( priceEntity.getCurr() );

        return priceDomain;
    }

    @Override
    public PriceEntity priceDomainToPriceEntity(PriceDomain price) {
        if ( price == null ) {
            return null;
        }

        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setBrandId( price.getBrandId() );
        priceEntity.setStartDate( price.getStartDate() );
        priceEntity.setEnDate( price.getEnDate() );
        priceEntity.setPriceList( price.getPriceList() );
        priceEntity.setProductId( price.getProductId() );
        priceEntity.setPrice( price.getPrice() );
        priceEntity.setCurr( price.getCurr() );

        return priceEntity;
    }

    @Override
    public List<PriceDomain> priceEntityListToPriceDomainList(List<PriceEntity> priceEntityList) {
        if ( priceEntityList == null ) {
            return null;
        }

        List<PriceDomain> list = new ArrayList<PriceDomain>( priceEntityList.size() );
        for ( PriceEntity priceEntity : priceEntityList ) {
            list.add( priceEntityToPriceDomain( priceEntity ) );
        }

        return list;
    }

    @Override
    public List<PriceEntity> priceDomainListToPriceEntityList(List<PriceDomain> priceDomainList) {
        if ( priceDomainList == null ) {
            return null;
        }

        List<PriceEntity> list = new ArrayList<PriceEntity>( priceDomainList.size() );
        for ( PriceDomain priceDomain : priceDomainList ) {
            list.add( priceDomainToPriceEntity( priceDomain ) );
        }

        return list;
    }
}
