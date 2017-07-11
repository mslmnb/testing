<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%-- резолвить ссылки относительно контекста приложения (testing) --%>
    <base href="${pageContext.request.contextPath}/"/>
    <title>ТЕСТИРОВАНИЕ</title>
        <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js" ></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" ></script>

</head>
<body>
<script type="text/javascript" src="resources/js/exam.js"></script>

<h2>Идет тестирование</h2>
    <form>
        <input id = "oldUserAnswerId" hidden value=${undefined}>
        <label class="question"> </label><br />
        <div id="answersBox">
        </div>
    </form>
    <button id="first">В начало</button>
    <button id="prev">Назад</button>
    <button id="next">Вперед</button>
    <button id="last">В конец</button>

</body>
</html>
