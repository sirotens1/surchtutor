<!DOCTYPE html>
<html>
<head>
    <title>SURCHTUTOR</title>
</head>
<body>
<h1>SURCHTUTOR</h1><hr>
<h3>Подробная информация о преподавателе ${user.name}</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Email: </b> ${user.email}<br>
<h4>Другие предметы ${user.name}</h4>
<#list subjects as subject>
    <div>
        <p><b>${subject.title}</b> ${subject.price} руб. | <a href="/subject/${subject.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Другие предметы не преподаёт</h3>
</#list>
<#if errorMessage??>
    <h2 style = "color: red">${errorMessage}</h2>
</#if>
</body>
</html>