package com.argonhome.web.error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 사이트 전체에 공통으로 적용해야할 컨트롤러에는 @ControllerAdvice를 사용한 예외처리 방법이 효율적
// 예외처리 메소드를 별도의 컨트롤로 분리
// 사용하는 사람들에 따라 advice가 붙은 클래스를 GlobalExceptionHandler클래스라고 작성하는 분들도 있음
// ResponseStatus < ControllerAdvice가 우선이므로 해당 @ControllerAdvice 부분을 주석처리
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(RuntimeException.class)
	public String errorException(Model model, Exception e) {
		logger.info("@ControllerAdvic방식 \n###Exception : " + e.getMessage());
		model.addAttribute("exception",e);
		return "error/exception";
	}

}
