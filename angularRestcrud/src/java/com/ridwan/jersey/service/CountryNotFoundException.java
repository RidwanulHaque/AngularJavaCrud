/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.jersey.service;

/**
 *
 * @author HaqueFamily
 */
public class CountryNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -6513666078709813858L;
    private String exceptionMessage;

    public CountryNotFoundException(String exceptionMessage) {
        super();
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
