function isNumberWithDecimal(evt) {

   var charCode = (evt.which) ? evt.which : evt.keyCode;

    if(charCode==8 || charCode==13|| charCode==99|| charCode==118 || charCode==46)   {    return true;  }
    if (charCode > 31 && (charCode < 48 || charCode > 57))     {  return false; }
     return true;
 }

function allowOnlyNum(e) {
	var key = e.keyCode;
	if (key == 0) { 
		key = e.charCode;
	}
	if(key == 9 || key == 8) {
		return true;
	}	
	
	if(key < 48 || key > 57) {
		return false;
	} else {
		return true;
	}		
}