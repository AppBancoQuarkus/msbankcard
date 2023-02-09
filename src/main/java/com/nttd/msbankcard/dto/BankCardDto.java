package com.nttd.msbankcard.dto;

public class BankCardDto {

    private String cardnumber;
    private int pin;
    private String duedate;
    private int validationcode;


    
    public BankCardDto() {
    }
    
    public String getCardnumber() {
        return cardnumber;
    }
    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public String getDuedate() {
        return duedate;
    }
    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
    public int getValidationcode() {
        return validationcode;
    }
    public void setValidationcode(int validationcode) {
        this.validationcode = validationcode;
    }



}
