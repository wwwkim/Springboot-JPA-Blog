let index={
		init: function(){
			$("#btn-save").on("click",()=>{
				this.save();
			});
			
			$("#btn-delete").on("click",()=>{
				this.deleteById();
			});
			
			$("#btn-update").on("click",()=>{
				this.update();
			});
					
			$("#btn-reply-save").on("click",()=>{
				this.replySave();
			});
			
		},

  save: function(){
	// alert('called function save');
	  let data={
			  title:$("#title").val(),
			  content:$("#content").val()
			  
	  }
	
	  $.ajax({
		  type:"POST",
		  url:"/api/board",
		  data: JSON.stringify(data),
		  contentType:"application/json;charset=utf-8",
		  dataType:"json"
		  
	  }).done(function(resp){
		  alert("Saved content");
		
		  location.href="/";
		  
	  }).fail(function(error){
		  alert(JSON.stringify(error))
		  
	  });
  },
update: function(){
	  
	  let id=$("#id").val();
	
	  let data={
			  title:$("#title").val(),
			  content:$("#content").val()
			  
	  }
	
	  $.ajax({
		  type:"PUT",
		  url:"/api/board/"+id,
		  data: JSON.stringify(data),
		  contentType:"application/json;charset=utf-8",
		  dataType:"json"
		  
	  }).done(function(resp){
		  alert("Updated content");
		
		  location.href="/";
		  
	  }).fail(function(error){
		  alert(JSON.stringify(error))
		  
	  });
  },
  replySave: function(){

		  let data={
				userId:$("#userId").val(),
				boardId:$("#boardId").val(),
				  content:$("#reply-content").val()
				  
		  };
		 
		
		  $.ajax({
			  type:"POST",
			  url:`/api/board/${data.boardId}/reply`, //not single quotation(') but grave(`)
			  data: JSON.stringify(data),
			  contentType:"application/json;charset=utf-8",
			  dataType:"json"
			  
		  }).done(function(resp){
			  alert("Saved comment");
			
			  location.href=`/board/${data.boardId}`; //not single quotation(') but grave(`)
			  
		  }).fail(function(error){
			  alert(JSON.stringify(error))
			  
		  });
	  },
	  replyDelete: function(boardId, replyId){
		  
		  $.ajax({
			  type:"DELETE",
			  url:`/api/board/${boardId}/reply/${replyId}`, //not single quotation(') but grave(`)
			  dataType:"json"
				  
		  }).done(function(resp){
			  alert("Deleted comment");
			  location.href=`/board/${boardId}`; //not single quotation(') but grave(`)
			  
		  }).fail(function(error){
			  alert(JSON.stringify(error))
			  
		  });
	  },
		deleteById: function(){
			
			let id=$("#id").text();
			
			$.ajax({
				type:"DELETE",
				url:"/api/board/"+id,
				dataType:"json"
					
			}).done(function(resp){
				alert("Deleted!!");
				
				location.href="/";
				
			}).fail(function(error){
				alert(JSON.stringify(error))
				
			});
		}

}
index.init();