<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="testing" tagdir="/WEB-INF/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h3><spring:message code="app.profile"/></h3>
        <br/><br/>

        <form:form modelAttribute="userTo" class="form-horizontal" method="post" action="user/profile">
            <input type="hidden" name="id" id = "id" value="${userTo.id}">

            <spring:message code="userTo.name" var="name"/>
            <testing:inputField name="name" label="${name}"/>

            <spring:message code="userTo.position" var="position"/>
            <testing:inputField name="position" label="${position}"/>

            <spring:message code="userTo.department" var="department"/>
            <testing:inputField name="department" label="${department}"/>

            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                <button class="btn btn-info" type="submit">
                    <spring:message code="userTo.save"/>
                </button>
            </div>
        </form:form>

    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
