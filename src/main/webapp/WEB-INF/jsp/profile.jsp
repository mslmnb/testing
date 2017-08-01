<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<section>
    <jsp:include page="fragments/bodyHeader.jsp"/>


    <div class="jumbotron">
        <div class="container">
            <h3><spring:message code="app.profile"/></h3>
            <br>
            <jsp:useBean id="userTo" scope="request" type="kz.gala.testing.to.UserTo"/>
            <form:form method="post" action="user/profile">
                <input type="hidden" name="id" id = "id" value="${userTo.id}">
                <label class="control-label col-sm-2"><spring:message code="userTo.name"/></label>
                <div class="col-sm-10">
                    <input type="text" name="name" value="${userTo.name}">
                </div>
                <br><br>
                <label class="control-label col-sm-2"><spring:message code="userTo.position"/></label>
                <div class="col-sm-10">
                    <input type="text" name="position" value="${userTo.position}">
                </div>
                <br><br>
                <label class="control-label col-sm-2"><spring:message code="userTo.department"/></label>
                <div class="col-sm-10">
                    <input type="text" name="department" value="${userTo.department}">
                </div>
                <br><br><br>
                <div class="col-sm-10">
                        <button class="btn btn-info" type="submit">
                            <spring:message code="userTo.save"/>
                        </button>
                </div>
            </form:form>
        </div>
    </div>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
