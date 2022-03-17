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

   <!-- Add a logout button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
      <input type="submit" value="Logout"/>
   </form:form>
</body>

</html>