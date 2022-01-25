<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<article>
	<%-- 
	이름 작성시 기본 규칙 네이밍 조합은 형태_의미_순서_상태를 기본으로 1보다는 01사용 권장
	-조합은 css네이밍에 _조합은 form/input 엘리먼트등의 name attribute값을 사용하는 것을 권장
	--%>
		<div class="container" role="main">
			<h2>board Content</h2>
			<div class="bg-white rounded shadow-sm">
				<div class="board_title">
					<c:out value="${boardContent.btitle}"/>
				</div>
				<div class="board_info">
					<span class="board_author"><c:out value="${boardContent.bwrite_dy}"/>,</span>
					<span class="board_date"><c:out value="${boardContent.bedit_dy}"/></span>
				</div>
				<div class="board_content">${boardContent.bcontent}</div>
				<div class="board_tag">TAG : <c:out value="${boardContent.btag}"/></div>
			</div>
			<div style="margin-top : 20px">
				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>

	</article>

</body>
</html>