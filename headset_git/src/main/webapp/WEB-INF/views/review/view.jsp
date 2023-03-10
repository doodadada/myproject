<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		$("#btnList").click(function() {
			location.href = "/review/list.do";
		});
		listReview_Reply("1");
		$("#btnReply").click(function() {
			review_reply();
		});
		/* $(".fileDrop").on("dragenter dragover", function(e) {
			e.preventDefault();
		}); */
		/* $("#uploadedList").on("click", ".file_del", function(e) {
			var that = $(this);
			$.ajax({
				type : "post",
				url : "/upload/delete_file",
				data : {
					file_name : $(this).attr("data-src")
				},
				dataType : "text",
				success : function(result) {
					if (result == "deleted") {
						that.parent("div").remove();
					}
				}
			});
		}); */
		$("#btnUpdate").click(
				function() {
					/* var str = "";
					$("#uploadedList .file").each(function(i) {
								str += "<input type='hidden' name='files[" + i
										+ "]' value='" + $(this).val() + "'>";
							});
					$("#form1").append(str); */
					document.form1.action = "/review/update.do";
					document.form1.submit();
				}); 
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.form1.action = "/review/delete.do";
				document.form1.submit();
			}
		});
	});
	function review_reply() { //댓글쓰기버튼 누르면 작동하는 insert 함수
		var rre_text = $("#rre_text").val();
		var r_idx = "${dto.r_idx}";
		var params = {
			"rre_text" : rre_text,
			"r_idx" : r_idx
		};
		$.ajax({
			type : "post",
			url : "/review_reply/insert.do",
			data : params,
			success : function() {
				alert("댓글이 등록되었습니다.");
				listReview_Reply("1");
			}
		});
	}
	function listReview_Reply(num) {
		$.ajax({
			url : "/review_reply/list.do?r_idx=${dto.r_idx}&curPage=" + num,
			success : function(result) {
				$("#listReview_Reply").html(result);
			}
		});
	}
	function showModify(rre_idx) {
		$.ajax({
			url : "/review_reply/detail/" + rre_idx,
			success : function(result) {
				$("#modifyReview_Reply").html(result);
				$("#modifyReview_Reply").css("visibility", "visible");
			}
		});
	}
</script>
<style>
.fileDrop {
	width: 600px;
	height: 100px;
	border: 1px dotted gray;
	background: gray;
}
</style>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>상품 후기</h2>
	<form id="form1" name='form1' method="post">
		<div>
			작성일자:
			<fmt:formatDate value="${dto.r_date}" pattern="yy-MM-dd a HH:mm:ss" />
		</div>
		<div>조회수: ${dto.r_viewcount}</div>
		<div>작성자: ${dto.m_id}</div>
		<div>제목: ${dto.r_title}	</div>
		<div><img src="/resources/images/${dto.r_filename}" width="100px" height="100px">
		</div>
		<div style="width: 80%">
			내용:<br>
			<textarea readonly rows="10" cols="80" name="r_text" id="r_text">${dto.r_text}</textarea>
		</div>
		<div>
			<input type="hidden" name="r_idx" value="${dto.r_idx}">
			<c:if test="${sessionScope.m_id == dto.m_id }">
				<button type="button" id="btnUpdate">수정</button>
				<button type="button" id="btnDelete">삭제</button>
			</c:if>
			<button type="button" id="btnList">목록</button>
		</div>
	</form>
	<div style="width:700px; text-align:center;">
		<c:if test="${sessionScope.m_id != null }">
			<textarea rows="5" cols="80" id="rre_text" placeholder="댓글을 작성하세요."></textarea> 
<br>
			<button type="button" id="btnReply">댓글쓰기</button>
		</c:if>
	</div>
	<div id="listReview_Reply"></div>
	<!--댓글 수정 화면 영역-->
	<div id="modifyReview_Reply"></div>
</body>
</html>