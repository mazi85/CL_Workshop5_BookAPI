<%--
  wg template Michała
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="book">
    isbn: <form:input path="isbn"/>
    <br/>
    <form:errors path="isbn"/>
    <br/>

    title: <form:input path="title"/>
    <br/>
    <form:errors path="title"/>
    <br/>

    author: <form:input path="author"/>
    <br/>
    <form:errors path="author"/>
    <br/>

    publisher: <form:input path="publisher"/>
    <br/>
    <form:errors path="publisher"/>
    <br/>

    type: <form:input path="type"/>
    <br/>
    <form:errors path="type"/>
    <br/>

    <form:hidden path="id"/>


    <input type="submit">
</form:form>

</body>
</html>
