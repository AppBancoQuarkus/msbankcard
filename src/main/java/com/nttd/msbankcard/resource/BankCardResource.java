package com.nttd.msbankcard.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import org.jboss.logging.Logger;
import jakarta.ws.rs.core.MediaType;
import com.nttd.msbankcard.dto.BankCardDto;
import com.nttd.msbankcard.dto.ResponseDto;
import com.nttd.msbankcard.service.BankCardService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;

@Path("/api/bankcard")
public class BankCardResource {

    @Inject
    BankCardService bankCardService;

    @Inject
    Logger logger;

    /* Obtener la tarjeta filtrando por numero de tarjeta */
    @GET
    public Response getAllBankCard(BankCardDto bankCardDto) {
        logger.info("Inicio BankCardResource.getAllBankCard");
		ResponseDto response = bankCardService.getAllBankCard(bankCardDto);							
		return Response.ok(response).status(response.getCode()).build();
    }

    /* Registrar tarjeta de debito o Credito */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBankCard(BankCardDto bankCardDto) {
        logger.info("Iniciando el metodo registrar tarjeta - Resource.");
        ResponseDto responsedto = bankCardService.addBankCard(bankCardDto);
        return Response.ok(responsedto).status(responsedto.getCode()).build();
    }


}
