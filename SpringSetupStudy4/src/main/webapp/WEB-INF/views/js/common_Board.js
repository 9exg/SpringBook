
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


