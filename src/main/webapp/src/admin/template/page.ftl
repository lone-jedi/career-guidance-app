<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/resources/lib/bootstrap-5.1.3/css/bootstrap.min.css">
    <title>Адмін панель</title>
</head>
<body>

<header class="mb-4">
    <nav class="container navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Admin 1.0</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        ЗНО
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/admin/zno/all">Показати всі</a></li>
                    </ul>
                </li>
            </ul>
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

<script src="/resources/lib/jquery/jquery-3.6.0.min.js"></script>
<script src="/resources/lib/bootstrap-5.1.3/js/bootstrap.bundle.js"></script>
</body>
</html>