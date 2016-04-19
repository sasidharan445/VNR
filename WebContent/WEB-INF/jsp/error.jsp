<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" />'/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<div><jsp:include page="template/header.jsp"></jsp:include></div>
<div align="center"><jsp:include page="template/navigation.jsp"></jsp:include></div>
<p class="error">An error occurred. Please contact the administrator</p>
</body>
<jsp:include page="template/footer.jsp"></jsp:include>
</html>