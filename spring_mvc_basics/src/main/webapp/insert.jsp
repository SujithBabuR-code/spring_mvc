<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insert">
enter name:<input type="text" name="name" pattern="[a-z A-Z]+"><br>
enter phone:<input type="tel" name="phone" pattern="[0-9]+"><br>
enter Spec:<input type="text" name="specialization" pattern="[a-z A-Z]+"><br>
enter clinicName:<input type="text" name="clinic" pattern="[a-zA-Z]+"><br>
<button type="submit">Submit</button>
<button type="reset">Reset</button>
</form>
</body>
</html>