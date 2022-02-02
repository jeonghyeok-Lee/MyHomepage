package com.argonhome.web.error.controller;

// 에러코드 정의
// 각 발생되는 예외처리값을 코드로 정의
public enum ErrorCode {
	//common
	INVALID_INPUT_VALUE("C001","Invalid Input Value",400)

	// 그외 다른 경우의 에러는 여기에 정의
	
	
	;
	
	private final String code;
	private final String message;
	private final int status;
	
	ErrorCode(final String code, final String message, final int status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}
	
	
}
