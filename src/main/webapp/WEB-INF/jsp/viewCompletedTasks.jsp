<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Completed Tasks</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <style>
        body, div, td, p { font-family: 'Inter'; font-size: 13pt; color: #dfe1e5; }
        a { font-family: 'Inter'; font-size: 13pt; color: #6b9bfa; }
    </style>
</head>
<body>

<h1>Completed Tasks</h1>

<c:if test="${not empty completedTasks}">
    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Date</th>
            <th>Status</th>
            <th>Time Spent (minutes)</th> <!-- New column for time spent -->
        </tr>
        <c:forEach var="task" items="${completedTasks}">
            <tr>
                <td><a href="${pageContext.request.contextPath}/taskDetails?id=${task.id}">${task.id}</a></td>
                <td>${task.description}</td>
                <td>${task.date}</td>
                <td>${task.status}</td>
                <td>${task.timeSpent}</td> <!-- Display time spent -->
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty completedTasks}">
    <p>No completed tasks.</p>
</c:if>

<a href="${pageContext.request.contextPath}/viewToDoList">Back to To-Do List</a>

</body>
</html>
