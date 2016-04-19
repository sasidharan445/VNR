package com.vnr.exception;

public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = -5909513726952602802L;
	private String exceptionMsg;
	
	public CustomException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
	
}
