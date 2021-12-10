<h1>Редагувати Спеціальність</h1>
<hr>
<form action="#" method="post">
    <input  type="hidden" value="${specialty.id}" name="id"><br>
    <h5 class="mt-1" >Загловок:</h5>
    <input class=" text" type="text" value="${specialty.title}" name="title" required><br>
    <h5 class="mt-3" >Опис:</h5>
    <textarea cols="80" rows="15" name="description">${specialty.description}</textarea><br>
    <input class="mt-3"  type="submit" value="Зберегти">
</form>