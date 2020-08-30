<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<button class="btn btn-secondary" onclick="history.back()">Back</button>
	<c:if test="${board.user.id==principal.user.id }">
		<a href="/board/${board.id }/updateForm" class="btn btn-warning">Rewrite</a>
		<button id="btn-delete" class="btn btn-danger">Delete</button>
	</c:if>
	<br> <br>
	<div>
		Content No.<span id="id"><i>${board.id} </i></span> Writer :<span id="id"><i>${board.user.username} </i></span> <br> <br>
	</div>
	<div class="form-group">
		<h3>${board.title}</h3>
	</div>
	<hr>
	<div class="form-group">
		<div>${board.content}</div>
	</div>
	<hr>


	<div class="card">
		<form>
		<input type="hidden" id="userId" value="${principal.user.id}"/>
			<input type="hidden" id="boardId" value="${board.id }" />
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save"class="btn btn-primary">save comment</button>
			</div>
		</form>
	</div>
	<br> 
		<div class="card-header">Comment List</div>
		<ul id="reply--box" class="list-group">
			<c:forEach var="relpy" items="${board.replys }">
				<li id="reply--1" class="list-group-item d-flex justify-content-between">
					<div>${relpy.content}</div>
					<div class="d-flex">
						<div class="font-italic">Writer :${reply.user.username } &nbsp;</div>
						<button class="badge">Delete</button>
					</div>
				</li>
			</c:forEach>
		</ul>

	</div>
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


