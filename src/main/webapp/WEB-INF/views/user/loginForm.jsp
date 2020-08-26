<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">
  <h2>Login form</h2>
  <form action="#" method="POST">
    <div class="form-group">
      <label for="username">User name:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter User name " name="username">
    </div>
    
  
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" >
    </div>
    
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
  </form>
</div>

<script src="/js/user.js"></</script>
<%@ include file="../layout/footer.jsp"%>


 