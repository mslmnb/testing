<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <%-- резолвить ссылки относительно контекста приложения (testing) --%>
    <base href="${pageContext.request.contextPath}/"/>
    <title>ТЕСТИРОВАНИЕ</title>
</head>
<body>
<h2>Идет тестирование</h2>

    <section>
        <jsp:useBean id="question" scope="request" type="kz.gala.testing.model.Question"/>
        <input type="hidden" name="id" value="${question.id}">
        <input type="hidden" name="id" value="${nextId}">
        <input type="hidden" name="id" value="${prevId}">
        <h4>Вопрос:</h4>
        <p>${question.body}</p>
        <form method="post" action="exam/previous/${question.id}">
            <c:if test="${prevId}">
                <button type="submit" >Назад</button>
            </c:if>
        </form>
        <form method="post" action="exam/next/${question.id}">
            <c:if test="${nextId}">
                <button type="submit">Вперед</button>
            </c:if>
        </form>
    </section>
</body>
</html>
