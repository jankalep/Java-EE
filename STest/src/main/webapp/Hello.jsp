
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"   %>
<html>
<head>
    <title>Привет пользователь</title>
</head>
<body>
    <H1>Привет, ${name}</H1>
    <h2>
        <%
        if ((request.getSession().getAttribute("admin") != null) && ((boolean)request.getSession().getAttribute("admin"))) {
            out.println("Вы являетесь админом!!!!");
            out.println("<p> Вы можете просматривать и редактировать список пользователей</p>");
        }
    %>
    </h2>
       <c:if test="${base!=null}">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>Name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
            <c:forEach var="u" items="${base}">
                <tr>
                    <td><c:out value="${u.name}" /></td>
                    <td><c:out value="${u.login}" /></td>
                    <td><c:out value="${u.password}" /></td>
                    <td>
                        <a href="/hello-servlet?id=<c:out value='${u.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <p><a href="index.jsp">Back</a> </p>
</body>
</html>
