<h3>Список усіх ВНЗ</h3>
<hr>
<div class="row">
    <div class="col-3">
        <form action="/admin/zno/add" method="post">
            <input  class="mb-3 input-group-text" type="text" placeholder="Назва ЗНО" name="title"><br>
            <textarea class="mb-3" placeholder="Опис ЗНО" name="description"></textarea><br>
            <input type="submit" class="btn btn-primary" value="Додати">
        </form>
    </div>
    <div class="col-9">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Назва</th>
                <th scope="col">Опис</th>
                <th scope="col">Ред</th>
                <th scope="col">Видалити</th>
            </tr>
            </thead>
            <tbody>
            <#list exams as exam>
            <tr>
                <td>${exam.title}</td>
                <td>${exam.description}</td>
                <td><a href="/admin/zno/edit?id=${exam.id}"><img src="/resources/img/icons/edit.png"></a></td>
                <td><a href="/admin/zno/delete?id=${exam.id}"><img src="/resources/img/icons/delete.png"></a></td>
            <tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>

<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
    <div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <#--            <img src="..." class="rounded me-2" alt="...">-->
            <strong class="me-auto">Повідомлення</strong>
            <small>зараз</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Закрыть"></button>
        </div>
        <div id="toast-message" class="toast-body bg-info">${message}</div>
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
<#--<a class="btn btn-primary" href="/admin/zno/add">Додати</a>-->

