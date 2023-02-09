package com.nttd.msbankcard.service.impl;

import com.nttd.msbankcard.dto.ResponseDto;
import com.nttd.msbankcard.service.BankCardService;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BankCardServiceImpl implements BankCardService {

    

    @Override
    public ResponseDto addBankCard(){
        return new ResponseDto(201,"Exitoso.");
    }
    
}
