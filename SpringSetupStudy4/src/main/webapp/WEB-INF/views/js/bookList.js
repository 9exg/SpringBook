
function getList(nowPage) {
	
	var data = {page : nowPage};
	var callback = ajaxComm("/aBookListAjax", data, 'get');
	callback.done( function(data) {
		console.log(data);
		makeHtmlList(data.list);
		drawPaging(data.pb);
	})
}


/* 리스트 테이블 그리는 함수*/
function makeHtmlList (list) {
	var HTML = "";
		
	for(i = 0; i<list.length; i++) {
		var data = list[i];
		
		HTML +=	'<tr>';
		HTML +=   '<td>'+ data.BOOK_NO +'</td>';
		HTML +=   '<td onclick="goDetailView('+ data.BOOK_NO +')">'+ data.BOOK_TITLE +'</td>';
		HTML +=   '<td>'+ data.BOOK_AUTHOR +'</td>';
		HTML +=   '<td>'+ data.BOOK_CO +'</td>';
		HTML +=   '<td>'+ data.REG_DT +'</td>';
		HTML +=	'</tr>';
	}
	
	$('#appendPath').append(HTML);
}



/* 페이징 그리는 함수*/
function drawPaging(pb) {
	var html = "";
	
	html += "<span class='page_btn page_first' page='1'>처음</span>";
	html += "&nbsp;&nbsp;";
	
	if($("#page").val() == "1" ){
		html += "<span class='page_btn page_prev' page='1'>이전</span>";
	}else{
		html += "<span class='page_btn page_prev' page='" + ($("#page").val() * 1 - 1 ) + "'>이전</span>";
	}
	html += "&nbsp;&nbsp;";


	for(var i = pb.startPcount ; i <= pb.endPcount ; i++ ){
		if($("#page").val() == i){
			html += "<span class='page_btn_on' page='" + i + "'><b>" + i + "</b></span>";
		}else {
			html += "<span class='page_btn' page='" + i + "'>" + i + "</span>";
		}
	}
	html += "&nbsp;&nbsp;";

	
	if($("#page").val() == pb.maxPcount) {
		html += "<span class='page_btn page_next' page ='" + pb.maxPcount + "'>다음</span>";
	}else{
		html += "<span class='page_btn page_next' page = '" + ($("#page").val() * 1 +1 ) + "'>다음</span>";
	}
	html += "&nbsp;&nbsp;";

	html += "<span class='page_btn page_last' page='" + pb.maxPcount + "'>마지막</span>";
	
	$("#pgn_area").html(html);
}



/* 신규등록 Ajax */
function createSubmit() {
	
	var data = {
		book_title  : $('#book_title').val(),
		book_author : $('#book_author').val(),
		book_co     : $('#book_co').val(),
		book_dt     : $('#book_dt').val()
	};
	
	var callback = ajaxComm("/aBookAction/insert", data, 'post');
	callback.done( function(data){
		if(data.res == 'success') {
			alert("정상적으로 등록되었습니다.");
			goList();
		} else {
			alert("등록중 에러가 발생했습니다...");
		}
	})
}


/* 수정 Ajax */
function updateSubmit() {
	var data = {
		no          : $('#no').val(),
		book_title  : $('#book_title').val(),
		book_author : $('#book_author').val(),
		book_co     : $('#book_co').val(),
		book_dt     : $('#book_dt').val()
	};
	
	var callback = ajaxComm("/aBookAction/update", data, 'post');
	callback.done( function(data){
		if(data.res == 'success') {
			alert("정상적으로 수정되었습니다.");
			goList();
		} else {
			alert("수정중 에러가 발생했습니다...");
		}
	})
}



/* 삭제 Ajax */
function deleteData(id) {
	var data = { no : id };
	var callback = ajaxComm("/aBookAction/delete", data, 'post');
	
	callback.done( function(data) {
		if(data.res == 'success') {
			alert("정상적으로 삭제 되었습니다.");
			goList();
		} else {
			alert("삭제중 에러가 발생했습니다...");
		}
	})
}






// ========================= 이동 함수 =========================
/* 상세보기 뷰로 이동*/
function goDetailView(id) {
	location.href="/aBook?no="+id;
}

/* 리스트로 이동*/
function goList() {
	location.href='/bookList'
}


/* 수정화면으로 이동*/
function goUpdate(id) {
	location.href='/aBookUpdate?no='+id;
}


/* 생성뷰로 이동*/
function goCreateView() {
	location.href='/aBookWrite';
}


