package com.argonhome.web.error.controller;

// �����ڵ� ����
// �� �߻��Ǵ� ����ó������ �ڵ�� ����
public enum ErrorCode {
	//common
	INVALID_INPUT_VALUE("C001","Invalid Input Value",400)

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
