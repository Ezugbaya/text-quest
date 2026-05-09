<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Text Quest</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="container">

    <h1>Добро пожаловать в Text Quest</h1>

    <form action="start" method="post">

        <label>Введите имя:</label>

        <br><br>

        <input type="text"
               name="playerName">

        <br><br>

        <button type="submit">
            Начать игру
        </button>

    </form>

</div>

</body>
</html>