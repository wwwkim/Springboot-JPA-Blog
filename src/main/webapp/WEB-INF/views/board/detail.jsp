<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div>
		Content No.<span id="id"><i>${board.id} </i></span>
		Writer :<span id="id"><i>${board.user.username} </i></span>
		<br><br>
		
	
	</div>

	<div class="form-group">

		<h3>${board.title}</h3>
	</div>
	<hr>
	<div class="form-group">

		<div>${board.content}</div>
	</div>

	<hr>
	<button class="btn btn-secondary" onclick="history.back()">Back</button>
	<c:if test="${board.user.id==principal.user.id }">
	<button id="btn-update" class="btn btn-warning">Rewrite</button>
	<button id="btn-delete" class="btn btn-danger">Delete</button>
	</c:if>
</div>


<script>
	$('.summernote').summernote({
		placeholder : 'Hello Bootstrap 4',
		tabsize : 2,
		height : 300
	});
</script>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>


