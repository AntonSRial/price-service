package org.example.api;

import org.example.application.usecase.createprice.CreatePriceCommand;
import org.example.application.usecase.createprice.CreatePriceCommandHandler;
import org.example.application.usecase.findpricecreated.FindPriceCreatedQuery;
import org.example.application.usecase.findpricecreated.FindPriceCreatedQueryHandler;
import org.example.application.usecase.findpricecreated.FoundPriceCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.version}/price")
public class PriceAPI {
    @Autowired
    CreatePriceCommandHandler createPriceCommandHandler;
    @Autowired
    FindPriceCreatedQueryHandler findPriceCreatedQueryHandler;

    @PostMapping(path = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PriceCreatedResponse> create(@RequestBody PriceRequest price) {
        CreatePriceCommand createPriceCommand = new CreatePriceCommand(price.getBrandId(), price.getStartDate(), price.getEnDate(), price.getPriceList(), price.getProductId(), price.getPriority(), price.getPrice(), price.getCurr());

        createPriceCommandHandler.handle(createPriceCommand);
        return ResponseEntity.ok(new PriceCreatedResponse(price.getBrandId(), price.getStartDate(), price.getEnDate(), price.getPriceList(), price.getProductId(), price.getPriority(), price.getPrice(), price.getCurr()));
    }

    @GetMapping("")
    ResponseEntity<List<FoundPriceCreated>> list(String productId, String brandId, @RequestParam(name = "applicationDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date applicationDate) {

        FindPriceCreatedQuery query = new FindPriceCreatedQuery(productId, brandId, applicationDate);

        return ResponseEntity.ok(findPriceCreatedQueryHandler.handle(query).foundPriceCreatedList().stream()
                .map(item -> new FoundPriceCreated(item.brandId(), item.startDate(), item.enDate(), item.priceList(), item.productId(), item.price()))
                .collect(Collectors.toList()));
    }


}
