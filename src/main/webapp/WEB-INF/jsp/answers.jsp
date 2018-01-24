<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/answerDatatables.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">

        <br>

        <div class="well">
            <div class="row">
                <div class="col-sm-1">
                    <div><spring:message code="theme.theme"/>:</div>
                    <div id="themeId" hidden>${themeId}</div>
                </div>
                <div class="col-sm-9">
                    <div class="text-16px" id="themeName"></div>
                </div>
                <div class="col-sm-1">
                    <a href="admin/themes/${themeId}/questions"><spring:message code="theme.questions"/></a>
                </div>
                <div class="col-sm-1">
                    <a href="admin/themes/"><spring:message code="theme.themes"/></a>
                </div>

            </div>

            <br>
            <div class="row">
                <div class="col-sm-1">
                    <div><spring:message code="question.question"/>:</div>
                    <div id="questionId" hidden>${questionId}</div>
                </div>
                <div class="col-sm-11">
                    <div class="text-16px" id="questionBody"></div>
                </div>
            </div>
        </div>

        <h3><spring:message code="answer.title"/>:</h3>

        <br/>
        <a class="btn btn-primary" onclick="add()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            <spring:message code="common.add"/>
        </a>
        <br/><br/>
        <table class="table table-striped display" id="datatable">
            <thead>
            <tr>
                <th class="col-md-1"><spring:message code="answer.is_correct"/></th>
                <th class="col-md-9"><spring:message code="answer.body"/></th>
                <th class="col-md-1"></th>
                <th class="col-md-1"></th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="body" class="control-label col-xs-3"><spring:message code="answer.body"/></label>
                        <div class="col-xs-9">
                            <textarea rows="5" class="form-control" id="body" name="body"
                                      placeholder="<spring:message code="answer.body"/>">
                            </textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button class="btn btn-primary" type="button" onclick="save()">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </button>
                        </div>

                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>

<jsp:include page="fragments/i18n.jsp"/>
<script type="text/javascript">
    i18n["addTitle"] = "<spring:message code="answer.add"/>";
    i18n["editTitle"] = "<spring:message code="answer.edit"/>";
    i18n["answer.correct"] = "<spring:message code="answer.correct"/>";
    i18n["answer.wrong"] = "<spring:message code="answer.wrong"/>";
</script>

</html>