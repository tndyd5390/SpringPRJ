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
			<form action="/notice/noticeReg.do" method="post" >
				<table>
					<tr>
						<td>
							제목 : <input type="text" name="title">
						</td>
					</tr>
					<tr>
						<td>
							내용 : <input type="text" name="contents">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="전송">
						</td>
					</tr>
				</table>
			</form>
			</td>
		</tr>
		<tr height="7%" bgcolor="#00D8FF">
			<td>
				<%@include file="/WEB-INF/view/bottom.jsp" %>
			</td>
		</tr>
	</table>
</body>
</html>