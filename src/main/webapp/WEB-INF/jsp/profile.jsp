<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<section>
<jsp:include page="fragments/bodyHeader.jsp"/>



<div class="jumbotron">
    <div class="container">
        <h3>Профиль пользователя</h3>
        <br>
        <jsp:useBean id="userTo" scope="request" type="kz.gala.testing.to.UserTo"/>
        <form method="post" action="user/profile">
            <input type="number" hidden name = "id" value="${userTo.id}">
            <table class="table">
                <thead>
                </thead>
                <tr>
                    <td>ФИО</td>
                    <td><input type="text" name="name" value="${userTo.name}"></td>
                </tr>
                <tr>
                    <td>Должность</td>
                    <td><input type="text" name="position" value="${userTo.position}"></td>
                </tr>
                <tr>
                    <td>Подразделение</td>
                    <td><input type="text" name="department" value="${userTo.department}"></td>
                </tr>
            </table>
            <button type="submit">Сохранить</button>
            <button onclick="window.history.back()">Отмена</button>
        </form>
    </div>
</div>
    </section>
</body>
</html>
