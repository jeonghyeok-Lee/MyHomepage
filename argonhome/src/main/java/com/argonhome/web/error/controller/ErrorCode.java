package com.argonhome.web.error.controller;

// �����ڵ� ����
// �� �߻��Ǵ� ����ó������ �ڵ�� ����
public enum ErrorCode {
	//common
	// 4xx -> Client Error
	INVALID_INPUT_VALUE("C001","Invalid Input Value",400), 
	METHOD_NOT_ALLOWED("C002", "Invalid Input Value", 405),
	HANDLE_ACCESS_DENIED("C003", "Access is Denied", 403),		
	
	// 5xx -> Server Error
	INTERNAL_SERVER_ERROR("C004","Internal Server Error",500),

	// �׿� �ٸ� ����� ������ ���⿡ ����
	
	
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
