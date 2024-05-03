package org.example.application.usecase.createprice;


import org.example.application.cqrs.CommandHandler;

public interface CreatePriceCommandHandler extends CommandHandler<CreatePriceCommand> {

    void handle(CreatePriceCommand command);

}
