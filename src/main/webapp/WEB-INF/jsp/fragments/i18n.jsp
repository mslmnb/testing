<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    var i18n=[];
    <c:forEach var="key" items='<%=new String[]{
                    "common.deleted", "common.saved", "common.errorStatus", "common.search", "common.first",
                    "common.last", "common.next","common.previous","common.lengthMenu"}%>'>
        i18n['${key}'] = '<spring:message code="${key}"/>';
    </c:forEach>
</script>
