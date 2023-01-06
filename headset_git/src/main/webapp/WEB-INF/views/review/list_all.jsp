<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../resources/css/table_compare.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<style>
</style>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>상품후기(beta)</h2>
	<h3>${map.count_all}개의리뷰</h3>
	<form name="form1" method="post" action="/review/list_sel_product.do">
		<table>
			<tr>
				<c:forEach var="row" items="${map.list}">
					<input type="hidden" name="p_code" value="${row.p_code}">
					<td>
						<img src="/resources/images/${row.p_image}" width="300px"
						height="300px">
						<br>
						<a href="/review/list_sel_product.do?p_code=${row.p_code}&cur_page=${map.page_info.curPage}&search_option=${map.search_option}&keyword=${map.keyword}">${row.p_name}
						<br>
						${row.p_price}원
						<br>
						평점 ${row.p_point}
						<br>
						${row.cnt_product}개의리뷰
				</c:forEach>
			</tr>
	</form>
		<hr>
		<tr>
			<td colspan="5" align="center"><c:if
					test="${map.page_info.curPage > 1 }">
					<a href="javascript:list('1')">[처음]</a>
				</c:if> <c:if test="${map.page_info.curBlock > 1}">
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