package com.pranav.BMS.Exception;

public class EmptyException extends RuntimeException {
	public String message;

	public EmptyException() {

	}

	public EmptyException(String message) {
		this.message = message;
	}
	public String toString() {
		return message;
	}
}
