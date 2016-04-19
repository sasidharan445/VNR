$(document).ready(function() {		
	var vehicleType = $("#vehicleTypeId").val();
	if(vehicleType == "Prime Mover") {
		$("#primeMoverUN").show();
 	    $("#truckUN").hide();
 	    $("#trailerUN").hide();
 	    $("#permitInsuranceSectionId").hide();
 	    $("#financeSectionId").show();	
 	    $("#saveBtnId").show();
	} else if(vehicleType == "Truck") {
		$("#truckUN").show();
	    $("#permitInsuranceSectionId").show();
	    $("#primeMoverUN").hide();
	    $("#trailerUN").hide();
	    $("#financeSectionId").show();
	    $("#saveBtnId").show();
	} else if(vehicleType == "Trailer") {
		$("#trailerUN").show();
		$("#primeMoverUN").hide();
	    $("#truckUN").hide();    	    
	    $("#permitInsuranceSectionId").hide();
	    $("#financeSectionId").show();
	    $("#saveBtnId").show();
	} else if(vehicleType == "PTR") {
		$("#trailerUN").show();
		$("#permitInsuranceSectionId").show();
		$("#primeMoverUN").show();
	    $("#truckUN").hide(); 
	    $("#financeSectionId").show();   
	    $("#saveBtnId").show();
	} else {
		$("#saveBtnId").hide();
		$("#truckUN").hide();
		$("#primeMoverUN").hide();	
		$("#trailerUN").hide();	
		$("#financeSectionId").hide();	
		$("#permitInsuranceSectionId").hide();	
	}
	 $("#stateNameId").autocomplete({
        source: function (request, response) {
            $.getJSON(getContextPath()+"/stateList", {
               term: request.term
            }, response);
        }
    });
    
    $('.datepick').each(function(){
    	$(this).datepicker({  dateFormat: 'dd/mm/yy'  });
	});          
   
	
	$("#vehicleTypeId").change(function() {	
    	if(this.value == "Prime Mover") {       		
    	    $("#primeMoverUN").show();
    	    $("#truckUN").hide();
    	    $("#trailerUN").hide();
    	    $("#permitInsuranceSectionId").hide();
    	    $("#financeSectionId").show();
    	    $("#saveBtnId").show();
    	} else if(this.value == "Truck") {    		 
    	    $("#truckUN").show();
    	    $("#permitInsuranceSectionId").show();
    	    $("#primeMoverUN").hide();
    	    $("#trailerUN").hide();
    	    $("#financeSectionId").show();
    	    $("#saveBtnId").show();
    	} else if(this.value == "Trailer") {
    		$("#trailerUN").show();
    		$("#primeMoverUN").hide();
    	    $("#truckUN").hide();    	    
    	    $("#permitInsuranceSectionId").hide();
    	    $("#financeSectionId").show();
    	    $("#saveBtnId").show();
    	} else if(this.value == "PTR") {
    		$("#trailerUN").show();
    		$("#permitInsuranceSectionId").show();
    		$("#primeMoverUN").show();
    	    $("#truckUN").hide(); 
    	    $("#financeSectionId").show(); 
    	    $("#saveBtnId").show();
    	}
	});
	

	$("#vfCurrentPaidAmountId").focusout( function() {
		var totalAmt = $("#totalLoanAmountId").val();
		var paidAmt = $("#vfCurrentPaidAmountId").val();
	    var truckNumber = $("#truckUnitNumberId").val();
	    var primeMoverNumber = $("#primeMoverUnitNumberId").val();
	    var trailerNumber = $("#trailerUnitNumberId").val();
		json = { "paidAmount": paidAmt,		
				 "totalAmount": totalAmt,
			 	 "unitNumber": getUnitNumber(truckNumber, primeMoverNumber, trailerNumber),			 
			 	 "paymentObject": "Finance"};		
		$.ajax({
		    type    : "POST",		    
		    url     : getContextPath()+'/balanceAmount',
		    data	: JSON.stringify(json),
			dataType : 'json',	
			beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");},							   
		    success : function(response) {                    
		        console.log( "response data: " + response ); 
		         $("#vfBalanceAmountId").val(response);                 
		    }
		});		    
	});
	
	$("#currentNationalPaidAmountId").focusout( function() {	
		var totalAmt = $("#nationalTaxAmountId").val();
		var paidAmt = $("#currentNationalPaidAmountId").val();		
	    var truckNumber = $("#truckUnitNumberId").val();
	    var primeMoverNumber = $("#primeMoverUnitNumberId").val();
	    var trailerNumber = $("#trailerUnitNumberId").val();
		json = { "paidAmount": paidAmt,	
				 "totalAmount": totalAmt,
			 	 "unitNumber": getUnitNumber(truckNumber, primeMoverNumber, trailerNumber),			 
			 	 "paymentObject": "NationalTax"};
		$.ajax({
		    type    : "POST",		    
		    url     : getContextPath()+'/balanceAmount',
		    data	: JSON.stringify(json),
			dataType : 'json',	
			beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");},							   
		    success : function(response) {                    
		        console.log( "response data: " + response ); 
		         $("#nationalTaxBalanceAmountId").val(response);                 
		    }
		});		    
	});
	
	$("#currentStatePaidAmountId").focusout( function() {	
		var totalAmt = $("#stateTaxAmountId").val();
		var paidAmt = $("#currentStatePaidAmountId").val();		
	    var truckNumber = $("#truckUnitNumberId").val();
	    var primeMoverNumber = $("#primeMoverUnitNumberId").val();
	    var trailerNumber = $("#trailerUnitNumberId").val();
		json = { "paidAmount": paidAmt,	
				 "totalAmount": totalAmt,
			 	 "unitNumber": getUnitNumber(truckNumber, primeMoverNumber, trailerNumber),			 
			 	 "paymentObject": "NationalTax"};
		$.ajax({
		    type    : "POST",		    
		    url     : getContextPath()+'/balanceAmount',
		    data	: JSON.stringify(json),
			dataType : 'json',	
			beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");},							   
		    success : function(response) {                    
		        console.log( "response data: " + response ); 
		         $("#stateTaxBalanceAmountId").val(response);                 
		    }
		});		    
	});
	
	$("#currentPermitPaidAmountId").focusout( function() {	
		var totalAmt = $("#nationalPermitAmountId").val();
		var paidAmt = $("#currentPermitPaidAmountId").val();		
	    var truckNumber = $("#truckUnitNumberId").val();
	    var primeMoverNumber = $("#primeMoverUnitNumberId").val();
	    var trailerNumber = $("#trailerUnitNumberId").val();
		json = { "paidAmount": paidAmt,	
				 "totalAmount": totalAmt,
			 	 "unitNumber": getUnitNumber(truckNumber, primeMoverNumber, trailerNumber),			 
			 	 "paymentObject": "NationalTax"};
		$.ajax({
		    type    : "POST",		    
		    url     : getContextPath()+'/balanceAmount',
		    data	: JSON.stringify(json),
			dataType : 'json',	
			beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");},							   
		    success : function(response) {                    
		        console.log( "response data: " + response ); 
		         $("#permitBalanceAmountId").val(response);                 
		    }
		});	
	});
		
		$("#currentInsurancePaidAmountId").focusout( function() {	
			var totalAmt = $("#insuranceAmountId").val();
			var paidAmt = $("#currentInsurancePaidAmountId").val();		
		    var truckNumber = $("#truckUnitNumberId").val();
		    var primeMoverNumber = $("#primeMoverUnitNumberId").val();
		    var trailerNumber = $("#trailerUnitNumberId").val();
			json = { "paidAmount": paidAmt,	
					 "totalAmount": totalAmt,
				 	 "unitNumber": getUnitNumber(truckNumber, primeMoverNumber, trailerNumber),			 
				 	 "paymentObject": "NationalTax"};
			$.ajax({
			    type    : "POST",		    
			    url     : getContextPath()+'/balanceAmount',
			    data	: JSON.stringify(json),
				dataType : 'json',	
				beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");},							   
			    success : function(response) {                    
			        console.log( "response data: " + response ); 
			         $("#insuranceBalanceAmountId").val(response);                 
			    }
			});		
	});
});

function getUnitNumber(truckNumber, primeMoverNumber, trailerNumber) {	
	if(truckNumber != "" ) {
		return truckNumber;
	} else if (primeMoverNumber != "" ) {
		return primeMoverNumber;
	}else if (trailerNumber != "" ) {
		return trailerNumber;
	} else return null;
	
}