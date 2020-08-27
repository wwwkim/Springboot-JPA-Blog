let index={
		init: function(){
			$("#btn-save").on("click",()=>{
				this.save();
			});
			
					
		},

  save: function(){
	//alert('called function save');
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
  }

}
index.init();