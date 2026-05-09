<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Text Quest</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="container">

    <h1>Text Quest</h1>

    <h2>Предыстория</h2>

    <p>
        Тебя захватили неизвестные пришельцы
        и поместили на огромный космический корабль.
    </p>

    <p>
        Ты не знаешь,
        сколько времени прошло с момента похищения.
    </p>

    <p>
        Во время полета в корабль
        внезапно что-то врезалось.
    </p>

    <p>
        Раздался мощный удар,
        включилась аварийная сирена,
        а после этого ты потерял сознание.
    </p>

    <p>
        Очнувшись,
        ты обнаружил,
        что вокруг никого нет.
    </p>

    <p>
        Корабль поврежден,
        освещение работает с перебоями,
        а в коридорах стоит пугающая тишина.
    </p>

    <p>
        Теперь твоя задача —
        выбраться с этого корабля
        и выжить.
    </p>

    <br>

    <form action="start" method="get">

        <button type="submit">
            Начать игру
        </button>

    </form>

</div>

</body>
</html>