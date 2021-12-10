<h1>Редагувати кафедру</h1>
<hr>

<#if error_message??>
    <div class="bg-alert text-white">
        ${error_message}
    </div>
</#if>

<form action="#" method="post">
    <input  type="hidden" value="${cathedra.id}" name="id"><br>
    <h5 class="mt-1" >Загловок:</h5>
    <input class=" text" type="text" value="${cathedra.title}" name="title" required><br>
    <h5 class="mt-1" >Оберіть відповідні спеціальності:</h5>
    <select class="selectpicker" multiple data-live-search="true">
        <option>Mustard</option>
        <option>Ketchup</option>
        <option>Relish</option>
    </select>
    <h5 class="mt-3" >Опис:</h5>
    <textarea cols="80" rows="15" name="description">${cathedra.description}</textarea><br>

    <input class="mt-3"  type="submit" value="Зберегти">
</form>