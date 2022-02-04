<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- 
�ݺ����� URL �����(var url = "${pageContext.request.contextPath}/board/getBoardList")���� c:url�� �̿��Ͽ� ���� ����ó�� ����
param���̿��Ͽ� �Ű������� ���� ������ ����
-->
<c:url var="getBoardListURL" value="/board/getList">
	<c:param name="page" value="${pagination.getPage()}"/>
	<c:param name="range" value="${pagination.getRange()}"/>
</c:url>
<meta charset="EUC-KR">
<script>
	$(document).on('click', '#btnWriteForm', function(e) {
		e.preventDefault();
		location.href = "${pageContext.request.contextPath}/board/boardForm";

	});
	
	function contentView(bid){
		var url = "${pageContext.request.contextPath}/board/getBoardContent";
		url = url + "?bid=" +bid;
		location.href = url;
	}
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
										<td><a href="#"
											onClick="contentView(<c:out value="${list.bid}" />)"> <c:out
													value="${list.btitle}" />
										</a></td>
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
			<!-- ���� ��� �Խù��� �� ������ ���� �ʿ� -->
			<!-- pagination{s} -->
			<div id="paginationBox">
				<ul class="pagination">
					<c:if test="${pagination.prev}">
						<li class="page-item"> <!-- ��Ʈ��Ʈ������ ���Ǵ� ����¡�� ���� ��Ÿ�Ͻ�Ʈ �⺻ ���� -->
							<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
					</c:if>
					<!-- ����/���� ��ư�� ���� ���� -->
					<c:forEach begin="${pagination.startPage}"		
						end="${pagination.endPage}" var="idx">
						<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
							<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">${idx}</a>
						</li>
					</c:forEach>
					
					<c:if test="${pagination.next}">
						<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Next</a></li>
					</c:if>
				</ul>
			</div>
			<!-- pagination{e} -->
			
			<div>
				<button type="button" class="btn btn-sm btn-primary"
					id="btnWriteForm">�۾���</button>
			</div>
		</div>
	</article>


</body>
</html>