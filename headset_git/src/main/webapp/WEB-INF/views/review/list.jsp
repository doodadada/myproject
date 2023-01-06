<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../resources/css/table_review.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			location.href = "/review/write.do";
		});
	});
	function list(page) {
		location.href = "/review/list.do?curPage=" + page
				+ "&search_option=${map.search_option}&keyword=${map.keyword}";
	}
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>상품후기</h2>
	<form name="form1" method="post" action="/review/list.do">
		<select name="search_option">
			<option value="all"
				<c:out value="${map.search_option == 'all' ? 'selected' : ''}"/>>작성자+내용+제목</option>
			<option value="r.m_id"
				<c:out value="${map.search_option == 'r.m_id' ? 'selected' : '' }"/>>작성자</option>
			<option value="r_text"
				<c:out value="${map.search_option == 'r_text' ? 'selected': '' }"/>>내용</option>
			<option value="r_title"
				<c:out value="${map.search_option == 'r_title' ? 'selected' :'' }"/>>제목</option>
		</select> <input name="keyword" value="${map.keyword}"> <input
			type="submit" value="조회">
		<c:if test="${sessionScope.m_id != null }">
			<button type="button" id="btnWrite">글쓰기</button>
		</c:if>
	</form>
	${map.count}개의 게시물이 있습니다.
	<table border="1" width="600" px>
		<tr>
			<th>번호</th>
			<th>상품</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
			<th>조회수</th>
			<c:if test="${sessionScope.a_id != null}">
				<th>상태</th>
			</c:if>
		</tr>
		<tr>
		
		</tr>
		<c:forEach var="row" items="${map.list}">
			<tr>
				<td>${row.r_idx}</td>
				<td>
				<img src="/resources/images/${row.r_filename}" width="100px" height="100px">
				<td><a
					href="/review/detail.do?r_idx=${row.r_idx}&cur_page=${map.page_info.curPage}&search_option=${map.search_option}&keyword=${map.keyword}">${row.r_title}</a>
					<c:if test="${row.cnt >0 }">
						<span style="color: red">(${row.cnt})</span>
					</c:if>
				<td>${row.m_id}</td>
				<td><fmt:formatDate value="${row.r_date}"
						pattern="yy-MM-dd HH:mm:ss" /></td>
				<td>${row.r_viewcount}</td>
				<c:if test="${sessionScope.a_id !=null}">
					<td>${row.r_state}</td>
				</c:if>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center">
				<c:if test="${map.page_info.curPage > 1 }">
					<a href="javascript:list('1')">[처음]</a>
				</c:if>
				<c:if test="${map.page_info.curBlock > 1}">
					<a href="javascript:list('${map.page_info.prevPage}')">[이전]</a>
				</c:if> <c:forEach var="num" begin="${map.page_info.blockBegin}"
					end="${map.page_info.blockEnd}">
					<c:choose>
						<c:when test="${num == map.page_info.curPage}">
							<span style="color: red">${num}</span>&nbsp;
					</c:when>
						<c:otherwise>
							<a href="javascript:list('${num}')">${num}</a>&nbsp;
				</c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${map.page_info.curBlock <= map.page_info.totBlock }">
					<a href="javascript:list('${map.page_info.nextPage}')">[다음]</a>
				</c:if> <c:if test="${map.page_info.curPage <= map.page_info.totPage}">
					<a href="javascript:list('${map.page_info.totPage}')">[끝]</a>
				</c:if></td>
		</tr>
	</table>
</body>
</html>