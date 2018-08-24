<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-striped">
  <thead>
    <tr>
      <th>Name</th>
      <th>Roles</th>
      <th>Creation date</th>
      <th>Gender</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${empty users}">
      <tr>
        <td colspan="8">No users to display</td>
      </tr>
    </c:if>
    <c:if test="${not empty users}">

      <c:forEach items="${users}" var="user">
        <tr class="">
          <td>${user.name}</td>
          <td>${user.roles}</td>
          <td>${user.createDate}</td>
          <td>${user.gender}</td>
        </tr>
      </c:forEach>
    </c:if>
  </tbody>
</table>
</div>