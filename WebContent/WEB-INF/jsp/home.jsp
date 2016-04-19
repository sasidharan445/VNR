<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" />'/> 
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://cdn.jsdelivr.net/pixastic/0.1.3/pixastic.all.js"></script>
<script src='<c:url value="/resources/script/home.js" />'></script>
</head>
<jsp:include page="template/header.jsp"></jsp:include>
<jsp:include page="template/navigation.jsp"></jsp:include>
<body>

<h3 align="center">	Welcome to VNR Auto Logistics </h3>	
	<div class="slideshow-container">
         <div class="slides">
             <img src='<c:url value="/resources/image/truck1.jpg" />' />
             <img src='<c:url value="/resources/image/truck2.jpg" />' />
             <img src='<c:url value="/resources/image/truck3.jpg" />' />
             <img src='<c:url value="/resources/image/truck4.jpg" />' />             
         </div>
         <canvas id="slideshow" width="750" height="500"></canvas>
     </div>     
	
</body>
<jsp:include page="template/footer.jsp"></jsp:include>
</html>
