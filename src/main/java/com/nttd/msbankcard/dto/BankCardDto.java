package com.nttd.msbankcard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankCardDto {

    private String cardnumber;
    private int pin;
    private String duedate;
    private int validationcode;


    public BankCardDto() {
    }


    public BankCardDto(String cardnumber, int pin, String duedate, int validationcode) {
        this.cardnumber = cardnumber;
        this.pin = pin;
        this.duedate = duedate;
        this.validationcode = validationcode;
    }


    

}
