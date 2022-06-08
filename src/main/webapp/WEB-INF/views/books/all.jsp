<%--
  wg template Michała
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        table,th, td{
            border: 2px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<div>
    <h4><a href="/admin/books/add">+ DODAJ KSIĄŻKĘ</a> </h4>
</div>

<table style="background-color: lightsteelblue">
    <thead style="background-color: gray">
    <tr >
        <th>isbn</th>
        <th>title</th>
        <th>author</th>
        <th>ACTIONS</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td style="width: 300px">
                <a href="/admin/books/delete/${book.id}">USUŃ</a>
                <a href="/admin/books/edit/${book.id}">EDYTUJ</a>
                <a href="/admin/books/read/${book.id}">DETAILS</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>


