<%@page import="poly.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoticeDTO nDTO = (NoticeDTO)request.getAttribute("nDTO");
%>
<html>
<head>
<title>WEB!</title>
<script type="text/javascript">
	function doDelete(noticeNo){
		if(confirm("삭제하시겠습니까")){
			location.href='/notice/noticeDelete.do?noticeNo=' + noticeNo;
		}
	}
</script>
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
				title : <%=nDTO.getTitle() %></br>
				contents : <%=nDTO.getContents() %></br>
				<a href="#" onclick="doDelete('<%=nDTO.getNotice_no()%>');">삭제</a>
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