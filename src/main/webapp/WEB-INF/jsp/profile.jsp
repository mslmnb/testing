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
                <input type="hidden" name="id" id = "id" value="${userTo.id}">
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
                <button class="btn btn-info" type="submit">Сохранить и продолжить</button>
                <a class="btn btn-info" href="logout">Отмена</a>
            </form>
        </div>
    </div>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
