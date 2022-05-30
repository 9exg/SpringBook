<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookList</title>

<!-- mdList css파일  -->
<link rel="stylesheet" type="text/css" href="css/bookList.css" />

<!-- jquery -->
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- common_sales javaScript파일 -->
<script type="text/javascript" src="js/common_Board.js"></script>

<script type="text/javascript" src="js/bookList.js"></script>


<script type="text/javascript">
$( document ).ready(function() {
	
	getList(1);
	
});
</script>
</head>


<body>
	<h1>도서관리 </h1>
	<!-- 등록 버튼 -->
	<div class="btn_wrap">
		<input type="button" onclick="goCreateView()" class="writeBtn" value="등록">
	</div>
	<!-- 테이블 -->
	<div class="table_wrap">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>책제목</th>
					<th>저자</th>
					<th>출판사</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody id='appendPath'></tbody>
		</table>
	</div>
	<div id="pgn_area"></div>
</body>
</html>