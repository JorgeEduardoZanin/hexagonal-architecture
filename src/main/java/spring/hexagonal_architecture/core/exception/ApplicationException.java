package spring.hexagonal_architecture.core.exception;

import spring.hexagonal_architecture.core.enums.ExceptionType;

public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private ExceptionType exceptionType;

	public ApplicationException(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}
	
	

}
