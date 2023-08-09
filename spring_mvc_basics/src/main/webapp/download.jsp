<%@page import="org.springframework.web.bind.annotation.RequestAttribute"%>
<%@page import="spring_mvc_basics.controller.DoctorDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="">
	<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>NUMBER</th>
	<th>CLINIC</th>
	<th>SPECILIAZATION</th>
	<th>DELETE</th>
	<th>UPDATE</th>
	</tr>
	<%List<DoctorDto> list=(List<DoctorDto>) request.getAttribute("objects");%>	
	<%for(DoctorDto uv:list){%>
	<tr>
	<td><%=uv.getId()%></td>
	<td><%=uv.getName()%></td>
	<td><%=uv.getPhone()%></td>
	<td><%=uv.getClinic()%></td>
	<td><%=uv.getSpecialization()%></td>
	<td><a href="delete?id=<%=uv.getId()%>">remove</a></td>
	<td><a href="update.jsp?id=<%=uv.getId()%>
	&&name=<%=uv.getName()%>
	&&phone=<%=uv.getPhone()%>
	&&clinic=<%=uv.getClinic()%>
	&&specialization=<%=uv.getSpecialization()%>">edit</a></td>
	</tr>
	<%} %>
</table>
</body>
</html>