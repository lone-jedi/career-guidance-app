<h3>Список усі спеціальності</h3>
<hr>
<div class="row">
    <div class="col-3">
        <form action="/admin/specialty/add" method="post">
            <input  class="mb-3 input-group-text" type="text" placeholder="Назва спеціальності" name="title" required><br>
            <textarea class="mb-3" placeholder="Опис спеціальності" name="description"></textarea><br>
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
            <#list specialties as specialty>
            <tr>
                <td>${specialty.title}</td>
                <td>${specialty.description}</td>
                <td><a href="/admin/specialty/edit?id=${specialty.id}"><img src="/resources/img/icons/edit.png"></a></td>
                <td><a href="/admin/specialty/delete?id=${specialty.id}"><img src="/resources/img/icons/delete.png"></a></td>
            <tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>


