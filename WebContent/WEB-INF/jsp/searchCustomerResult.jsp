<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" />'/> 
<title>Insert title here</title>
</head>
<body>
<div><jsp:include page="template/header.jsp"></jsp:include></div>
<div align="center"><jsp:include page="template/navigation.jsp"></jsp:include></div>
	<form:form name="searchResultForm" class="search-form" modelAttribute="customerMasterForm" method="POST" action="saveCustomerMaster">
	<div class="table">
		    <div class="table-title"><p>Customer Information</p></div>
		    <div class="row">		    
		    		<div class="table">					    
					    <div class="row">
					       
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Customer Name:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.customerName}"></c:out></div>
					       	
					       	<div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">Customer Contact Name:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.customerContactName}"></c:out></div>
					       	
					       	<div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">Customer Contact Number:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.customerContactNumber}"></c:out></div>
					       	
					       	<div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">Customer Contact EMAIL ID:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.customerContactEmailId}"></c:out></div>					       	
					    </div>
					       	
					    <div class="row">					    
					    <div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;"> Customer Address:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.customerAddressLine1}"></c:out>
					       	<c:out value="${customerMasterForm.customerInformation.customerAddressLine2}"></c:out>
					       	<c:out value="${customerMasterForm.customerInformation.city}"></c:out>
					       	<c:out value="${customerMasterForm.customerInformation.state}"></c:out>					       	
					       	<c:out value="${customerMasterForm.customerInformation.country}"></c:out>					       	
					       	<c:out value="${customerMasterForm.customerInformation.postalCode}"></c:out>
					       </div>
					    </div>
				<br>
				</br>
					     
					    <div class="row">
										       
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Billing Customer Name:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.billingCustomerName}"></c:out></div>
					       	
					       	<div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">Billing Customer Contact Name:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.billingCustomerContactName}"></c:out></div>
					       	
					       	<div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">Billing Customer Contact Number:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.billingCustomerContactNumber}"></c:out></div>
					       	
					       	<div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">Billing Customer EMAIL ID:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.billingCustomerEmailId}"></c:out></div>					       	
					    </div>
					    
					    
					    <div class="row">					    
					    <div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;"> Billing Customer Address:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${customerMasterForm.customerInformation.billingAddressLine1}"></c:out>
					       	<c:out value="${customerMasterForm.customerInformation.billingAddressLine2}"></c:out>
					       	<c:out value="${customerMasterForm.customerInformation.billingCity}"></c:out>
					       	<c:out value="${customerMasterForm.customerInformation.billingState}"></c:out>					       	
					       	<c:out value="${customerMasterForm.customerInformation.billingCountry}"></c:out>					       	
					       	<c:out value="${customerMasterForm.customerInformation.billingPostalCode}"></c:out>
					       </div>
					    </div>
					</div>				  					   
				</div>       	
		  </div>	       	
				       		    	    
				<br>
				</br>
					     
	<div class="table">
		    <div class="table-title"><p>Contract Information</p></div>
		    <div class="row">		    
		    		<div class="table">					    
					    <div class="row">
					      
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Contract Type:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.contractType}"></c:out></div>
					       	
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Contract Agreement Number:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.contractAgreementNumber}"></c:out></div>
					       
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Contract Issued Date:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.contractIssuedDate}" ></c:out></div>
					       
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Hauling Type:</div>
					       <div class="cell table-data addborderleft addbordertop addborderright" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.haulingType}"></c:out></div>
					       
						 </div>
			        		 
			        		 
					    <div class="row">
					      
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Agreed Capacity:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.agreedCapacity}"></c:out></div>
					       	
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Valid From:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       <fmt:formatDate pattern="dd-MMM-yyyy" value="${customerMasterForm.contractInformation.validFrom}" /></div>
					       
					       <div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;"> Valid Till:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.validTill}"></c:out></div>
					       
					       <div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;"> Commitment To Customer:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.commitmentToCustomer}"></c:out></div>
					       
						 </div>
			          
			              
					    <div class="row">
					      
					       <div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;"> Contract Issued By:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.contractIssuedBy}"></c:out></div>
					       	
					       <div class="cell table-label addborderleft addbordertop addborderbottom" style="height: 35px;vertical-align: middle;"> Contract Signed By:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="height: 35px;vertical-align: middle;">
					       <c:out value="${customerMasterForm.contractInformation.contractSignedBy}"></c:out></div>
					       
						 </div>
			             
					</div>
				</div>				  			   
			</div>       	       	     	
	</form:form>		
</body>
</html>