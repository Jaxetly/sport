<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Детали инвентаря</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h4 class="card-title">Детали спорт-инвентаря: ${item.name}</h4>
    <div class="card mt-4">
        <ul class="list-group">
            <li class="list-group-item"><strong>Параметры: ${item.parameters}</strong></li>
            <li class="list-group-item"><strong>Возраст: ${item.age}</strong></li>
            <li class="list-group-item"><strong>Условия размещения: ${item.placementConditions}</strong></li>
        </ul>
    </div>
</div>
    <div class="text-center mt-4">
        <a href="/" class="btn btn-primary">Назад к списку</a>
    </div>
</body>
</html>