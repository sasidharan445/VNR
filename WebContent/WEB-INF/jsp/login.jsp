<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" />'/> 
<title>VNR Auto Logistics - Login</title>
</head>
<body>
  <c:url var="post_url"  value="/j_spring_security_check" />
  <div class="container">
  <div class="form-container">
    <div class="error"> ${message}</div>      
    <form:form class="login-form" modelAttribute="loginForm" method="POST" action="${post_url}">
      <h3 class="title">Login</h3>
      <div class="form-group">
        <form:input id="loginName" class="form-input" tooltip-class="username-tooltip" placeholder="Username" path="loginName"></form:input>
        <span id="username-tool"class="tooltip username-tooltip">What's your username?</span>
      </div>
      <div class="form-group" id="password">
        <form:input type="password" class="form-input" path="password" placeholder="Password" ></form:input>
        <span class="tooltip">What's your password?</span>
      </div>
      <div class="form-group">
        <form:button class="login-button" type="submit">Login</form:button>        
      </div>     
    </form:form>
    <div class="loading">
      <div class="loading-spinner-large" style="display: none;"/>
      <div class="loading-spinner-small" style="display: none;"/>
    </div>
  </div>
</div>
</body>
<script>
  document.getElementById('loginName').focus();
</script>
</html>