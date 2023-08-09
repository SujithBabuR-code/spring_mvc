<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ud">
id:    <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly="readonly"><br>
name:  <input type="text" name="name" value="<%=request.getParameter("name")%>"><br>
phone: <input type="tel" name="phone"  value="<%=request.getParameter("phone")%>"  pattern="[0-9]+"><br>
Spec:  <input type="text" name="specialization" value="<%=request.getParameter("specialization")%>" pattern="[a-z A-Z]+"><br>
clinic:<input type="text" name="clinic"  value="<%=request.getParameter("clinic")%>" pattern="[a-zA-Z]+"><br>
<button type="submit">update</button>
</form>
</body>
</html>