<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
                        <a class="nav-link" aria-current="page" href="/user/start/test">Розпочати тест</a>
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
                    <#if user_email??>
                        Вітаємо, <a href="/user/profile">${user_email}</a>! <a href="/logout" class="btn btn-info">Вийти</a>
                    <#else>
                        Вітаємо, гість! <a href="/login" class="btn btn-primary">Увійти</a>
                    </#if>

                    <!-- Left text-->
                    </span>
            </div>
        </div>

    </nav>
</header>

<content>
    <div class="container">
        <#if content??>
            ${content}
        <#else>
            <h1>Головна сторінка</h1>
        </#if>
    </div>
</content>

<footer>

</footer>

<!-- JavaScript connections -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="/resources/lib/stepper/bs-stepper.min.js"></script>
<script src="/resources/dist/main.js"></script>
</body>
</html>