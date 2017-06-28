<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <head>
        <title>ТЕСТИРОВАНИЕ</title>

        <%-- резолвить ссылки относительно контекста приложения (testing) --%>
        <base href="${pageContext.request.contextPath}/"/>

        <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js" defer></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
        <%--<script type="text/javascript" src="webjars/datatables/1.10.15/media/js/jquery.dataTables.min.js" defer></script>--%>
        <%--<script type="text/javascript" src="webjars/datatables/1.10.15/media/js/dataTables.bootstrap.min.js" defer></script>--%>
        <%--<script type="text/javascript" src="webjars/noty/2.4.1/js/noty/packaged/jquery.noty.packaged.min.js" defer></script>--%>
        <%--<script type="text/javascript" src="../../resources/js/exam.js"></script>--%>
    </head>
</head>
<body>


    <a href="exam">Начать экзамен</a>
</body>
</html>