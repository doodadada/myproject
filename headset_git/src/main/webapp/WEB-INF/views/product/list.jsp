<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<tr>
		<td><img src="/resource/images/${dto.p_image}.png" width="300px"
			height="300px"></td>
		<td align="center">
			<table>
				<tr>
					<th>${dto.p_code}</th>
					<th>${dto.p_name}</th>
					<th>${dto.p_brand}</th>
					<th>${dto.p_price}</th>
					<th>${dto.p_image}</th>
					<th>${dto.p_length}mm*${dto.p_width}mm*${dto.height}mm</th>
					<th>${dto.p_weight}</th>
					<th>${dto.p_color1}</th>
					<th>${dto.p_color2}</th>
					<th>${dto.p_color3}</th>
					<th>${dto.p_playtime}</th>
					<th>${dto.p_noise}</th>
					<th>${dto.p_line}</th>
				</tr>
			</table>
</body>
</html>