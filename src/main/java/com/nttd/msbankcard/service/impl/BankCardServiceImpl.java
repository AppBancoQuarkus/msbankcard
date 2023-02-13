package com.nttd.msbankcard.service.impl;

import com.nttd.msbankcard.dto.BankCardDto;
import com.nttd.msbankcard.dto.ResponseDto;
import com.nttd.msbankcard.entity.BankCardEntity;
import com.nttd.msbankcard.repository.BankCardRepository;
import com.nttd.msbankcard.service.BankCardService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BankCardServiceImpl implements BankCardService {

    @Inject
    BankCardRepository bankCardRepository;
    

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
            return  new ResponseDto(201,"Exitoso.",bcEntity);
        }catch(Exception ex){
            return  new ResponseDto(400,"Bad Request.",ex.getMessage());
        }
            
    }
    
}
