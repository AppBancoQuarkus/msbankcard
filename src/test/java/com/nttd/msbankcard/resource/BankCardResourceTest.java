package com.nttd.msbankcard.resource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nttd.msbankcard.dto.BankCardDto;
import com.nttd.msbankcard.dto.ResponseDto;
import com.nttd.msbankcard.entity.BankCardEntity;
import com.nttd.msbankcard.service.BankCardService;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@QuarkusTest
public class BankCardResourceTest {
    
    @Inject
    BankCardResource bankCardResource;

    @InjectMock
    BankCardService bankCardService;

    @Test
    public void addBankCardResponseGeneral(){

        BankCardDto obj  = new BankCardDto("4151415141511542",1221,"",12);
        Mockito.when(bankCardService.addBankCard(obj))
               .thenReturn(new ResponseDto(201, "Exitoso",new BankCardEntity()));

        Response response = bankCardResource.addBankCard(obj);
        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }




}
