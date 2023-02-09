package com.nttd.msbankcard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    
    private int code;
    private String message;
    private String errorMessage;
    private String description;


    
    public ResponseDto() {
    }



    public ResponseDto(int code,String message) {
        this.code = code;
        this.message = message;
    }



    public ResponseDto(int code, String errorMessage, String description) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.description = description;
    }



    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }



  



    public String getErrorMessage() {
        return errorMessage;
    }



    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public int getCode() {
        return code;
    }



    public void setCode(int code) {
        this.code = code;
    }
    
    
    

}
