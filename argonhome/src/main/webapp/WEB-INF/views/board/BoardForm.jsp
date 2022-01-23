<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
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
</script>

<body>
<article>
		<div class="container" role="main">
			<h2>board Form</h2>
			<form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
				<div class="mb-3">
					<label for="title">����</label>
					<input type="text" class="form-control" name="title" id="title" placeholder="������ �Է��� �ּ���">
				</div>
				
				<div class="mb-3">
					<label for="reg_id">�ۼ���</label>
					<input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="�̸��� �Է��� �ּ���">
				</div>

				<div class="mb-3">
					<label for="content">����</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="������ �Է��� �ּ���" ></textarea>

				</div>

				<div class="mb-3">
					<label for="tag">TAG</label>
					<input type="text" class="form-control" name="tag" id="tag" placeholder="�±׸� �Է��� �ּ���">
				</div>
			</form>

			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">����</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">���</button>
			</div>
		</div>
	</article>
</body>
</html>