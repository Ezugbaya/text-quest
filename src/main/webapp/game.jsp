<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Text Quest</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="container">

    <h2>
        Игрок: ${playerName}
    </h2>

    <h3>
        Ходов: ${stepsCount}
    </h3>

    <h1>
        ${question}
    </h1>

    <%
        Boolean finalStep =
                (Boolean) request.getAttribute("finalStep");
    %>

    <% if (finalStep) { %>

        <h2>${result}</h2>

        <a href="${pageContext.request.contextPath}/start">
            Начать заново
        </a>

    <% } else { %>

        <form action="${pageContext.request.contextPath}/game"
              method="post">

            <button name="answer" value="1">
                ${firstAnswer}
            </button>

            <br><br>

            <button name="answer" value="2">
                ${secondAnswer}
            </button>

        </form>

    <% } %>

</div>

</body>
</html>