<div class="row">
  <div class="col-md-5 mx-auto">
    <div id="first">
      <div class="myform form ">
        <div class="logo mb-3">
          <div class="col-md-12 text-center">
            <h1>Вхід</h1>
          </div>
        </div>
        <#if error_msg??>
          <div>
            <p class="alert-warning">${error_msg}</p>
          </div>
        </#if>

        <form action="/login" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">Email адреса</label>
            <input type="email" name="email" class="form-control" id="email" name="email"
                   aria-describedby="emailHelp" placeholder="Введіть email"
                  value="${email!}">
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Пароль</label>
            <input type="password" name="password" id="password" class="form-control"
                   aria-describedby="emailHelp" placeholder="Введіть пароль">
          </div>
          <br>
          <div class="col-md-12 text-center ">
            <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Вхід</button>
          </div>
          <br>
          <div class="form-group">
            <p class="text-center">Немає аккаунта? <a href="/registration" id="signup">Зареєструватися</a></p>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>