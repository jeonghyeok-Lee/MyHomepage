package com.argonhome.web.error.controller;

// 문법적 오류가 아닌 로직상의 예외처리를 개발자가 직접해야할 때 이처럼 만들어서 사용
// 더욱 구체적인 예외처리 필요시 해당 클래스를 상속받아 만들면 됨
public class BusinessException extends RuntimeException {
	private ErrorCode errorCode;
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public BusinessException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode= errorCode;
	}
	
	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
	
	
}
