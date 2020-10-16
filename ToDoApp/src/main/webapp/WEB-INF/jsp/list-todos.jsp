<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos for ${name }</title>
</head>
<body>
<h1>Your Todos:</h1>
<br>
<table>
	<caption>List of your Todo's</caption>
	<thead>
	<tr>
		<th>Description</th>
		<th>Target Date</th>
		<th>Is it done?</th>
	</tr>
	</thead>
	<tbody>
<!-- 	JSTL for loop -->
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.desc}</td>
			<td>${todo.targetDate}</td>
			<td>${todo.done}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/add-todo">Add Todo</a>
</body>
</html>