package com.argonhome.web.error.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 서버에서 문제가생겼을 때 반환되는 상태코드 값만으로는 정확한 원인 규명이 어려움
// -> 상태코드를 의미가 있는 코드로 변환하여 문제해결하는 방식이 @ResponseStatus 어노테이션
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
}
