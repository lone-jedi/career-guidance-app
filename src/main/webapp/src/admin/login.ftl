<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/resources/lib/bootstrap-5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/admin_login.css">
    <title>Адмін панель</title>
</head>
<body>
<div class="back">
    <div class="div-center">
        <div class="content">
            <h3>Вхід</h3>
            <hr/>
            <form action="#" method="post">
                <#if error_msg??>
                    <div>
                        <p class="alert-warning">${error_msg}</p>
                    </div>
                </#if>

                <div class="form-group">
                    <label for="exampleInputEmail1">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email"
                           name="email" value="${email!}">
                </div>
                <div class="mt-2 form-group">
                    <label for="exampleInputPassword1">Пароль</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <button type="submit" class="mt-4 btn btn-primary">Увійти</button>
            </form>
        </div>
    </div>
</div>

<script src="/resources/lib/bootstrap-5.1.3/js/bootstrap.bundle.js"></script>

</body>
</html>