package org.example.application.usecase.findpricecreated;

import org.example.domain.model.pricecreateddomain.PriceCreatedDomain;
import org.example.domain.model.pricecreateddomain.PriceCreatedDomainPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class FindPriceCreatedQueryHandlerTest {

    @Mock
    private PriceCreatedDomainPersistencePort persistencePort;

    public FindPriceCreatedQueryHandlerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void handle_ReturnsFilteredFoundPriceList_WhenQueryHasResults() {
        // Arrange
        FindPriceCreatedQuery query = new FindPriceCreatedQuery("productId", "brandId", new Date());
        PriceCreatedDomain price1 = new PriceCreatedDomain("brandId", new Date(), new Date(), "priceList1", "productId1", 0, 34, "");
        PriceCreatedDomain price2 = new PriceCreatedDomain("brandId", new Date(), new Date(), "priceList2", "productId2", 0, 24, "");
        PriceCreatedDomain price3 = new PriceCreatedDomain("brandId", new Date(), new Date(), "priceList2", "productId2", 1, 25, "");
        List<PriceCreatedDomain> queryResult = Arrays.asList(price1, price2, price3);

        when(persistencePort.find(anyString(), anyString(), any(Date.class))).thenReturn(queryResult);

        // Act
        FindPriceCreatedQueryHandlerImpl queryHandler = new FindPriceCreatedQueryHandlerImpl(persistencePort);
        FoundPriceList foundPriceList = queryHandler.handle(query);

        // Assert
        assertEquals(2, foundPriceList.foundPriceCreatedList().size());
        assertEquals("priceList1", foundPriceList.foundPriceCreatedList().get(0).priceList());
        assertEquals("priceList2", foundPriceList.foundPriceCreatedList().get(1).priceList());
        assertEquals(25, foundPriceList.foundPriceCreatedList().get(1).price());

    }

    @Test
    public void handle_ReturnsEmptyFoundPriceList_WhenQueryHasNoResults() {
        // Arrange
        FindPriceCreatedQuery query = new FindPriceCreatedQuery("productId", "brandId", new Date());
        when(persistencePort.find(anyString(), anyString(), any(Date.class))).thenReturn(Collections.emptyList());

        // Act
        FindPriceCreatedQueryHandlerImpl queryHandler = new FindPriceCreatedQueryHandlerImpl(persistencePort);
        FoundPriceList foundPriceList = queryHandler.handle(query);

        // Assert
        assertEquals(0, foundPriceList.foundPriceCreatedList().size());
    }
}
