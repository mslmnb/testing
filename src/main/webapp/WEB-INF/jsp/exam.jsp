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
        <button class="btn btn-primary" type="button" id="first">
            <span class="glyphicon glyphicon-fast-backward" aria-hidden="true"></span>
        </button>
        <button class="btn btn-primary" type="button" id="prev">
            <span class="glyphicon glyphicon-backward" aria-hidden="true"></span>
        </button>
        <button class="btn btn-primary" type="button" id="next">
            <span class="glyphicon glyphicon-forward" aria-hidden="true"></span>
        </button>
        <button class="btn btn-primary" type="button" id="last">
            <span class="glyphicon glyphicon-fast-forward" aria-hidden="true"></span>
        </button>

        <br><br><br>
        <a class="btn btn-info" href="exam/report"  id="finish">Завершить тестирование</a>

    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>