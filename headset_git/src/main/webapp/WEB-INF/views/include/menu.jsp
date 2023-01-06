<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="text-align: right;">
	<c:choose>
		<c:when test="${sessionScope.m_id == null }">
			<a href="/member/login.do">로그인</a> | 
			<a href="/admin/login.do">관리자 로그인</a>|
		</c:when>
		<c:otherwise>
			${sessionScope.m_name}님이 로그인중입니다. 
			<a href="/member/logout.do">로그아웃</a> | 
			<a href="/admin/logout.do">관리자 로그아웃</a>|
		</c:otherwise>
	</c:choose>
	<a href="/review/list.do">상품후기</a>|
	<a href="/review/list_product.do">상품후기(beta)</a>|
	<a href="/compare/compare.do">상품비교</a>|
</div>
<hr>