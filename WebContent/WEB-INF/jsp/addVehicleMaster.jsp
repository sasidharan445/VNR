<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" />'/> 
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
<script type="text/javascript"  src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"  src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript" src='<c:url value="/resources/script/vehicleMaster.js" />'></script>
<script src='<c:url value="/resources/script/script.js" />'></script>
<script type="text/javascript">
	function getContextPath() {
	 return '${pageContext.request.contextPath}';
	}
</script>
</head>

<body>
<div><jsp:include page="template/header.jsp"></jsp:include></div>
<div align="center"><jsp:include page="template/navigation.jsp"></jsp:include></div>
	
	<form:form name="addVehicleFinanceForm" class="search-form" modelAttribute="vehicleMasterForm" method="POST" action="addVehicleMaster">			
		<div class="table">		  
			<div class="error" style="float: left;"> ${message}</div>
		    <div class="row">
		    	<div class="cell">
		    		<div class="table" style="width: 30%; float: left;">
					    <div class="row">	
					       <div class="cell table-label addborderleft addbordertop addborderbottom">Select Vehicle Type:</div>
					       <div class="cell table-data addborderleft addbordertop addborderright addborderbottom" >
					       	<form:select path="selectedVehicleType" class="select-form-input" id="vehicleTypeId">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${vehicleTypeList}"></form:options>	
    								<form:option value="PTR">Prime Mover and Trailer</form:option>    								
					       		</form:select>						       		
						   </div>				    					       			       			       
					    </div>
					    <div class="row">
					       <div id="truckUN">
						       <div class="cell table-label addborderleft  addborderbottom" style="width: 100%;">Truck Unit Number:</div>
						       <div class="cell table-data addborderleft  addborderbottom addborderright" >
						       	<form:select id="truckUnitNumberId" path="truckUnitNumber" cssClass="select-form-input">
						       			<form:option value=""> --SELECT--</form:option>
	    								<form:options items="${truckList}"></form:options>	
						       		</form:select>
						       		<form:errors path="truckUnitNumber" cssClass="error" />		
							   </div>
						   </div>
						   <div id="primeMoverUN">
						   <div class="cell table-label addborderleft  addborderbottom" style="width: 100%;">Prime Mover Unit Number:</div>
					       <div class="cell table-data addborderleft  addborderbottom addborderright" >
					       	<form:select id ="primeMoverUnitNumberId" path="primeMoverUnitNumber" cssClass="select-form-input">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${primeMoverList}"></form:options>	
					       		</form:select>
					       		<form:errors path="primeMoverUnitNumber" cssClass="error" />	
						   </div>
						   </div>
						   <div id="trailerUN">
						   <div class="cell table-label addborderleft  addborderbottom" style="width: 100%;">Trailer Unit Number:</div>
					       <div class="cell table-data addborderleft  addborderbottom addborderright" >
					       	<form:select id="trailerUnitNumberId" path="trailerUnitNumber" cssClass="select-form-input">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${trailerList}"></form:options>	
					       		</form:select>	
					       		<form:errors path="trailerUnitNumber" cssClass="error" />
						   </div>
						   </div>
					    </div>   
					</div>
		    	</div>		    		    	
		    </div>
		</div>
		<div id="financeSectionId" class="table" style="width: 100%">
		    <div class="table-title"><h4>Vehicle Finance Details</h4></div>
		    <div class="row">
		        <div class="cell table-label addborderleft addbordertop ">Finance Company Name:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="companyName" class="search-form-input" placeholder="Company Name" path="vehicleFinance.financeCompanyName" maxlength="45"></form:input>
		        	<form:errors path="vehicleFinance.financeCompanyName" cssClass="error" />
		        </div>		      
		        <div class="cell table-label addborderleft addbordertop ">Contact Name:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="contactName" class="search-form-input" placeholder="Contact Name" path="vehicleFinance.contactName" maxlength="45"></form:input>
		        	<form:errors path="vehicleFinance.contactName" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop ">Contact Number:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<form:input id="contactPhone" class="search-form-input" placeholder="Contact Phone" 
		        		onkeypress='return allowOnlyNum(event)' path="vehicleFinance.contactNumber" maxlength="12"></form:input>
		        	<form:errors path="vehicleFinance.contactNumber" cssClass="error" />		        
		        </div>
		    </div>
		    <div class="row">		        
		        <div class="cell table-label addborderleft addbordertop "><p>Company Address:</p></div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="addressLine1Id" class="search-form-input" placeholder="Address Line1" path="vehicleFinance.addressLine1" maxlength="45"></form:input>
		        	<form:errors path="vehicleFinance.addressLine1" cssClass="error" />
		        </div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="addressLine2Id" class="search-form-input" placeholder="Address Line2" path="vehicleFinance.addressLine2" maxlength="45"></form:input>
		        </div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="cityId" class="search-form-input" placeholder="City" path="vehicleFinance.city" maxlength="25"></form:input>
		        	<form:errors path="vehicleFinance.city" cssClass="error" />
		        </div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="stateNameId" class="search-form-input" placeholder="State" path="vehicleFinance.stateName" maxlength="25"></form:input>
		        	<form:errors path="vehicleFinance.stateName" cssClass="error" />
		        </div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="countryId" class="search-form-input" style="background-color: #e1e1e1;" placeholder="Country" path="vehicleFinance.country" value="India" readonly="true"></form:input>
		        </div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<form:input id="postalCodeId" class="search-form-input" placeholder="Postal Code" 
		        		onkeypress='return allowOnlyNum(event)' path="vehicleFinance.postalCode" maxlength="6"></form:input>
		        	<form:errors path="vehicleFinance.postalCode" cssClass="error" />
		        </div>		        		        
		    </div>
		    <div class="row">
		        <div class="cell table-label addborderleft addbordertop">Principal Amount:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="principalAmountId" class="search-form-input" placeholder="Principal Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleFinance.principalAmount"></form:input>
		        	<form:errors path="vehicleFinance.principalAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop ">Loan Amount:</div>
		        <div class="cell table-data addborderleft addbordertop ">
					<form:input id="loanAmountId" class="search-form-input" placeholder="Loan Amount" maxlength="12"
						onkeypress='return isNumberWithDecimal(event)' path="vehicleFinance.loanAmount"></form:input>
					<form:errors path="vehicleFinance.loanAmount" cssClass="error" />
				</div>
		        <div class="cell table-label addborderleft addbordertop ">Rate Of Interest:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="rateOfInterestId" class="search-form-input" placeholder="Rate Of Interest" maxlength="5"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleFinance.rateOfInterest"></form:input>
		        	<form:errors path="vehicleFinance.rateOfInterest" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop ">No. of Months:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<form:input id="numberOfMonthsId" class="search-form-input" placeholder="No. of Months" maxlength="3"
		        		onkeypress='return allowOnlyNum(event)' path="vehicleFinance.numberOfMonths"></form:input>
		        	<form:errors path="vehicleFinance.numberOfMonths" cssClass="error" />		        		        
		        </div>
		    </div>
		    <div class="row">		       
		    	<div class="cell table-label addborderleft addbordertop ">Total Loan Amount:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="totalLoanAmountId" class="search-form-input" placeholder="Total Loan Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleFinance.totalLoanAmount"></form:input>
		        	<form:errors path="vehicleFinance.totalLoanAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop ">Loan Due Date:</div>
				<div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="loanDueDateId" class="search-form-input datepick" placeholder="Loan Due Date" 
		        		maxlength="10" path="vehicleFinance.loanDueDate"></form:input>
		        	<form:errors path="vehicleFinance.loanDueDate" cssClass="error" />			        	
		        </div>
		        <div class="cell table-label addborderleft addbordertop ">EMI Amount:</div>
		        <div class="cell table-data addborderleft addbordertop ">
		        	<form:input id="emiAmountId" class="search-form-input" placeholder="EMI Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleFinance.emiAmount"></form:input>
		        	<form:errors path="vehicleFinance.emiAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom">EMI Due Date:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright addborderbottom">
		        	<form:input id="emiDueDateId" class="search-form-input datepick" placeholder="EMI Due Date" 
		        		maxlength="10" path="vehicleFinance.emiDueDate"></form:input>
		        	<form:errors path="vehicleFinance.emiDueDate" cssClass="error" />
		        </div>		        		        	        		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Paid Amount:</div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">
		        	<form:input id="vfCurrentPaidAmountId" class="search-form-input" placeholder="Paid Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleFinance.currentPaidAmount"></form:input>
		        	<form:errors path="vehicleFinance.currentPaidAmount" cssClass="error" />
		        </div>	
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">
		        	<form:input id="vfCurrentPaidDateId" class="search-form-input datepick" placeholder="Paid Date" 
		        		maxlength="10" path="vehicleFinance.currentPaidDate"></form:input>
		        	<form:errors path="vehicleFinance.currentPaidDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Balance Amount:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright addborderbottom">
		        	<form:input id="vfBalanceAmountId" style="background-color: #e1e1e1;" class="search-form-input" 
		        		placeholder="Balance Amount" path="vehicleFinance.balanceAmount" readonly="true"></form:input></div>
		         		        
		    </div>		   
		</div>
		<div id="permitInsuranceSectionId" class="table" style="width: 100%">
		    <div class="table-title"><h4>Vehicle Permit and Insurance Details</h4></div>
		    <div class="row">
		        <div class="cell table-label addborderleft addbordertop">National Tax Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="nationalTaxAmountId" class="search-form-input" placeholder="National Tax Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleNationalTax.nationalTaxAmount"></form:input>
		        	<form:errors path="vehicleNationalTax.nationalTaxAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">From Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="nationalTaxStartDateId" class="search-form-input datepick" placeholder="Start Date" 
		        	maxlength="10"	path="vehicleNationalTax.nationalTaxStartDate"></form:input>
		        	<form:errors path="vehicleNationalTax.nationalTaxStartDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">To Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="nationalTaxEndDateId" class="search-form-input datepick" placeholder="End Date" 
		        		maxlength="10" path="vehicleNationalTax.nationalTaxEndDate"></form:input>
		        	<form:errors path="vehicleNationalTax.nationalTaxEndDate" cssClass="error" />
		        </div>		        
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Indicator:</div>		        
		        <c:if test="${vehicleNationalTax.nationalTaxFlag eq 'G' or empty vehicleNationalTax.nationalTaxFlag}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleNationalTax.nationalTaxFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleNationalTax.nationalTaxFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>
		        		        
		    </div>	
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop">Paid Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="currentNationalPaidAmountId" class="search-form-input" placeholder="Paid Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleNationalTax.currentNationalPaidAmount"></form:input>
		        	<form:errors path="vehicleNationalTax.currentNationalPaidAmount" cssClass="error" />
		        </div>	
		        <div class="cell table-label addborderleft addbordertop">Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="currentNationalPaidDateId" class="search-form-input datepick" placeholder="Paid Date" 
		        		maxlength="10" path="vehicleNationalTax.currentNationalPaidDate"></form:input>
		        	<form:errors path="vehicleNationalTax.currentNationalPaidDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">Balance Amount:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
					<form:input id="nationalTaxBalanceAmountId" style="background-color: #e1e1e1;" class="search-form-input" placeholder="Balance Amount" path="vehicleNationalTax.nationalTaxBalanceAmount" readonly="true"></form:input></div>
		       		        
		    </div>	   
		    <div class="row"><div class="cell colspan" ></div></div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop">State Tax Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="stateTaxAmountId" class="search-form-input" placeholder="State Tax Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleStateTax.stateTaxAmount"></form:input>
		        	<form:errors path="vehicleStateTax.stateTaxAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">From Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="stateTaxStartDateId" class="search-form-input datepick" placeholder="State Tax Start Date" 
		        		maxlength="10" path="vehicleStateTax.stateTaxStartDate"></form:input>
		        	<form:errors path="vehicleStateTax.stateTaxStartDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">To Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="stateTaxEndDateId" class="search-form-input datepick" placeholder="State Tax End Date"
		        		maxlength="10" path="vehicleStateTax.stateTaxEndDate"></form:input>
		        	<form:errors path="vehicleStateTax.stateTaxEndDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Indicator:</div>
		        <c:if test="${vehicleStateTax.stateTaxFlag eq 'G' or empty vehicleStateTax.stateTaxFlag}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleStateTax.stateTaxFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleStateTax.stateTaxFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>			        		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop">Paid Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="currentStatePaidAmountId" class="search-form-input" placeholder="Paid Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleStateTax.currentStatePaidAmount"></form:input>
		        	<form:errors path="vehicleStateTax.currentStatePaidAmount" cssClass="error" />
		        </div>	
		        <div class="cell table-label addborderleft addbordertop">Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="currentStatePaidDateId" class="search-form-input datepick" placeholder="Paid Date" 
		        		maxlength="10" path="vehicleStateTax.currentStatePaidDate"></form:input>
		        	<form:errors path="vehicleStateTax.currentStatePaidDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">Balance Amount:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<form:input id="stateTaxBalanceAmountId" style="background-color: #e1e1e1;" class="search-form-input" placeholder="Balance Amount" path="vehicleStateTax.stateTaxBalanceAmount" readonly="true"></form:input></div>		        	        		       
		    </div>
		    <div class="row"><div class="cell colspan " ></div></div>		   
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop">National Permit Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="nationalPermitAmountId" class="search-form-input" placeholder="National Permit Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleNationalPermit.nationalPermitAmount"></form:input>
		        	<form:errors path="vehicleNationalPermit.nationalPermitAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">From Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="permitStartDateId" class="search-form-input datepick" placeholder="National Permit Start Date" 
		        		maxlength="10" path="vehicleNationalPermit.nationalPermitStartDate"></form:input>
		        	<form:errors path="vehicleNationalPermit.nationalPermitStartDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">To Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="permitEndDateId" class="search-form-input datepick" placeholder="National Permit End Date"
		        		maxlength="10" path="vehicleNationalPermit.nationalPermitEndDate"></form:input>
		        	<form:errors path="vehicleNationalPermit.nationalPermitEndDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Indicator:</p></div>
		        <c:if test="${vehicleNationalPermit.nationalPermitFlag eq 'G' or empty vehicleNationalPermit.nationalPermitFlag}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleNationalPermit.nationalPermitFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleNationalPermit.nationalPermitFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>			    		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop">Paid Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="currentPermitPaidAmountId" class="search-form-input" placeholder="Paid Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleNationalPermit.currentPermitPaidAmount"></form:input>
		        	<form:errors path="vehicleNationalPermit.currentPermitPaidAmount" cssClass="error" />
		        </div>		       
		        <div class="cell table-label addborderleft addbordertop">Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="currentPermitPaidDateId" class="search-form-input datepick" placeholder="Paid Date"
		        		maxlength="10" path="vehicleNationalPermit.currentPermitPaidDate"></form:input>
		        	<form:errors path="vehicleNationalPermit.currentPermitPaidDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">Balance Amount:</div>
		        <div class="cell table-data addborderleft addbordertop addborderright">
		        	<form:input id="permitBalanceAmountId" style="background-color: #e1e1e1;" class="search-form-input" 
		        		maxlength="10" placeholder="Balance Amount" path="vehicleNationalPermit.nationalPermitBalanceAmount" readonly="true"></form:input></div>		        	        		        
		    </div>
		    <div class="row"><div class="cell colspan" ></div></div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop">Vehicle Insurance Amount:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="insuranceAmountId" class="search-form-input" placeholder="Insurance Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleInsurance.insuranceAmount"></form:input>
		        	<form:errors path="vehicleInsurance.insuranceAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">From Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="insuranceStartDateId" class="search-form-input datepick" placeholder="Insurance Start Date" 
		        		maxlength="10" path="vehicleInsurance.insuranceStartDate"></form:input>
		        	<form:errors path="vehicleInsurance.insuranceStartDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop">To Date:</div>
		        <div class="cell table-data addborderleft addbordertop">
		        	<form:input id="insuranceEndDateId" class="search-form-input datepick" placeholder="Insurance End Date" 
		        		maxlength="10" path="vehicleInsurance.insuranceEndDate"></form:input>
		        	<form:errors path="vehicleInsurance.insuranceEndDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Indicator:</p></div>
		        <c:if test="${vehicleInsurance.insuranceFlag eq 'G' or empty vehicleInsurance.insuranceFlag}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: green;"></div>
		        </c:if>
		        <c:if test="${vehicleInsurance.insuranceFlag eq 'Y'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: yellow;"></div>
		        </c:if>
		         <c:if test="${vehicleInsurance.insuranceFlag eq 'R'}">
		        	<div class="cell table-data addborderleft addbordertop addborderbottom addborderright" style="background: red;"></div>
		        </c:if>			    		        
		    </div>
		    <div class="row">		       
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Paid Amount:</div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">
		        	<form:input id="currentInsurancePaidAmountId" class="search-form-input" placeholder="Paid Amount" maxlength="12"
		        		onkeypress='return isNumberWithDecimal(event)' path="vehicleInsurance.currentInsurancePaidAmount"></form:input>
		        	<form:errors path="vehicleInsurance.currentInsurancePaidAmount" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Paid Date:</div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom">
		        	<form:input id="insurancePaidDateId" class="search-form-input datepick" placeholder="Paid Date" 
		        		maxlength="10" path="vehicleInsurance.currentInsurancePaidDate"></form:input>
		        	<form:errors path="vehicleInsurance.currentInsurancePaidDate" cssClass="error" />
		        </div>
		        <div class="cell table-label addborderleft addbordertop addborderbottom">Balance Amount:</div>
		        <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
		        	<form:input id="insuranceBalanceAmountId" style="background-color: #e1e1e1;" class="search-form-input" 
		        		placeholder="Balance Amount" path="vehicleInsurance.insuranceBalanceAmount" readonly="true"></form:input></div>		        	        		        
		    </div>
		    
		</div>
		<div class="table" style="width: 100px; float: right">		    
		    <div id="saveBtnId" class="row">
		        <div class="cell">
		        	<form:button class="login-button" type="submit" name="addAction" value="Save">Save</form:button>
		        </div>		        		      
		    </div>	
		</div>
	 
		  
    </form:form>
</body>
<jsp:include page="template/footer.jsp"></jsp:include>
</html>
