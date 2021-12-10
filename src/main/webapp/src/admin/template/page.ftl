<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
                <li class="nav-item">
                    <a class="nav-link" href="/admin/university/all">ВНЗ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/specialty/all">Спеціальності</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/zno/all">ЗНО</a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<content>
    <div class="container">
        <#if content??>
            ${content}
        <#else>
            404 Not Found
        </#if>
    </div>
</content>

<footer>

</footer>

<#if message??>
    <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
        <div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="rounded me-2 bi bi-app bg-primary" viewBox="0 0 16 16">
                    <path d="M11 2a3 3 0 0 1 3 3v6a3 3 0 0 1-3 3H5a3 3 0 0 1-3-3V5a3 3 0 0 1 3-3h6zM5 1a4 4 0 0 0-4 4v6a4 4 0 0 0 4 4h6a4 4 0 0 0 4-4V5a4 4 0 0 0-4-4H5z"/>
                </svg>
                <#--            <img src="..." class="rounded me-2" alt="...">-->
                <strong class="me-auto">Повідомлення</strong>
                <small>зараз</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Закрыть"></button>
            </div>
            <div id="toast-message" class="toast-body bg-primary text-white"><strong>${message}</strong></div>
        </div>
    </div>

    <!-- VERY BAD! -->
    <script>
        window.addEventListener("load", function() {
            let toastHtml = document.getElementById('liveToast');
            let toast = bootstrap.Toast.getOrCreateInstance(toastHtml);
            if(document.getElementById('toast-message').innerHTML !== "") {
                toast.show();
            }
        });
    </script>
</#if>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>