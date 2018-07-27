<%@page import="poly.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDTO mDetail =(MemberDTO)request.getAttribute("mDetail");
%>
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
				ID : <%=mDetail.getId() %><br>
				NAME : <%=mDetail.getMember_name() %><br>
				ADDR : <%=mDetail.getMember_addr() %><br>
				REG_DT : <%=mDetail.getReg_dt() %><br>
				<a href="/member/memberDelete.do?memberNo=<%=mDetail.getMember_no()%>">삭제</a>
				<a href="/member/updateView.do?memberNo=<%=mDetail.getMember_no()%>">수정</a>
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