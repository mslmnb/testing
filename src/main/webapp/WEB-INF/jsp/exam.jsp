<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src="resources/js/exam.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <form>
            <input id="userOldAnswerId" hidden>
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
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
