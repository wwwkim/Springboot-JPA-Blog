let index={
		init: function(){
			$("#btn-save").on("click",()=>{
				this.save();
			});
			
			$("#btn-login").on("click",()=>{
				this.login();
			});
			
			
		},

  save: function(){
	//alert('called function save');
	  let data={
			  username:$("#username").val(),
			  password:$("#password").val(),
			  email:$("#email").val()
	  }
	  
	  //console.log(data);
	  $.ajax({
		  type:"POST",
		  url:"/blog/api/user",
		  data: JSON.stringify(data),
		  contentType:"application/json;charset=utf-8",
		  dataType:"json"
		  
	  }).done(function(resp){
		  alert("Sign in successfully");
		 // console.log(resp);
		  location.href="/blog";
		  
	  }).fail(function(error){
		  alert(JSON.stringify(error))
		  
	  });
},
login: function(){
	//alert('called function save');
	  let data={
			  username:$("#username").val(),
			  password:$("#password").val()
			  
	  }
	  

	  $.ajax({
		  type:"POST",
		  url:"/blog/api/user/login",
		  data: JSON.stringify(data),
		  contentType:"application/json;charset=utf-8",
		  dataType:"json"
		  
	  }).done(function(resp){
		  alert("Login successfully");
		  location.href="/blog";
		  
	  }).fail(function(error){
		  alert(JSON.stringify(error))
		  
	  });
}
}
index.init();