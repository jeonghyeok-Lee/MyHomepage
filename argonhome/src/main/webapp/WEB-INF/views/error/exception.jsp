<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<article>
		<div class="container">
			<p>�����͸� ó�� �ϴ� �������� ������ �߻��Ͽ����ϴ�.</p>
			<p>�����ڿ��� �����Ͽ� �ֽʽÿ�.</p>
			<h3>${exception.getMessage()}</h3>
			<ul>
				<c:forEach items="${exception.getStackTrace()}" var="stack">
					<li>${stack.toString()}</li>
				</c:forEach>

			</ul>
		</div>
	</article>
</body>
</html>