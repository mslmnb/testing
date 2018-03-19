<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <%--<a class="navbar-brand"><spring:message code="app.title"/></a>--%>
        <div class="navbar-brand"><spring:message code="app.title"/>: «${userTo.theme.name}» </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form:form class="navbar-form navbar-right" action="logout" method="post">
                        <sec:authorize access="isAuthenticated()">
                            <a class="btn btn-info" href="profile">${userTo.name} <spring:message code="app.profile"/></a>
                            <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                            </button>
                        </sec:authorize>
                    </form:form>
                </li>
                <jsp:include page="lang.jsp"/>
            </ul>
        </div>
    </div>
</div>
