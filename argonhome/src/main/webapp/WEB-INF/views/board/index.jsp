<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<!-- Bootstrap CSS CDN����� Ȱ��(��Ʈ��Ʈ�� �ٿ���ϰ�)-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<!-- ���� js/css���Ϸ� ���� -->
<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}
</style>
<script>
	$(document).on('click', '#btnWriteForm', function(e) {

		e.preventDefault();

		location.href = "${pageContext.request.contextPath}/board/boardForm";

	});
</script>

<title>�Խ���</title>
</head>
<body>
	<article>
		<div class="container">
			<div class="table-responsive">
				<h2>board list</h2>
				<table class="table table-striped table-sm">
					<colgroup>
						<col style="width: 5%" />
						<col style="width: auto" />
						<col style="width: 15%" />
						<col style="width: 10%" />
						<col style="width: 10%" />
					</colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>����</th>
							<th>�ۼ���</th>
							<th>��ȸ��</th>
							<th>�ۼ���</th>
						</tr>
					</thead>
					<tbody>
						<!-- c:choose -> if else if���� ���� ��(c:when(����1) c:when(����)) -->
						<c:choose>
							<c:when test="${empty boardList}">
								<tr>
									<td colspan="5" align="center">�����Ͱ� �����ϴ�.</td>
								</tr>
							</c:when>
							<c:when test="${!empty boardList}">
								<c:forEach var="list" items="${boardList}">
									<tr>
										<td><c:out value="${list.bid}" /></td>
										<td><c:out value="${list.btitle}" /></td>
										<td><c:out value="${list.bwriter}" /></td>
										<td><c:out value="${list.bview_cnt}" /></td>
										<td><c:out value="${list.bwrite_dy}" /></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div>
				<button type="button" class="btn btn-sm btn-primary"
					id="btnWriteForm">�۾���</button>
			</div>
		</div>
	</article>


</body>
</html>