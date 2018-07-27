<%@page import="poly.dto.NoticeDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<NoticeDTO> nList = (List<NoticeDTO>)request.getAttribute("nList");
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
				<table style="width:100%">
					<tr bgcolor="#2EFE2E">
						<td align="center">제목</td>
						<td align="center">조회수</td>
						<td align="center">등록일</td>
					</tr>
					<%for(int i = 0; i< nList.size();i++){ %>
					<tr>
						<td align="center">
							<a href="/notice/noticeDetail.do?noticeNo=<%=nList.get(i).getNotice_no()%>">
								<%=nList.get(i).getTitle() %>
							</a>
						</td>
						<td align="center"><%=nList.get(i).getCnt() %></td>
						<td align="center"><%=nList.get(i).getReg_dt() %></td>
					</tr>
					<%} %>
				</table>
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