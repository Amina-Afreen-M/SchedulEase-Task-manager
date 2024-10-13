<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Today's Tasks</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <script>
        // Timer function
        function startTimer(duration, display) {
            var timer = duration, minutes, seconds;
            var interval = setInterval(function () {
                minutes = parseInt(timer / 60, 10);
                seconds = parseInt(timer % 60, 10);
                seconds = seconds < 10 ? "0" + seconds : seconds;

                display.textContent = minutes + ":" + seconds; // Update the display

                if (--timer < 0) {
                    clearInterval(interval); // Stop the timer
                    display.textContent = "Time's up!";
                    toastr.warning("Time's up! Please review your tasks.");
                }
            }, 1000);
        }

        window.onload = function () {
            var timeLimit = 60 * 30; // 30 minutes countdown
            var display = document.querySelector('#timer'); // Get the timer display
            startTimer(timeLimit, display); // Start the timer

            // Show any messages passed from the controller
            const message = "${message}";
            if (message) {
                toastr.success(message);
            }
        };
    </script>
    <style>
        body, div, td, p { font-family: 'Inter'; font-size: 13pt; color: #dfe1e5; }
        a { font-family: 'Inter'; font-size: 13pt; color: #6b9bfa; }
    </style>
</head>
<body>

<h1>Today's Tasks</h1>
<!-- Timer Display -->
<h2>Time Remaining: <span id="timer">30:00</span></h2>

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
    <p>No tasks for today.</p>
</c:if>

<a href="${pageContext.request.contextPath}/viewToDoList">Back to To-Do List</a>

</body>
</html>
