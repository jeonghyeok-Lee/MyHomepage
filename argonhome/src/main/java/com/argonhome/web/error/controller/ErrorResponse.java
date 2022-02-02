package com.argonhome.web.error.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

// ���� �߻��� ������ ������ ���ϰ��� �Ѱ��ֱ� ���Ͽ� �����
// JSONŸ������ �����Ͽ� ����ó���� ���� 
// ������ ���޽� JSON���Ϸ� ���� �ϱ� ����
public class ErrorResponse {

	private String message;
	private int status;
	private List<FieldError> errors;
	private String code;
	
	// �ش��ɰ� ������ ����� �����ϴ� ������̼� @Getter
	public String getMessage() {return message;}
	public int getStatus() {return status;}
	public List<FieldError> getErrors() {return errors;}
	public String getCode() {return code;}

	private ErrorResponse(final ErrorCode code, final List<FieldError> errors) {
		this.message = code.getMessage();
		this.status = code.getStatus();
		this.errors = errors;
		this.code = code.getCode();
	}
	
	private ErrorResponse(final ErrorCode code) {
		this.message = code.getMessage();
		this.status = code.getStatus();
		this.code = code.getCode();
		this.errors = new ArrayList<>();
	}
	
	// �ش�� ������ ����� �����ϴ� ������̼��� @NoArgsConstructor(access = AccessLevel.PROTECED)
	protected ErrorResponse() {}
	
	public static ErrorResponse of(final ErrorCode code) {
		return new ErrorResponse(code);
	}
	
	public static ErrorResponse of(final ErrorCode code, final List<FieldError> errors) {
		return new ErrorResponse(code,errors);
	}
	
	//BindingResult -> ErrorCode �Ű������� Bean�� binding�ÿ� �߻��ϴ� ���������� �ޱ�����
	public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
		return new ErrorResponse(code,FieldError.of(bindingResult));
	}
	
	public static class FieldError {
		private String field;
		private String value;
		private String reason;
		
		public String getField() {return field;}
		public String getValue() {return value;}
		public String getReason() {return reason;}
		
		protected FieldError() {}
		
		private FieldError(final String field,final String value, final String reason) {
			this.field = field;
			this.value = value;
			this.reason = reason;
		}
		
		public static List<FieldError> of(final String field, final String value, final String reason){
			List<FieldError> fieldErrors = new ArrayList<>();
			fieldErrors.add(new FieldError(field,value,reason));		
			return fieldErrors;
		}
		
		/*
		 * validation -> �������� ���� �������� �˻��ϴ� ��
		 * org.springframework.validation.FieldError -> �ʵ���� / Ư�� �ʵ尪�� �ź� ������ ĸ��ȭ�ϴ� Ŭ����
		 * getField() -> ��ü�� ������ �޴� �ʵ带 ��ȯ/ ������ ������ �ִ�
		 * getRejectedValue() -> �źε� �ʵ� ���� ��ȯ
		 * 
		 */
		private static List<FieldError> of(final BindingResult bindingResult){
			final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
			return fieldErrors.stream()
					.map(error -> new FieldError(error.getField(), error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(), error.getDefaultMessage()))
					.collect(Collectors.toList());
		}
	}
}
