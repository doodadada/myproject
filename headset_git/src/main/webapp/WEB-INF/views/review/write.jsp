<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<style>
.star {
	position: relative;
	font-size: 2rem;
	color: #ddd;
}

.star input {
	width: 100%;
	height: 100%;
	position: absolute;
	left: 0;
	opacity: 0;
	cursor: pointer;
}

.star span {
	width: 0;
	position: absolute;
	left: 0;
	color: red;
	overflow: hidden;
	pointer-events: none;
}
</style>

<script>
const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
  }
$(function(){
	$("#btnSave").click(function(){
		var r_title=document.form1.r_title.value;
		if(r_title==""){
			alert("제목을 입력하세요."); 
			document.form1.r_title.focus();
			return;
		}
		if(r_text==""){
			alert("내용을 입력하세요."); 
			document.form1.r_text.focus();
			return;
		}
		document.form1.submit();
		});
	});

</script>
<style>
.fileDrop {
	width: 600px;
	height: 100px;
	border: 1px dotted gray;
	backgro und-color: gray;
}
</style>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>게시물 작성</h2>
	<form id="form1" name="form1" method="post" action="/review/insert.do">
		<tr>
			<td>제목</td>
			<td>
				<div>
					<input name="r_title" id="r_title" size="80"
						placeholder="제목을 입력하세요.">
				</div>
			</td>
			<div style="width: 800px">
				<br> 내용 <br>
				<textarea rows="5" cols="82" id="contents" name="r_text"
					placeholder="내용을 입력하세요"></textarea>
			</div>
			<div>
				상품이미지 등록<br> <input type="file" name="r_filename">
			</div>
		</tr>
		<div>
			<span class="star"> ★★★★★ <span>★★★★★</span> <input
				type="range" oninput="drawStar(this)" value="1" step="1" min="0"
				max="10">
			</span>
		</div>
		<div>좋아요♥</div>
		<div style="width: 700px; text-align: center;">
			<button style="" id="btnSave">리뷰등록</button>
		</div>
	</form>
</body>
</html>