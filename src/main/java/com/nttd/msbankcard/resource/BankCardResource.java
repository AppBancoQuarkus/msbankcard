package com.nttd.msbankcard.resource;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.jboss.logging.Logger;

import com.nttd.msbankcard.dto.ResponseDto;
import com.nttd.msbankcard.service.BankCardService;

@Path("/api/bankcard")
public class BankCardResource {

    @Inject
    BankCardService bankCardService;

    @Inject
    Logger logger;

    
    @POST
    @Path("/card")
    public Response addBankCard() {
        logger.info("Iniciando el metodo registrar tarjeta - Resource.");
        ResponseDto responsedto = bankCardService.addBankCard();
        return Response.ok(responsedto).status(responsedto.getCode()).build();
    }
}
