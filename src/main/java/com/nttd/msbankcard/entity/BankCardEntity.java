package com.nttd.msbankcard.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "BQMBANKCARD")
public class BankCardEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdBANKCARD;   

    @Column(length = 16)
    private String cardnumber;
    
    @Column(length = 3)
    private int pin;
    
    @Column
    private String duedate;

    @Column
    private int validationcode;
    
}
