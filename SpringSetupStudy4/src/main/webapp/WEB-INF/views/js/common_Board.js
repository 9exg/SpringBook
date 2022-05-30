
/* ajax 공통함수*/
function ajaxComm(url, data, type) {
	var t = "post";
	
	if(type == ""){
		type = t;
	}; 
	
	var callback = $.ajax({
		url:url,
		data:data,
		type:type,
		dataType:'json'
	});
	return callback;
}

/* 필수항목이 있는지 없는지 확인하는 함수. 값이 있는 경우 true, 없는 경우 false 리턴 */
function checkEmpty(sel){
	if($.trim($(sel).val()) == "") {
		return true;
	}else{
		return false;
	}
}	




