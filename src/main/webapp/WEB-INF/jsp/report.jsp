<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src="resources/js/report.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<jsp:useBean id="userReport" scope="request" type="kz.gala.testing.to.ExamReport"/>
<div class="jumbotron">
    <div class="container">
        <h3><spring:message code="examReport.results"/></h3>
        <br>

        <label class="control-label col-sm-2"><spring:message code="user.name"/></label>
        <div class="col-sm-10">${userReport.userName}</div>
        <br><br>
        <label class="control-label col-sm-2"><spring:message code="user.position"/></label>
        <div class="col-sm-10">${userReport.userPosition}</div>
        <br><br>
        <label class="control-label col-sm-2"><spring:message code="user.department"/></label>
        <div class="col-sm-10">${userReport.userDepartment}</div>
        <br><br><br>

        <div class="table-bordered">
            <table></table>
        </div>

        <br>
        <div class="col-sm-4">
            <label><spring:message code="examReport.subject"/></label>
        </div>
        <div class="col-sm-2">
            <label><spring:message code="examReport.totalQuestionPart1"/></label>
        </div>
        <div class="col-sm-4">
            <label><spring:message code="examReport.answers"/></label>
        </div>
        <div class="col-sm-2">
            <label>%</label>
        </div>

        <div class="col-sm-4"></div>
        <div class="col-sm-2">
            <label><spring:message code="examReport.totalQuestionPart2"/></label>
        </div>
        <div class="col-sm-2">
            <label><spring:message code="examReport.totalAnswers"/></label>
        </div>
        <div class="col-sm-2">
            <label><spring:message code="examReport.correctAnswers"/></label>
        </div>
        <div class="col-sm-2"></div>
        <br>

        <br><br>
        <div class="table-bordered">
            <table></table>
        </div>

        <div class="col-sm-4">${userReport.themeName}</div>
        <div class="col-sm-2">${userReport.countOfQuestions}</div>
        <div class="col-sm-2">${userReport.countOfAnswers}</div>
        <div class="col-sm-2">${userReport.countOfCorrectAnswers}</div>
        <div class="col-sm-2"><fmt:formatNumber value="${userReport.procentOfCorrectAnswers}" pattern="0.0"/></div>

        <br><br>
        <div class="table-bordered">
            <table></table>
        </div>
        <br><br>

        <label><spring:message code="examReport.mark"/>:</label>
        <c:if test="${userReport.mark>0}">
            <label><spring:message code="examReport.positiveMark"/></label>
        </c:if>
        <c:if test="${userReport.mark==0}">
            <label><spring:message code="examReport.negativeMark"/></label>
        </c:if>

    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>