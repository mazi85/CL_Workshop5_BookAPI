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

<table style="background-color: lightsteelblue">
    <thead style="background-color: gray">
    <tr >
        <th>isbn</th>
        <th>title</th>
        <th>author</th>
        <th>publisher</th>
        <th>type</th>

    </tr>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
        </tr>
    </tbody>
</table>

<div>
    <h4><a href="/admin/books/all">POWRÓT </a> </h4>
</div>

</body>
</html>


