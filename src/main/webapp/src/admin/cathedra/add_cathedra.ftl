<h1>Додати кафедру</h1>
<hr>
<form action="#" method="post">
    <h5 class="mt-1" >Загловок:</h5>
    <input class=" text" type="text" value="${(cathedra.title)!}" name="title" required><br>
    <h5 class="mt-1" >Оберіть відповідні спеціальності:</h5>
    <select class="selectpicker" multiple data-live-search="true" name="specialties">
        <#list cathedra.specialties as specialty>
            <option value="${specialty.id}">${specialty.title}</option>
        </#list>
    </select>
    <h5 class="mt-1" >Оберіть відповідні ЗНО:</h5>
    <select class="selectpicker" multiple data-live-search="true" name="exams">
        <#list cathedra.exams as exam>
            <option value="${exam.id}">${exam.title}</option>
        </#list>
    </select>
    <h5 class="mt-3" >Опис:</h5>
    <textarea cols="80" rows="15" name="description">${(cathedra.description)!}</textarea><br>

    <input class="mt-3"  type="submit" value="Зберегти">
</form>