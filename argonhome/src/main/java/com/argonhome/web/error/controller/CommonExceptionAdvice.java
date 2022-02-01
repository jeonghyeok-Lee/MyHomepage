package com.argonhome.web.error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ����Ʈ ��ü�� �������� �����ؾ��� ��Ʈ�ѷ����� @ControllerAdvice�� ����� ����ó�� ����� ȿ����
// ����ó�� �޼ҵ带 ������ ��Ʈ�ѷ� �и�
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(RuntimeException.class)
	public String errorException(Model model, Exception e) {
		logger.info("@ControllerAdvic��� \n###Exception : " + e.getMessage());
		model.addAttribute("exception",e);
		return "error/exception";
	}
}
