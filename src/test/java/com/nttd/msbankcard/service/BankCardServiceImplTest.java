package com.nttd.msbankcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.nttd.msbankcard.dto.BankCardDto;
import com.nttd.msbankcard.dto.ResponseDto;
import com.nttd.msbankcard.entity.BankCardEntity;
import com.nttd.msbankcard.repository.BankCardRepository;
import com.nttd.msbankcard.service.impl.BankCardServiceImpl;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@QuarkusTest
public class BankCardServiceImplTest {
    
    @Inject
    BankCardServiceImpl bankCardServiceImpl;

    @InjectMock
    BankCardRepository bankCardRepository;


    @Test
    public void addBankCard_Correcto() {
        
        Mockito.doNothing().when(bankCardRepository).persist(ArgumentMatchers.any(BankCardEntity.class));

        BankCardDto obj  = new BankCardDto("4151415141511542",1221,"",12);
        ResponseDto responsedto = bankCardServiceImpl.addBankCard(obj);
        assertNotNull(responsedto);
        assertEquals(Response.Status.CREATED.getStatusCode(), responsedto.getCode());
    }

    @Test
    public void addBankCard_Incorrecto() {
        
        Mockito.doAnswer(Answer -> {
                throw new Exception();            
            }).when(bankCardRepository).persist(ArgumentMatchers.any(BankCardEntity.class));

        BankCardDto obj  = new BankCardDto("4151415141511542",1221,"",12);
        ResponseDto responsedto = bankCardServiceImpl.addBankCard(obj);
        assertNotNull(responsedto);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), responsedto.getCode());
    }


}
