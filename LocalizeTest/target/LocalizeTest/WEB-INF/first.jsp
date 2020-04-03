<%--
  Created by IntelliJ IDEA.
  User: vladc
  Date: 29.03.20
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title><spring:message code="app.title"/></title>
</head>
<body>
<div id="text-space">
<p>
    <spring:message code="app.page.body"/>
</p>
</div>
<div id="select-lang">
    <p><a href="?lang=by"><spring:message code="app.lang.by"/></a></p>
    <p><a href="?lang=ru"><spring:message code="app.lang.ru"/></a></p>
    <p><a href="?lang=en"><spring:message code="app.lang"/></a></p>
</div>
<P></P>
</body>
</html>
