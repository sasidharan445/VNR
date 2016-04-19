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
$(document).ready(function() {	
	$("#truckTypeId").hide();
	$("#primeMoverTypeId").hide();	
	$("#trailerTypeId").hide();			     
    
    $("#vehicleModelYearId").autocomplete({
        source: function (request, response) {
            $.getJSON("${pageContext.request.contextPath}/vehicleModelYearList", {
               term: request.term
            }, response);
        }
    });
	 
	
	$("#vehicleTypeId").change(function() {	
		
		var value = $("#vehicleTypeId").val();
		
		$.ajax({
		    type    : "GET",		    
		    url     : '${pageContext.request.contextPath}/nextUnitNumber/'+value,		    
		    success : function(response) {                    
		        console.log( "response data: " + response ); 
		         $("#unitNumber").val(response);                 
		    }
		});	
	});	
});

</script>
</head>
<body>
<div><jsp:include page="template/header.jsp"></jsp:include></div>
<div align="center"><jsp:include page="template/navigation.jsp"></jsp:include></div>	
	<form:form name="searchResultForm" modelAttribute="vehicleInformationForm" method="POST" action="addVehicleInfo">
		<input type="hidden" id="vehicleTypeListId"  value="${vehicleTypeList}"/>				
		<div class="table">
			<div class="error"> ${message}</div>
		    <div class="table-title"><p>Vehicle Details</p></div>
		    <div class="row">
		    	
		    		<div class="table">					    
					    <div class="row">
					       <div class="cell table-label addborderleft addbordertop"> Type:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       		<form:select id="vehicleTypeId" path="vehicleType" class="select-form-input">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${vehicleTypeList}"></form:options>    									
					       		</form:select>					       		
					       		<form:errors path="vehicleType" cssClass="error" />	
						   </div>
					       <div class="cell table-label addborderleft addbordertop">Unit Number:</div>
					       <div class="cell table-data addborderleft addbordertop" >					       		
					       		<form:input id="unitNumber" class="search-form-input" placeholder="Unit Number" path="unitNumber" readonly="true"></form:input>
					       </div>
					      
					       <div class="cell table-label addborderleft addbordertop"> Logistic Mode:</div>
					       <div class="cell table-data addborderleft  addbordertop" >
					       		<form:select path="logisticMode" class="select-form-input">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${logisticModeList}"></form:options>		
					       		</form:select>
					       		<form:errors path="logisticMode" cssClass="error" />	
						   </div>
						   <div class="cell table-label addborderleft addbordertop">Registration Number: (Ex:MH 01 AB 1234)</div>
					       <div class="cell table-data addborderleft addborderright addbordertop" >
					       	<form:input id="registrationNumber" class="search-form-input" placeholder="Registration No" 
					       	 maxlength="13"	path="registrationNumber"></form:input>
					       	<form:errors path="registrationNumber" cssClass="error" />	
						   </div>					        
					    </div>
					    <div class="row">
					       
					       <div class="cell table-label addborderleft addbordertop"> Status:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       		<form:select path="vehicleStatus" class="select-form-input">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${vehicleStatusList}"></form:options>	
					       		</form:select>
					       		<form:errors path="vehicleStatus" cssClass="error" />	
					       </div>
					       <div class="cell table-label addborderleft addbordertop"> Make:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       		<form:select path="vehicleMake" class="select-form-input">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${vehicleMakeList}"></form:options>		
					       		</form:select>
					       		<form:errors path="vehicleMake" cssClass="error" />	
					       	</div>
					       	<div class="cell table-label addborderleft addbordertop"><p> Model:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       	<form:input id="vehicleModel" class="search-form-input" placeholder="Model" 
					       		maxlength="20" path="vehicleModel"></form:input>
					       	<form:errors path="vehicleModel" cssClass="error" />
					       </div>
					       <div class="cell table-label addborderleft addbordertop"> Model Year:</div>
					       <div class="cell table-data addborderleft addborderright addbordertop">
					       		<form:input id="vehicleModelYearId" class="search-form-input" maxlength="4"
					       			onkeypress='return allowOnlyNum(event)' placeholder="Vehicle Model Year" path="vehicleModelYear"></form:input>
					       		<form:errors path="vehicleModelYear" cssClass="error" />					       		
					       </div>
					    </div>					
					     <div class="row">
					     <div class="cell table-label addborderleft addbordertop"> Engine Number:</div>
					       <div class="cell table-data addborderleft addbordertop">
					       	<form:input id="vehicleEngineNumber" class="search-form-input" placeholder="Engine Number"
					       		maxlength="20"  path="vehicleEngineNumber"></form:input>
					       	<form:errors path="vehicleEngineNumber" cssClass="error" />
					       </div>
					       <div class="cell table-label addborderleft addbordertop"><p> Chassis Number:</div>
					       <div class="cell table-data addborderleft addbordertop">
								<form:input id="vehicleChassisNumber" class="search-form-input" 
									maxlength="20" placeholder="Chassis Number" path="vehicleChassisNumber"></form:input>
								<form:errors path="vehicleChassisNumber" cssClass="error" />
							</div>
						   <div class="cell table-label addborderleft addbordertop addborderbottom"><p> Hauling Capacity:</div>
					       <div class="cell table-data addborderleft addbordertop addborderbottom">
					       		<form:input id="vehicleHaulingCapacity" class="search-form-input" maxlength="2"
					       			onkeypress='return isNumberWithDecimal(event)' placeholder="Hauling Capacity" path="vehicleHaulingCapacity"></form:input>
					       		<form:errors path="vehicleHaulingCapacity" cssClass="error" />
					       </div>
					       <div class="cell table-label addborderleft addbordertop addborderbottom"> Hauling Type:</div>
					       <div class="cell table-data addborderleft addbordertop  addborderright addborderbottom">
					       		<form:select path="vehicleHaulingType" class="select-form-input">
					       			<form:option value=""> --SELECT--</form:option>
    								<form:options items="${vehicleHaulingTypeList}"></form:options>				       			
					       		</form:select>
					       		<form:errors path="vehicleHaulingType" cssClass="error" />
					       </div>							       
					   	 </div>
					     <div class="row">
					       <div class="cell table-label addborderleft addbordertop addborderbottom"> No. of Tyres:</div>					       
					       <div class="cell table-data addborderleft addbordertop addborderbottom">
					       		<form:input id="vehicleNumOfTyres" class="search-form-input" placeholder="No. of Tyres" 
					       			maxlength="2" onkeypress='return allowOnlyNum(event)' path="vehicleNumOfTyres"></form:input>
					       		<form:errors path="vehicleNumOfTyres" cssClass="error" />
					       </div>
					       <div class="cell table-label addborderleft addbordertop addborderbottom"> Length(mts):</div>
					       <div class="cell table-data addborderleft  addbordertop addborderright addborderbottom">
					       		<form:input id="vehicleLength" class="search-form-input" placeholder="Length" 
					       			onkeypress='return isNumberWithDecimal(event)' path="vehicleLength" maxlength="5"></form:input>
					       		<form:errors path="vehicleLength" cssClass="error" /> 					       		
					   	   </div>					       					   	  
					    </div>
					</div>
		    		    
		    	
		    </div>
		</div>
				
		<div class="table" style="width: 100px; float: right">		    
		    <div class="row">
		        <div class="cell">
		        	<form:button class="login-button" type="submit" name="submitAction" value="save">Save</form:button>
		        </div>		        		      
		        <div class="cell">
		        	<form:button class="login-button" type="submit" name="submitAction" value="addFinance">Add Finance</form:button>
		        </div>
		    </div>	
		</div>
	 
		  
    </form:form>
</body>
<jsp:include page="template/footer.jsp"></jsp:include>
</html>