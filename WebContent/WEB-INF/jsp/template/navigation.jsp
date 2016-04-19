<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/navigation.css" />'/>
<title>VNR Auto Logistics</title>
</head>
<body>    
	<div>
		<ul class="drop_menu">
			<li><a href='home'>Home</a></li>
			<li><a href='#'>File</a>
				<ul>
					<li><a href='#'>Reports</a></li>			
				</ul>
			</li>
			<li><a href='#'>Orders</a>
				<ul>
					<li><a href='#'>Trip Sheet</a></li>
					<li><a href='#'>Invoice</a></li>
					<li><a href='#'>Order Summary</a></li>			
				</ul>
			</li>
			<li><a href='#'>Vehicle</a>
				<ul>
					<li><a href='<c:url value="searchVehicle" />'>Vehicle Master</a></li>			
				</ul>
			</li>
			<li><a href='#'>Customer</a>
				<ul>
					<li><a href='#'>Customer Master</a></li>			
				</ul>
			</li>
			<li><a href='#'>Human Resources</a>
				<ul>
					<li><a href='#'>Employee Master</a></li>
					<li><a href='#'>Pay Stub</a></li>			
				</ul>
			</li>
			<li><a href='#'>Vendor</a>
				<ul>
					<li><a href='#'>Vendor Master</a></li>
					<li><a href='#'>Assign Procurement</a></li>
					<li><a href='#'>Purchase Order</a></li>			
				</ul>
			</li>
			<li><a href='#'>Inventory</a></li>
			<sec:authorize access="hasRole('ROLE_SYSTEM_ADMIN')">
				<li><a href='#'>Admin</a></li>
			</sec:authorize>
			<li><a href='#'>Help</a></li>
			<li><a href='<c:url value="/logout" />'>Log out</a></li>							
		</ul>	
	</div>
</body>