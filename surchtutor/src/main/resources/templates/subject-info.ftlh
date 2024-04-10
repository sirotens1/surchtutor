<!DOCTYPE html>
<html>
<head>
    <title>SURCHTUTOR</title>
</head>
<body>
<h1>SURCHTUTOR</h1><hr>
<h4>Подробная информация</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название предмета: </b>${subject.title}<br>
<b>Подробнее: </b>${subject.description}<br>
<b>Цена: </b>${subject.price}<br>
<b>Город: </b>${subject.city}<br>
<b>Автор: </b><a href="/user/${subject.user.id}"> ${subject.user.name}</a><br>
</body>
</html>