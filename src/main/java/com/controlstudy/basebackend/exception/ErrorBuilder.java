package com.controlstudy.basebackend.exception;

public class ErrorBuilder extends RuntimeException {
	public ErrorBuilder(String messageError) {
		super(messageError);
	}
}
