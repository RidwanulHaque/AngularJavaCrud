/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.jersey.service;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HaqueFamily
 */
@XmlRootElement
public class ExceptionMessage {
    String exceptionMessage;
	String excpetionCode;
	public ExceptionMessage(String exceptionMessage, String excpetionCode) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.excpetionCode = excpetionCode;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getExcpetionCode() {
		return excpetionCode;
	}
	public void setExcpetionCode(String excpetionCode) {
		this.excpetionCode = excpetionCode;
	}
	
	
}
