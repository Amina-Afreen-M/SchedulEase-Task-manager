<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Smart Prioritized Tasks</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
</head>
<body>
<h1>Smart Prioritized Tasks</h1>

<c:if test="${not empty list}">
    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Date</th>
            <th>Status</th>
        </tr>
        <c:forEach var="todo" items="${list}">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.date}</td>
                <td>${todo.status}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty list}">
    <p>No prioritized tasks found.</p>
</c:if>

<a href="${pageContext.request.contextPath}/viewToDoList">Back to To-Do List</a>

</body>
</html>
