package com.nttd.msbankcard.service.impl;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.nttd.msbankcard.dto.BankCardDto;
import com.nttd.msbankcard.dto.ResponseDto;
import com.nttd.msbankcard.entity.BankCardEntity;
import com.nttd.msbankcard.repository.BankCardRepository;
import com.nttd.msbankcard.service.BankCardService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class BankCardServiceImpl implements BankCardService {

    @Inject
    BankCardRepository bankCardRepository;

    @ConfigProperty(name = "exception.general")
    String exceptionGeneral;
    
    @ConfigProperty(name = "mensaje.general")
    String mensajeGeneral;

    @Override
    @Transactional
    public ResponseDto addBankCard(BankCardDto bankCardDto){
        try{
            BankCardEntity bcEntity = new BankCardEntity();
            bcEntity.setCardnumber(bankCardDto.getCardnumber());
            bcEntity.setPin(bankCardDto.getPin());
            bcEntity.setDuedate(bankCardDto.getDuedate());
            bcEntity.setValidationcode(bankCardDto.getValidationcode());
            bankCardRepository.persist(bcEntity);
            return  new ResponseDto(Response.Status.CREATED.getStatusCode(),mensajeGeneral,bcEntity);
        }catch(Exception ex){
            return  new ResponseDto(Response.Status.BAD_REQUEST.getStatusCode(),exceptionGeneral,ex.getMessage());
        }
            
    }
    
}
