<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header navbar-brand">ТЕСТИРОВАНИЕ</div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" role="form" action="spring_security_check" method="post">
            <div class="form-group">
                <input type="text"
                       placeholder="Логин"
                       class="form-control"
                       name="username">
            </div>
            <div class="form-group">
                <input type="password"
                       placeholder="Пароль"
                       class="form-control"
                       name="password">
            </div>
            <button type="submit" class="btn btn-success">
                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
            </button>
            </form>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container">
        <c:if test="${param.error}">
            <%--вывод сообщения об ошибке при неудачном логировании--%>
            <div class="error">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
        <c:if test="${not empty param.message}">
            <div class="message">
                <spring:message code="${param.message}"/>
            </div>
        </c:if>
        <br/>
        <p>
            <%--кнопка «Войти как Admin»--%>
            <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('Admin', 'AdminPassword')">
                Войти как Admin
            </button>
            <%--кнопка «Войти как User»--%>
            <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('User', 'UserPassword')">
                Войти как User
            </button>
        </p>
        <br/>
        <p>Стек технологий: <a href="http://projects.spring.io/spring-security/">Spring Security</a>,
            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring MVC</a>,
            <a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>,
            <a href="http://spring.io/blog/2014/05/07/preview-spring-security-test-method-security">Spring Security Test</a>,
            <a href="http://hibernate.org/orm/">Hibernate ORM</a>,
            <%--<a href="http://hibernate.org/validator/">Hibernate Validator</a>,--%>
            <a href="http://www.slf4j.org/">SLF4J</a>,
            <a href="https://github.com/FasterXML/jackson">Json Jackson</a>,
            <a href="http://ru.wikipedia.org/wiki/JSP">JSP</a>,
            <%--<a href="http://en.wikipedia.org/wiki/JavaServer_Pages_Standard_Tag_Library">JSTL</a>,--%>
            <a href="http://tomcat.apache.org/">Apache Tomcat</a>,
            <a href="http://www.webjars.org/">WebJars</a>,
            <%--<a href="http://datatables.net/">DataTables plugin</a>,--%>
            <%--<a href="http://ehcache.org">Ehcache</a>,--%>
            <a href="http://www.postgresql.org/">PostgreSQL</a>,
            <a href="http://junit.org/">JUnit</a>,
            <%--<a href="http://hamcrest.org/JavaHamcrest/">Hamcrest</a>,--%>
            <a href="http://jquery.com/">jQuery</a>,
            <%--<a href="http://ned.im/noty/">jQuery notification</a>,--%>
            <a href="http://getbootstrap.com/">Bootstrap</a>.</p>
    </div>
</div>
<div class="container">
    <div class="lead">
        &nbsp;&nbsp;&nbsp;<a href="https://github.com/mslmnb/testing">Java проект</a> с
        авторизацией и интерфейсом на основе ролей (USER, ADMIN).
        Администратор может создавать/редактировать/удалять пользователей/тесты, назначать для пользователей тесты.
        Пользователь может корректировать свой профиль, пройти тест и получить итоговый отчет по результату
        тестирования.
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript">
    function setCredentials(username, password) {
        $('input[name="username"]').val(username);
        $('input[name="password"]').val(password);
    }
</script>
</body>
</html>