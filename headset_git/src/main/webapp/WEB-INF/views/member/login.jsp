<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		$("#btnLogin").click(function() {
			var m_id = $("#m_id").val();
			var m_pwd = $("#m_pwd").val();
			if (m_id == "") {
				alert("아이디를 입력하세요.");
				$("#m_id").focus();
				return;
			}
			if (m_pwd == "") {
				alert("비밀번호를 입력하세요.");
				$("#m_pwd").focus();
				return;
			}
			document.form1.action = "/member/login_check.do";
			document.form1.submit();
		});
	});
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>로그인</h2>
	
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td> 
				<td><input id="m_id" name="m_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td> 
				<td><input type="m_pwd" id="m_pwd" name="m_pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">로그인</button> 
					<c:if test="${message == 'error' }">
						<div style="color: red;">
						아이디 또는 비밀번호가 일치하지 않습니다.
						</div>
					</c:if>
					<c:if test="${message == 'logout' }">
						<div style="color: red;">
						로그아웃되었습니다.
						</div>
					</c:if>
					<c:if test="${param.message == 'nologin' }">
						<div style="color: blue;">
						로그인 하신 후 사용하세요.
						</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>