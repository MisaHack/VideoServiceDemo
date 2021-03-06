<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
   <title>Video Service Home Page</title>
</head>
<body>
   <h2>Video Service Home Page</h2>
   <hr>

   <p>
      Welcome to Video Service Home Page
   </p>

   <hr>

   <!-- Display user name and role -->

   <p>
      User : <security:authentication property="principal.username"/>
      <br><br>
      Role(s) : <security:authentication property="principal.authorities"/>
   </p>

   <hr>

   <!-- With security:authorize we hide features from other roles-->
   <security:authorize access="hasRole('MANAGER')">
      <!-- Add a link to point to /leaders ... this is for the Managers-->
      <p>
         <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
         (Only for Manager people)
      </p>
   </security:authorize>

   <!-- With security:authorize we hide features from other roles-->
   <security:authorize access="hasRole('ADMIN')">
      <!-- Add a link to point to /systems ... this is for the Admins-->
      <p>
         <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
         (Only for Admin people)
      </p>
   </security:authorize>

   <hr>

   <!-- Add a logout button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
      <input type="submit" value="Logout"/>
   </form:form>
</body>

</html>