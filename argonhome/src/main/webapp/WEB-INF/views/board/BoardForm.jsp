<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%--해당 태그라이브러리를 추가해줌으로써 태그 작성가능 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
<script>
	$(document).on('click', '#btnSave', function(e){	// 버튼클릭시 
		e.preventDefault();
		$("#form").submit();							//form이라는 id를 가진 객체를 서버에 전송
	});

	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		location.href="${pageContext.request.contextPath}/board/getBoardList";
	});
	
 	$(document).ready(function(){
		var mode = '<c:out value="${mode}"/>';
		if ( mode == 'edit'){			//입력 폼 셋팅
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
			<%-- 스프링2.0부터 지원되는 태그로 기존 HTML태그가 아닌 아래와 같은 형식으로 작성 --%>
			<form:form name="form" id="form" role="form" modelAttribute="boardVO" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
				<form:hidden path="bid"/>
				<input type="hidden" name="mode"/>
			
				<div class="mb-3">
					<label for="title">제목</label>
					<form:input path="btitle" id="btitle" class="form-control" placeholder="제목을 입력해 주세요" />
				</div>
				
				<div class="mb-3">
					<label for="writer">작성자</label>
					<form:input path="bwriter" id="bwriter" class="form-control" placeholder="이름을 입력해 주세요"  />
				</div>

				<div class="mb-3">
					<label for="content">내용</label>
					<form:textarea path="bcontent" id="bcontent" class="form-control" rows="5" placeholder="내용을 입력해 주세요" />
				</div>

				<div class="mb-3">
					<label for="tag">TAG</label>
					<form:input path="btag" id="btag" class="form-control" placeholder="태그를 입력해 주세요" />
				</div>

			</form:form>

			<div >
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
	</article>
</body>
</html>