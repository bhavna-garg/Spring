<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${errorMsg}</font>
<form method="post">
Name:
<input type="text", name="name"></input>
Password:
<input type="password", name="password"></input>
<input type="submit"></input>
</form>

</body>
</html>