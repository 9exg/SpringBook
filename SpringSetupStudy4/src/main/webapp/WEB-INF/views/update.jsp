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
		
});
</script>
</head>


<body>
	<!-- 테이블 -->
	<h1>UPDATE VIEW</h1>
	<div class="table_wrap">
		<table>
			<thead>
				<tr>
					<th>책제목</th>
					<td><input type='text' id='book_title' value="${data.BOOK_TITLE }"></td>
				</tr>
				<tr>
					<th>저자</th>
					<td><input type='text' id='book_author' value="${data.BOOK_AUTHOR }"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type='text' id='book_co'  value="${data.BOOK_CO }"></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><input type='date' id='book_dt' value="${data.REG_DT }"></td>
				</tr>
			</thead>
		</table>
		<input type='hidden' id='no' value="${data.BOOK_NO }">
		
		<input type='button' value='수정하기' onclick='updateSubmit()'>
		<button type='button' onclick='goList()'>리스트로 이동</button>
	</div>
	</form>
</body>
</html>