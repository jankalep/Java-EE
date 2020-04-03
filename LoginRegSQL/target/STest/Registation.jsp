<%--
  Created by IntelliJ IDEA.
  User: vladc
  Date: 27.02.20
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация </title>
</head>
<body>
<form action="/reg" method="post">
    <fieldset style="width: fit-content">
      <p><input type="" name="name" placeholder=" Name"/></p>
      <p><input type="" name="login" placeholder="Login"/> </p>
     <p><input type="" name="password" placeholder="Password"/> </p>
      <p><input type="radio" placeholder="admin" name="admin-check" value="adminrole">admin</input>
          <input type="radio" placeholder="user" name="admin-check" value="userrole" checked="checked">user</input> </p>
        <p><input type="Submit"></input> </p>
    </fieldset>
</form>
</body>
</html>
