package com.argonhome.web.error.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

// 예외 발생시 동일한 포맷의 리턴값을 넘겨주기 위하여 사용함
// JSON타입으로 포맷하여 예외처리값 생성 
// 데이터 전달시 JSON파일로 많이 하기 때문
public class ErrorResponse {

	private String message;
	private int status;
	private List<FieldError> errors;
	private String code;
	
	// 해당기능과 동일한 기능을 수행하는 어노테이션 @Getter
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
	
	// 해당과 동일한 기능을 수행하는 어노테이션이 @NoArgsConstructor(access = AccessLevel.PROTECED)
	protected ErrorResponse() {}
	
	public static ErrorResponse of(final ErrorCode code) {
		return new ErrorResponse(code);
	}
	
	public static ErrorResponse of(final ErrorCode code, final List<FieldError> errors) {
		return new ErrorResponse(code,errors);
	}
	
	//BindingResult -> ErrorCode 매개변수를 Bean에 binding시에 발생하는 오류정보를 받기위함
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
		 * validation -> 데이터의 값이 유요한지 검사하는 것
		 * org.springframework.validation.FieldError -> 필드오류 / 특정 필드값의 거부 이유를 캡슐화하는 클래스
		 * getField() -> 개체의 영향을 받는 필드를 반환/ 오류에 영향을 주는
		 * getRejectedValue() -> 거부된 필드 값을 반환
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
