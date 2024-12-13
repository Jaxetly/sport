<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список спортивного инвентаря</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
    <div  class="container mt-5">
        <h1 class="text-center">Список спортивного инвентаря</h1>
        <ul class="list-group mt-4">
            <c:forEach var="item" items="${items}">
                <li class="list-group-item">
                    <a href="inventory?id=${item.id}">${item.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>