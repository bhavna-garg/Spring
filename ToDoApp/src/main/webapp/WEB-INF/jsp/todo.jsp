<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1>Add Todo for ${name }</h1>
<br>
<!-- modelAttribute and form taglib is a way with which we can bind a model from controller to view -->
	<form:form method="POST" modelAttribute="todo">
	<form:hidden path="id"/>
	<fieldset class="form-group">
		<form:label path="desc">Description:</form:label>
		<form:input type="text" path="desc" name= "desc" class="form-control" required="required"/>
		<form:errors path="desc" cssClass="text-warning"></form:errors>
	</fieldset>
	<fieldset class="form-group">
		<form:label path="targetDate">Target date:</form:label>
		<form:input type="text" path="targetDate" name= "targetDate" class="form-control" required="required"/>
		<form:errors path="targetDate" cssClass="text-warning"></form:errors>
	</fieldset>
	<button type="submit" value="submit" class="btn btn-success">SUBMIT</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>