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
<script src='<c:url value="/resources/script/script.js" />'></script>
<script type="text/javascript">
	function getContextPath() {
	 return '${pageContext.request.contextPath}';
	}
	
	$(document).ready(function() {
		$('.datepick').each(function(){
	    	$(this).datepicker({  dateFormat: 'dd/mm/yy'  });
		});
	});
</script>
</head>

<body>
<div><jsp:include page="template/header.jsp"></jsp:include></div>
<div align="center"><jsp:include page="template/navigation.jsp"></jsp:include></div>
	
	<form:form name="addCustomerInformationForm" class="search-form" modelAttribute="customerMasterForm" method="POST" action="addCustomerMaster">			
		<div class="table">		
		
		  <div class="table-title"><p>Customer Information</p></div> 
			<div class="error" style="float: left;"> ${message}</div>
		    
		    		
			    <div class="row">				  
      			  <div class="cell table-label addborderleft addbordertop"  >Customer Name:</div>
      			  <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="customerName" class="search-form-input" placeholder="Customer Name" path="customerInformation.customerName" maxlength="100" ></form:input>
        			<form:errors path="customerInformation.customerName" cssClass="error" /></div>
        			
        			 <div class="cell table-label addborderleft addbordertop ">Customer Contact Name:</div>
      			 	 <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="customerContactName" class="search-form-input" placeholder="Contact Name" path="customerInformation.customerContactName" maxlength="100"></form:input>
        			<form:errors path="customerInformation.customerContactName" cssClass="error" /></div>
       			
        			 <div class="cell table-label addborderleft addbordertop ">Customer Contact Number:</div>
      			 	 <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="customerContactNumber" class="search-form-input" placeholder="Contact Number" path="customerInformation.customerContactNumber" maxlength="100"></form:input>
        			<form:errors path="customerInformation.customerContactNumber" cssClass="error" /></div>
       			
        			 <div class="cell table-label addborderleft addbordertop ">Contact Email Id:</div>
      			 	 <div class="cell table-data addborderleft addbordertop addborderbottom addborderright ">
        			<form:input id="customerContactEmailId" class="search-form-input" placeholder="Contact Email Id" path="customerInformation.customerContactEmailId" maxlength="100"></form:input>
        			<form:errors path="customerInformation.customerContactEmailId" cssClass="error" /></div>	       			
       			  </div>		 						       		
		       			  
		       	<div class="row">		        
			        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Customer Address:</p></div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="customerAddressLine1Id" class="search-form-input" placeholder="Address Line1" path="customerInformation.customerAddressLine1" maxlength="45"></form:input>
			        	<form:errors path="customerInformation.customerAddressLine1" cssClass="error" />
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="customerAddressLine2Id" class="search-form-input" placeholder="Address Line2" path="customerInformation.customerAddressLine2" maxlength="45"></form:input>
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="cityId" class="search-form-input" placeholder="City" path="customerInformation.city" maxlength="25"></form:input>
			        	<form:errors path="customerInformation.city" cssClass="error" />
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom ">
			        	<form:input id="stateId" class="search-form-input" placeholder="State" path="customerInformation.state" maxlength="25"></form:input>
			        	<form:errors path="customerInformation.state" cssClass="error" />
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="countryId" class="search-form-input" style="background-color: #e1e1e1;" placeholder="Country" path="customerInformation.country" value="India" readonly="true"></form:input>
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
			        	<form:input id="postalCodeId" class="search-form-input" placeholder="Postal Code" 
			        		onkeypress='return allowOnlyNum(event)' path="customerInformation.postalCode" maxlength="6"></form:input>
			        	<form:errors path="customerInformation.postalCode" cssClass="error" />
			        </div>	
		         </div>	        		 
		             
		         <br />
		         
      	 				    
		  		<div id="checkboxId" class="row">
		  		 <div class="cell">
		        	If Billing customer details is same as above ?
		       	 </div>
		        <div class="cell">
		        	<form:checkbox path="customerInformation.customerBillingAddressFlag" value = "Y"></form:checkbox>
		        </div>
		       		        		      
		    	</div>	
			
	

		          <br />
		          
				<div class="row">				  
      			  <div class="cell table-label addborderleft addbordertop"  >Billing Customer Name:</div>
      			  <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="billingCustomerName" class="search-form-input" placeholder="Billing Customer Name" path="customerInformation.billingCustomerName" maxlength="100" ></form:input>
        			<form:errors path="customerInformation.billingCustomerName" cssClass="error" /></div>
        			
        			 <div class="cell table-label addborderleft addbordertop ">Billing Customer Contact Name:</div>
      			 	 <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="billingCustomerContactName" class="search-form-input" placeholder="Billing Contact Name" path="customerInformation.billingCustomerContactName" maxlength="100"></form:input>
        			<form:errors path="customerInformation.billingCustomerContactName" cssClass="error" /></div>
       			
       				<div class="cell table-label addborderleft addbordertop ">Billing Customer Contact Number:</div>
      			 	 <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="billingCustomerContactNumber" class="search-form-input" placeholder="Billing Contact Number" path="customerInformation.billingCustomerContactNumber" maxlength="100"></form:input>
        			<form:errors path="customerInformation.billingCustomerContactNumber" cssClass="error" /></div>
        			
        			<div class="cell table-label addborderleft addbordertop ">Billing Customer Email Id:</div>
      			 	 <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
        			<form:input id="billingCustomerEmailId" class="search-form-input" placeholder="Billing Contact Email Id" path="customerInformation.billingCustomerEmailId" maxlength="100"></form:input>
        			<form:errors path="customerInformation.billingCustomerEmailId" cssClass="error" /></div>
        			  			
       			  </div>
       			  	
		    	<div class="row">		        
			        <div class="cell table-label addborderleft addbordertop addborderbottom"><p>Billing Customer Address:</p></div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="billingAddressLine1Id" class="search-form-input" placeholder="Billing Address Line1" path="customerInformation.billingAddressLine1" maxlength="45"></form:input>
			        	<form:errors path="customerInformation.billingAddressLine1" cssClass="error" />
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="billingAddressLine2Id" class="search-form-input" placeholder="Billing Address Line2" path="customerInformation.billingAddressLine2" maxlength="45"></form:input>
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="billingCityId" class="search-form-input" placeholder="Billing City" path="customerInformation.billingCity" maxlength="25"></form:input>
			        	<form:errors path="customerInformation.billingCity" cssClass="error" />
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="billingstateId" class="search-form-input" placeholder="Billing State" path="customerInformation.billingState" maxlength="25"></form:input>
			        	<form:errors path="customerInformation.billingState" cssClass="error" />
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom">
			        	<form:input id="billingCountryId" class="search-form-input" style="background-color: #e1e1e1;" placeholder="Billing Country" path="customerInformation.billingCountry" value="India" readonly="true"></form:input>
			        </div>
			        <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
			        	<form:input id="billingPostalCodeId" class="search-form-input" placeholder="Billing Postal Code" 
			        		onkeypress='return allowOnlyNum(event)' path="customerInformation.billingPostalCode" maxlength="6"></form:input>
			        	<form:errors path="customerInformation.billingPostalCode" cssClass="error" />
			        </div>	
		         </div>	    		
		</div>
		
		<div class="table">		
		  <div class="table-title"><p>Contract Information</p></div> 
			<div class="error" style="float: left;"> ${message}</div>
			
			<div class="row">				  
      			  <div class="cell table-label addborderleft addbordertop"  >Contract Type</div>
      			  <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="contractTypeId" class="search-form-input" placeholder="Contract Type" path="contractInformation.contractType" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.contractType" cssClass="error" /></div>
        			
        		   <div class="cell table-label addborderleft addbordertop"  >Contract Agreement Number</div>
      			  <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="contractAgreementNumberId" class="search-form-input" placeholder="Contract Agreement Number" path="contractInformation.contractAgreementNumber" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.contractAgreementNumber" cssClass="error" /></div>
        			
        			<div class="cell table-label addborderleft addbordertop"  >Contract Issued Date</div>
      			  <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="contractIssuedDateId" class="search-form-input datepick" placeholder="Contract Issued Date" path="contractInformation.contractIssuedDate" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.contractIssuedDate" cssClass="error" /></div>
  
        			
        			<div class="cell table-label addborderleft addbordertop"  >Hauling Type</div>
      			  <div class="cell table-data addborderleft addbordertop addborderright ">
        			<form:input id="haulingTypeId" class="search-form-input" placeholder="Hauling Type" path="contractInformation.haulingType" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.haulingType" cssClass="error" /></div>
        			
        	</div>
        	
        	<div class="row">				  
      			  <div class="cell table-label addborderleft addbordertop"  >Agreed Capacity</div>
      			  <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="agreedCapacityId" class="search-form-input" placeholder="Agreed Capacity" path="contractInformation.agreedCapacity" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.agreedCapacity" cssClass="error" /></div>
        			
        		   <div class="cell table-label addborderleft addbordertop"  >Valid From</div>
      			  <div class="cell table-data addborderleft addbordertop ">
        			<form:input id="validFromId" class="search-form-input datepick" placeholder="Valid From" path="contractInformation.validFrom" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.validFrom" cssClass="error" /></div>
        			
        			<div class="cell table-label addborderleft addbordertop addborderbottom"  >Valid Till</div>
      			  <div class="cell table-data addborderleft addbordertop addborderbottom">
        			<form:input id="validTillId" class="search-form-input datepick" placeholder="Valid Till" path="contractInformation.validTill" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.validTill" cssClass="error" /></div>
        			
        			
        			<div class="cell table-label addborderleft addbordertop addborderbottom"  >Commitment To Customer</div>
      			  <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
        			<form:input id="commitmentToCustomerId" class="search-form-input" placeholder="Commitment To Customer" path="contractInformation.commitmentToCustomer" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.commitmentToCustomer" cssClass="error" /></div>
        			
        	</div>
        	
        	<div class="row">				  
      			  <div class="cell table-label addborderleft addbordertop addborderbottom"  >Contract Issued By</div>
      			  <div class="cell table-data addborderleft addbordertop addborderbottom">
        			<form:input id="contractIssuedById" class="search-form-input" placeholder="Contract Issued By" path="contractInformation.contractIssuedBy" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.contractIssuedBy" cssClass="error" /></div>
        			
        		   <div class="cell table-label addborderleft addbordertop addborderbottom"  >Contract Signed By</div>
      			  <div class="cell table-data addborderleft addbordertop addborderbottom addborderright">
        			<form:input id="contractSignedById" class="search-form-input" placeholder="Contract Signed By" path="contractInformation.contractSignedBy" maxlength="100" ></form:input>
        			<form:errors path="contractInformation.contractSignedBy" cssClass="error" /></div>       			
        	</div>
			   	  
      	 </div>
      	 	<div class="table" style="width: 100px; float: right">		    
		  		<div id="saveButtonId" class="row">
		        <div class="cell">
		        	<form:button class="login-button" type="submit" name="addAction" value="Save">Save</form:button>
		        </div>		        		      
		    	</div>	
				</div>
    </form:form>
</body>
<jsp:include page="template/footer.jsp"></jsp:include>
</html>
