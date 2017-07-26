<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src="resources/js/report.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<jsp:useBean id="userReport" scope="request" type="kz.gala.testing.to.ExamReport"/>
<div class="jumbotron">
    <div class="container">
        <h3>Итоги тестирования</h3>
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

        <table class="table" cellspacing="7">
            <thead>
            <tr>
                <th>Тестирование по категории</th>
                <th>Всего</th>
                <th colspan="2">Ответы</th>
                <th>%</th>
            </tr>
            <tr>
                <th></th>
                <th>вопросов</th>
                <th>всего</th>
                <th>правильных</th>
                <th></th>
            </tr>
            </thead>
            <tr>
                <td>${userReport.themeName}</td>
                <td>${userReport.countOfQuestions}</td>
                <td>${userReport.countOfAnswers}</td>
                <td>${userReport.countOfCorrectAnswers}</td>
                <td><fmt:formatNumber value="${userReport.procentOfCorrectAnswers}" pattern="0.0"/></td>
            </tr>
        </table>
        <br>
        <label>Итоговая оценка: ${userReport.mark}</label>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>