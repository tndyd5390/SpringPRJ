<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>WEB!</title>
</head>
<body>
	<table style="height: 100%; width: 100%">
		<tr height="7%" bgcolor="#00D8FF">
			<td>
				<%@include file="/WEB-INF/view/top.jsp" %>
			</td>
		</tr>
		<tr bgcolor="">
			<td>
				<h2>WEB APPLICATION</h2> <a
				href="https://www.youtube.com/watch?v=sXV8rovajqw"><b>우리형
						하이라이트 보러가기</b></a>
				<form action="#">
					검색 : <input type="text" name="word" />
				</form>
				<hr />

			</td>
		</tr>
		<tr height="7%" bgcolor="#00D8FF">
			<td>
				<%@include file="bottom.jsp" %>
			</td>
		</tr>
	</table>
</body>
</html>