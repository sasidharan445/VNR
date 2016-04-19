<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href='<c:url value="/resources/image/favicon.ico" />' type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" />'/> 
<link language="JavaScript1.2" type="text/javascript" href='<c:url value="/resources/script/script.js" />'/>
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
<script type="text/javascript"  src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"  src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {	
    $("#unitNumberId").autocomplete({
        source: function (request, response) {
            $.getJSON("${pageContext.request.contextPath}/unitNumberList", {
               term: request.term
            }, response);
        }
    });
 });
</script>
</head>
<body>
<div><jsp:include page="template/header.jsp"></jsp:include></div>
<div align="center"><jsp:include page="template/navigation.jsp"></jsp:include></div>
	<form:form name = "searchVehicleForm" class="search-form" modelAttribute="searchForm" method="POST" action="searchVehicle">      
	
      <div class="form-group">
      	<label id="unitNumberLabel" >Enter Unit Number:</label>
        <form:input id="unitNumberId" class="search-form-input" placeholder="Unit Number" path="unitNumber"></form:input>
        <form:button class="login-button" type="submit" name="submitAction" value="search">Search</form:button>    
        <form:button class="login-button" type="submit" name="submitAction" value= "add" style="width: 150px;">Add New Vehicle</form:button>    
        
      </div>
      
      <div class="error"> ${message}</div>
    </form:form>
</body>
<div align="center"><jsp:include page="template/footer.jsp"></jsp:include></div>
<script>
 // document.getElementById('unitNumber').focus();
</script>
</html>