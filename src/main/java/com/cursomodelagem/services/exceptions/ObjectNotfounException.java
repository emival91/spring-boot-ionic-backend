package com.cursomodelagem.services.exceptions;

public class ObjectNotfounException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotfounException(String msg) {
		super(msg);
	}
	
	public ObjectNotfounException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
