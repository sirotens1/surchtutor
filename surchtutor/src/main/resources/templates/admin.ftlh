<!DOCTYPE html>
<html>
<head>
    <title>SURCHTUTOR</title>
</head>
<body>
<h1>SURCHTUTOR</h1><hr>
<h4>Панель администратора</h4>
<table>
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Отредактировать роль</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/edit-active/${user.id}/false" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th>
                <form action="/admin/user/edit-active/${user.id}/true" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Разбан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Редактирование</a> </th>
            <th><a href="/user/${user.id}">Подробности</a></th>
        </tr>
            <#else>
                <h3>Пользователей нет</h3>
            </#list>
</table>
</body>
</html>