<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Details</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <style>
        body, div, td, p { font-family: 'Inter'; font-size: 13pt; color: #dfe1e5; }
        a { font-family: 'Inter'; font-size: 13pt; color: #6b9bfa; }
    </style>
</head>
<body>

<h1>Task Details</h1>

<c:if test="${not empty task}">
    <p><strong>ID:</strong> ${task.id}</p>
    <p><strong>Description:</strong> ${task.description}</p>
    <p><strong>Date:</strong> ${task.date}</p>
    <p><strong>Status:</strong> ${task.status}</p>
    <p><strong>Time Spent:</strong> ${task.timeSpent} minutes</p> <!-- Display time spent -->
    <div id="timer">
        <p>Task Time: <span id="timeSpent">0</span> minutes</p>
        <button type="button" class="btn btn-info" onclick="startTimer()">Start</button>
        <button type="button" class="btn btn-warning" onclick="stopTimer()">Stop</button>
    </div>
    <a href="${pageContext.request.contextPath}/viewCompletedTasks">Back to Completed Tasks</a>
</c:if>

<c:if test="${empty task}">
    <p>Task not found.</p>
    <a href="${pageContext.request.contextPath}/viewCompletedTasks">Back to Completed Tasks</a>
</c:if>

<script>
    var timer;
    function startTimer() {
        var timeSpent = 0;
        timer = setInterval(() => {
            timeSpent += 1;
            document.getElementById('timeSpent').innerText = timeSpent;
        }, 60000); // Increase time every minute
    }

    function stopTimer() {
        clearInterval(timer);
        var timeSpent = document.getElementById('timeSpent').innerText;
        alert("You spent " + timeSpent + " minutes on this task.");
    }
</script>

</body>
</html>
