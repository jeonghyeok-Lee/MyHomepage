/**
 * 
 */
	$(document).on('click', '#btnWriteForm', function(e) {
		e.preventDefault();
		location.href = "${pageContext.request.contextPath}/board/boardForm";
	});