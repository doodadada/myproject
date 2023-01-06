<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../resources/css/table_compare.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
 $(function() {
		 $("#sel1").change(function() {
 				document.form1.submit(); 
	});
 });	
 $(function() {
		 $("#sel2").change(function() {
 				document.form2.submit(); 
	});
 });	
	
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>제품 비교하기</h2>
	<table align="center">
	<tr>
	<td align="center"><form id="form1" name="form1" method="post" >
		<select id="sel1" name="p_name1">
			<option value="">제품1을 고르세요</option>
			<c:forEach var="row" items="${map.list}">
				<option value="${row.p_name}">${row.p_name}</option>
			</c:forEach>
		</select>
		<input type="hidden" name="p_name2" value="${map.dto2.p_name}">
	</form>
	</td>
	<td>&nbsp</td>
	<td align="center">
	<form id="form2" name="form2" method="post" >
		<select id="sel2" name="p_name2">
			<option value="">제품2를 고르세요</option>
			<c:forEach var="row" items="${map.list}">
			<!--c:if test=dto1.name!=null : dto1.name 
			else : map.list -->
				<option value="${row.p_name}">${row.p_name}</option>
			</c:forEach>
		</select>
		<input type="hidden" name="p_name1" value="${map.dto1.p_name}">
	</form>
	</td>
	</tr>
		<tr>
		<th>${map.dto1.p_name}</th>
		<th>상품명</th>
		<th>${map.dto2.p_name}</th>
		</tr>
		<tr>
		<td><img src="/resources/images/${map.dto1.p_image}"
					width="300px" height="300px"></td>
		<th>상품 이미지</th>
		<td><img src="/resources/images/${map.dto2.p_image}"
					width="300px" height="300px"></td>
		</tr>
		<tr>
		<td>${map.dto1.p_code}</td>
		<th>상품코드</th>
		<td>${map.dto2.p_code}</td>
		</tr>
		<tr>
		<td>${map.dto1.p_brand}</td>
		<th>제조사</th>
		<td>${map.dto2.p_brand}</td>
		</tr>
		<tr>
		<td>${map.dto1.p_price}</td>
		<th>가격</th>
		<td>${map.dto2.p_price}</td>
		</tr>
		<tr>
		<td>
		<c:set var="size" value="${map.dto1.p_length}"/>
		<c:choose>
			<c:when test="${size == '0' }">
			-
			</c:when>
			<c:otherwise>
			${map.dto1.p_length}mm*${map.dto1.p_width}mm*${map.dto1.p_height}mm
			</c:otherwise>
		</c:choose>
		</td>
		<th>사이즈</th>
		<td>
		<c:set var="size" value="${map.dto2.p_length}"/>
		<c:choose>
			<c:when test="${size == '0' }">
			-
			</c:when>
			<c:otherwise>
			${map.dto2.p_length}mm*${map.dto2.p_width}mm*${map.dto2.p_height}mm
			</c:otherwise>
		</c:choose>
		</td>
		</tr>
		<tr>
		<td>${map.dto1.p_weight}</td>
		<th>무게</th>
		<td>${map.dto2.p_weight}</td>
		</tr>
		<tr>
		<td>${map.dto1.p_color1}/${map.dto1.p_color2}/${map.dto1.p_color3}</td>
		<th>색상</th>
		<td>${map.dto2.p_color1}/${map.dto2.p_color2}/${map.dto2.p_color3}</td>
		</tr>
		<tr>
		<td>${map.dto1.p_playtime}</td>
		<th>재생시간</th>
		<td>${map.dto2.p_playtime}</td>
		</tr>
		<tr>
		<td>${map.dto1.p_noise}</td>
		<th>노이즈캔슬링</th>
		<td>${map.dto2.p_noise}</td>
		</tr>
		<tr>
		<td>${map.dto1.p_line}</td>
		<th>유무선여부</th>
		<td>${map.dto2.p_line}</td>
		</tr>
	</table>


</body>
</html>