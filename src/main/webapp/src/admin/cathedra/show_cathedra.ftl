<h3>Список усіх каферд</h3>
<hr>
<a href="/admin/cathedra/add" class="btn btn-primary">Додати</a>
<div class="row">
    <div class="col-3">
        <form action="/admin/zno/add" method="post">
            <input class="mb-3 input-group-text" type="text" placeholder="Назва ЗНО" name="title" required><br>
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
                <th scope="col">Спеціальності</th>
                <th scope="col">Екзамени</th>
                <th scope="col">Ред</th>
                <th scope="col">Видалити</th>
            </tr>
            </thead>
            <tbody>
            <#list cathedras as cathedra>
            <tr>
                <td>${cathedra.title}</td>
                <td>${cathedra.description}</td>
                <td>
                    <ul>
                        <#list cathedra.specialties as specialty>
                            <li>${specialty.title}</li>
                        </#list>
                    </ul>
                </td>
                <td>
                    <ul>
                        <#list cathedra.exams as exam>
                            <li>${exam.title}</li>
                        </#list>
                    </ul>
                </td>
                <td><a href="/admin/zno/edit?id=${cathedra.id}"><img src="/resources/img/icons/edit.png"></a></td>
                <td><a href="/admin/zno/delete?id=${cathedra.id}"><img src="/resources/img/icons/delete.png"></a></td>
            <tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>


