<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<jsp:useBean id="userReport" scope="request" type="kz.gala.testing.to.UserTo"/>
<div class="jumbotron">
    <div class="container">
        <h3>Профиль пользователя</h3>
        <br>

        <table class="table">
            <thead>
            </thead>
            <tr>
                <td>ФИО</td>
                <td>${userReport.userName}</td>
            </tr>
            <tr>
                <td>Должность</td>
                <td>${userReport.userPosition}</td>
            </tr>
            <tr>
                <td>Подразделение</td>
                <td>${userReport.userDepartment}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
