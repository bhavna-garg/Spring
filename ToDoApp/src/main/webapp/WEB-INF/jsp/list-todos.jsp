<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<h1>Your Todos:</h1>
<br>
<div class="container">
	<table class="table table-striped">
		<caption>List of your Todo's</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target date </th>
				<th>Is it done?</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
	</thead>
	<tbody>
	
<!-- 	JSTL for loop -->
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.desc}</td>
			<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
			<td>${todo.done}</td>
			<td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
			<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
<div><a class="button" href="/add-todo">Add Todo</a></div>

<%@ include file="common/footer.jspf" %>