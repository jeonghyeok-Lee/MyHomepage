<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%--�ش� �±׶��̺귯���� �߰��������ν� �±� �ۼ����� --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
<script>
	$(document).on('click', '#btnSave', function(e){	// ��ưŬ���� 
		e.preventDefault();
		$("#form").submit();							//form�̶�� id�� ���� ��ü�� ������ ����
	});

	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		location.href="${pageContext.request.contextPath}/board/getBoardList";
	});
	
 	$(document).ready(function(){
		var mode = '<c:out value="${mode}"/>';
		if ( mode == 'edit'){			//�Է� �� ����
			$("#bwriter").prop('readonly', true);
			$("input:hidden[name='bid']").val(<c:out value="${boardContent.bid}"/>);
			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
			$("#bwriter").val('<c:out value="${boardContent.bwriter}"/>');
			$("#btitle").val('<c:out value="${boardContent.btitle}"/>');
			$("#bcontent").val('<c:out value="${fn:replace(boardContent.bcontent,/(?:\r\n|\r|\n)/g,'<br/>')}"/>');
			$("#btag").val('<c:out value="${boardContent.btag}"/>');
		}
	});

</script>

</head>
<body>

<article>
		<div class="container" role="main">
			<h2>board Form</h2>
			<%-- ������2.0���� �����Ǵ� �±׷� ���� HTML�±װ� �ƴ� �Ʒ��� ���� �������� �ۼ� --%>
			<form:form name="form" id="form" role="form" modelAttribute="boardVO" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
				<form:hidden path="bid"/>
				<input type="hidden" name="mode"/>
			
				<div class="mb-3">
					<label for="title">����</label>
					<form:input path="btitle" id="btitle" class="form-control" placeholder="������ �Է��� �ּ���" />
				</div>
				
				<div class="mb-3">
					<label for="writer">�ۼ���</label>
					<form:input path="bwriter" id="bwriter" class="form-control" placeholder="�̸��� �Է��� �ּ���"  />
				</div>

				<div class="mb-3">
					<label for="content">����</label>
					<form:textarea path="bcontent" id="bcontent" class="form-control" rows="5" placeholder="������ �Է��� �ּ���" />
				</div>

				<div class="mb-3">
					<label for="tag">TAG</label>
					<form:input path="btag" id="btag" class="form-control" placeholder="�±׸� �Է��� �ּ���" />
				</div>

			</form:form>

			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">����</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">���</button>
			</div>
		</div>
	</article>
</body>
</html>