<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<c:if test="${message == 'success' }">
		<h2>${sessionScope.m_name} (${sessionScope.m_id})님 환영합니다.
		</h2>
	</c:if>
</body>
</html>