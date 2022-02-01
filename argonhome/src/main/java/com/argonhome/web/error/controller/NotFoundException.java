package com.argonhome.web.error.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// �������� ������������ �� ��ȯ�Ǵ� �����ڵ� �������δ� ��Ȯ�� ���� �Ը��� �����
// -> �����ڵ带 �ǹ̰� �ִ� �ڵ�� ��ȯ�Ͽ� �����ذ��ϴ� ����� @ResponseStatus ������̼�
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
}
