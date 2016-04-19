<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" />'/> 
</head>
<body>
<div><jsp:include page="template/header.jsp"></jsp:include></div>
<div align="center"><jsp:include page="template/navigation.jsp"></jsp:include></div>
	
	<form:form name="searchResultForm" class="search-form" modelAttribute="vehicleMasterForm" method="POST" action="saveVehicleMaster">
		<div class="table">
		    <div class="table-title"><p>Vehicle Details</p></div>
		    <div class="row">		    
		    		<div class="table">					    
					    <div class="row">
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Type:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleType}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;">Unit Number:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.unitNumber}"></c:out></div>
					       
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;"> Logistic Mode:</div>
					       <div class="cell table-data addborderleft addbordertop" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.logisticMode}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop" style="height: 35px;vertical-align: middle;">Registration Number:</div>
					       <div class="cell table-data addborderleft addbordertop addborderright" style="height: 35px;vertical-align: middle;">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.registrationNumber}"></c:out></div>					        
					    </div>
					    <div class="row">					       
					       <div class="cell table-label addborderleft addbordertop"> Status:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleStatus}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop"> Make:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleMake}"></c:out></div>
						   <div class="cell table-label addborderleft addbordertop"><p> Model:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleModel}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop"> Model Year:</div>
					       <div class="cell table-data addborderleft addbordertop addborderright">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleModelYear}"></c:out></div>					       
					    </div>					    
					     <div class="row">
					       <div class="cell table-label addborderleft addbordertop"> Engine Number:</div>
					       <div class="cell table-data addborderleft  addbordertop">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleEngineNumber}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop"><p> Chassis Number:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleChassisNumber}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop addborderbottom"> No. of Tyres:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleNumOfTyres}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop addborderbottom"> Length(mts):</div>
					       <div class="cell table-data addborderleft addborderright addbordertop addborderbottom ">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleLength}"></c:out></div>					       
					    </div>
					     <div class="row">
					       <div class="cell table-label addborderleft addbordertop addborderbottom"><p> Hauling Capacity:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleHaulingCapacity}"></c:out></div>
					       <div class="cell table-label addborderleft addbordertop addborderbottom"> Hauling Type:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
					       	<c:out value="${vehicleMasterForm.vehicleInformation.vehicleHaulingType}"></c:out></div>					       
					    </div>
					</div>
		    	</div>
		</div>
		<div class="table" style="width: 100%">
		    <div class="table-title"><p>Vehicle Finance Details</p></div>
		    <div class="row">
		        <div class="cell table-label addborderleft addbordertop ">Finance Company Name:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.financeCompanyName}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop "><p>Company Address:</p></div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.addressLine1}"></c:out>
		        	<c:out value="${vehicleMasterForm.vehicleFinance.addressLine2}"></c:out>
		        	<c:out value="${vehicleMasterForm.vehicleFinance.city}"></c:out>
		        	<c:out value="${vehicleMasterForm.vehicleFinance.stateCode}"></c:out>
		        	<c:out value="${vehicleMasterForm.vehicleFinance.country}"></c:out>
		        	<c:out value="${vehicleMasterForm.vehicleFinance.postalCode}"></c:out>
		        </div>
		        <div class="cell table-label addborderleft addbordertop "><p>Contact Name:</p></div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.contactName}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop "><p>Contact Phone:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.contactNumber}"></c:out></div>		        
		    </div>
		    <div class="row">
		        <div class="cell table-label addborderleft addbordertop ">Principal Amount:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.principalAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop "><p>Loan Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.loanAmount}"></c:out></div>
				<div class="cell table-label addborderleft addbordertop "><p>Total Loan Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.totalLoanAmount}"></c:out></div>		        	
		        <div class="cell table-label addborderleft addbordertop "><p>Rate Of Interest:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.rateOfInterest}"></c:out></div>		        		        		        
		    </div>
		    <div class="row">		       
		    	<div class="cell table-label addborderleft addbordertop "><p>No. of Months:</p></div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.numberOfMonths}"></c:out></div>
				<div class="cell table-label addborderleft addbordertop ">Loan Due Date:</div>
		        <div class="cell table-data addborderleft addbordertop ">		        	
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleFinance.loanDueDate}" /></div>		        	
		        <div class="cell table-label addborderleft addbordertop "><p>EMI Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.emiAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom">EMI Due Date:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright addborderbottom">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleFinance.emiDueDate}" /></div>		        	        		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Last Paid Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.currentPaidAmount}"></c:out></div>	
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Last Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">		        	
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleFinance.currentPaidDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Balance Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderright addborderbottom">
		        	<c:out value="${vehicleMasterForm.vehicleFinance.balanceAmount}"></c:out></div>
		        <div class="cell"><p></p></div>		        
		    </div>
		    
		</div>
		<div class="table" style="width: 100%">
		    <div class="table-title"><p>Vehicle Permit and Insurance Details</p></div>
		    <div class="row">
		        <div class="cell table-label addborderleft addbordertop">National Tax Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<c:out value="${vehicleMasterForm.vehicleNationalTax.nationalTaxAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop"><p>From Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">		        	
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleNationalTax.nationalTaxStartDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop"><p>To Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleNationalTax.nationalTaxEndDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Indicator:</p></div>
		        <c:if test="${vehicleMasterForm.vehicleNationalTax.nationalTaxFlag eq 'G'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleMasterForm.vehicleNationalTax.nationalTaxFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleMasterForm.vehicleNationalTax.nationalTaxFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>		        
		    </div>	
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop"><p>Last Paid Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<c:out value="${vehicleMasterForm.vehicleNationalTax.currentNationalPaidAmount}"></c:out></div>	
		        <div class="cell table-label addborderleft addbordertop">Last Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
					<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleNationalTax.currentNationalPaidDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop"><p>Balance Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<c:out value="${vehicleMasterForm.vehicleNationalTax.nationalTaxBalanceAmount}"></c:out></div>	
		        <div class="cell"><p></p></div>		        	        		        
		    </div>	   
		    <div class="row"><div class="cell colspan" ></div></div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop">State Tax Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<c:out value="${vehicleMasterForm.vehicleStateTax.stateTaxAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop"><p>From Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleStateTax.stateTaxStartDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop"><p>To Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleStateTax.stateTaxEndDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Indicator:</p></div>
		        <c:if test="${vehicleMasterForm.vehicleStateTax.stateTaxFlag eq 'G'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleMasterForm.vehicleStateTax.stateTaxFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleMasterForm.vehicleStateTax.stateTaxFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>				        		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop"><p>Last Paid Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<c:out value="${vehicleMasterForm.vehicleStateTax.currentStatePaidAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop">Last Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleStateTax.currentStatePaidDate}" /></div>		        	
		        <div class="cell table-label addborderleft addbordertop"><p>Balance Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<c:out value="${vehicleMasterForm.vehicleStateTax.stateTaxBalanceAmount}"></c:out></div>
		        <div class="cell"><p></p></div>		     	        		        
		    </div>
		    <div class="row"><div class="cell colspan " ></div></div>		   
		    <div class="row">		       
		      <div class="cell table-label addborderleft addbordertop">National Permit Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<c:out value="${vehicleMasterForm.vehicleNationalPermit.nationalPermitAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop"><p>From Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleNationalPermit.nationalPermitStartDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop"><p>To Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleNationalPermit.nationalPermitEndDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Indicator:</p></div>
		        <c:if test="${vehicleMasterForm.vehicleNationalPermit.nationalPermitFlag eq 'G'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleMasterForm.vehicleNationalPermit.nationalPermitFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleMasterForm.vehicleNationalPermit.nationalPermitFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>		    		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop"><p>Last Paid Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<c:out value="${vehicleMasterForm.vehicleNationalPermit.currentPermitPaidAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop">Last Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleNationalPermit.currentPermitPaidDate}" /></div>	
		        <div class="cell table-label addborderleft addbordertop"><p>Balance Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<c:out value="${vehicleMasterForm.vehicleNationalPermit.nationalPermitBalanceAmount}"></c:out></div>
		        <div class="cell"><p></p></div>		              		        
		    </div>
		    <div class="row"><div class="cell colspan" ></div></div>
		    <div class="row">		       
		      <div class="cell table-label addborderleft addbordertop">Vehicle Insurance Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<c:out value="${vehicleMasterForm.vehicleInsurance.insuranceAmount}"></c:out></div>
		        <div class="cell table-label addborderleft addbordertop"><p>From Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleInsurance.insuranceStartDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop"><p>To Date:</p></div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleInsurance.insuranceEndDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Indicator:</p></div>
		        <c:if test="${vehicleMasterForm.vehicleInsurance.insuranceFlag eq 'G'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleMasterForm.vehicleInsurance.insuranceFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleMasterForm.vehicleInsurance.insuranceFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>			    		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Last Paid Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">
		        	<c:out value="${vehicleMasterForm.vehicleInsurance.currentInsurancePaidAmount}"></c:out></div>	
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">
		        	<fmt:formatDate pattern="dd-MMM-yyyy" value="${vehicleMasterForm.vehicleInsurance.currentInsurancePaidDate}" /></div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Balance Amount:</p></div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
		        	<c:out value="${vehicleMasterForm.vehicleInsurance.insuranceBalanceAmount}"></c:out></div>
		        <div class="cell"><p></p></div>		        	        
		    </div>
		    
		</div>
	 
		  
    </form:form>
</body>
<jsp:include page="template/footer.jsp"></jsp:include>
</html>