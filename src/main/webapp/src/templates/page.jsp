<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/resources/lib/bootstrap-5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/lib/stepper/bs-stepper.min.css">
    <title>Профорієнтаційна система</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Proforientation.ua</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                    aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/start/test">Розпочати тест</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="all-tests.html">Тести</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="all-univers.html">ВУЗи</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Вхід</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registration.html">Реєстрація</a>
                    </li>
                </ul>
                <span class="navbar-text">
                        Вітаємо, <a href="login.html">${user_email}</a>!
                    <!-- Left text-->
                    </span>
            </div>
        </div>

    </nav>
</header>

<content>
    <div class="container">
        ${content}
    </div>
</content>

<footer>

</footer>

<!-- JavaScript connections -->
<script src="/resources/lib/bootstrap-5.1.3/js/bootstrap.bundle.js"></script>
<script src="/resources/lib/stepper/bs-stepper.min.js"></script>
<script src="/resources/dist/main.js"></script>
</body>
</html>