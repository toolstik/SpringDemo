<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
<a href="${pageContext.request.contextPath}/products/add">Add</a>
<table class="table table-striped">
  <thead>
    <tr>
      <th>Name</th>
      <th>Price</th>
      <th>Description</th>
      <th>Quantity</th>
      <th>Creation date</th>
      <th>Type</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${empty products}">
      <tr>
        <td colspan="8">No products to display</td>
      </tr>
    </c:if>
    <c:if test="${not empty products}">

      <c:forEach items="${products}" var="product">
        <tr class="">
          <td>${product.name}</td>
          <td>${product.price}</td>
          <td>${product.description}</td>
          <td>${product.quantity}</td>
          <td>${product.createDate}</td>
          <td>${product.type}</td>
        </tr>
      </c:forEach>
    </c:if>
  </tbody>
</table>
</div>