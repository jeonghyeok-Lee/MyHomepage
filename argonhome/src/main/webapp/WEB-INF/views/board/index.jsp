<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ���</title>
</head>
<body>
	<h2>board list</h2>
	<table>
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


</body>
</html>