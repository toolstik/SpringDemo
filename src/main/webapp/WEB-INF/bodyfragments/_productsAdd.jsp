<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
	<form:form method="POST" modelAttribute="product">
		<div class="form-group">
			<form:label path="name">Name</form:label> 
			<form:input type="text" path="name"/>
		</div>
		<div class="form-group">
			<form:label path="description">Description</form:label> 
			<form:textarea path="description" rows="3"></form:textarea>
		</div>
		<div class="form-group">
			<form:label path="price">Price</form:label> 
			<form:input type="text" path="price" />
		</div>
		<div class="form-group">
			<form:label path="quantity">Quantity</form:label> 
			<form:input type="text" path="quantity" />
		</div>
		<div class="form-group">
			<form:label path="typeId">Type</form:label> 
			<form:select path="typeId" items="${productTypes}">
				<form:options itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
		<input type="hidden"
		    name="${_csrf.parameterName}"
		    value="${_csrf.token}"/>
		<button type="submit" class="btn btn-primary">Add</button>
	</form:form>
</div>