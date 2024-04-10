<!DOCTYPE html>
<html>
<head>
    <title>SURCHTUTOR</title>
</head>
<body>
<h1>SURCHTUTOR</h1>
<hr>
<#if user.email??>
    <h3>Имя пользователя: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value= "Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
    <a href = "/login">Войти</a></h1>
</#if>
<h4>Найди репетитора из любой точки России</h4>
<form action="/" method="get">
    Поиск по названию предмета: <input type = "text" name = "title"><br>
    <input type = "hidden" name = "_csrf" value="${_csrf.token}">
    <input type = "submit" value="Поиск"/>
</form>
<#list subjects as subject>
    <div>
        <p><b>${subject.title}</b> ${subject.price} руб. | <a href="/subject/${subject.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Результата поиска нет</h3>
</#list>
<#if user.email??>
<hr>
<h3>Создать новое предложение</h3>
<form action="/subject/create" method="post" enctype="multipart/form-data">
    Название предмета: <input type="text" name="title"/><br><br>
    Описание предмета: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type = "hidden" name = "_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить предложение"/>
</form>
</#if>
</body>
</html>