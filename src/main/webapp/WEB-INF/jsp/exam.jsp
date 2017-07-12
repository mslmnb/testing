<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="headTag.jsp"/>

<body>
<script type="text/javascript" src="resources/js/exam.js" defer></script>
<jsp:include page="bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <form>
            <input id="oldUserAnswerId" hidden>
            <h3>
                <label class="question"> </label><br/>
            </h3>
            <div id="answersBox">
            </div>
        </form>
        <button id="first">В начало</button>
        <button id="prev">Назад</button>
        <button id="next">Вперед</button>
        <button id="last">В конец</button>

    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
