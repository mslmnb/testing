<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <jsp:include page="fragments/headTag.jsp"/>

<body>
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <div class="jumbotron">
        <div class="container">
            <a  class="btn btn-info" href="user/profile">Начать тестирование</a>
        <br><br><br>
        <p>Стек технологий: <a hidden href="http://projects.spring.io/spring-security/">Spring Security</a>,
            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring MVC</a>,
            <a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>,
            <%--<a href="http://spring.io/blog/2014/05/07/preview-spring-security-test-method-security">Spring Security--%>
                Test</a>,
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

</body>
</html>