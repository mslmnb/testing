<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>
<script type="text/javascript" src="resources/js/userDatatables.js" defer></script>
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
                <div class="col-sm-10">
                    <div class="text-16px" id="themeName"></div>
                </div>
                <div class="col-sm-1">
                    <a href="admin/themes/"><spring:message code="theme.themes"/></a>
                </div>
            </div>
        </div>

            <br>
            <h3><spring:message code="user.title"/>:</h3>

            <br/>
            <a class="btn btn-primary" onclick="add()">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                <spring:message code="common.add"/>
            </a>
            <br/><br/>
            <table class="table table-striped display" id="datatable">
                <thead>
                <tr>
                    <th class="col-md-1"><spring:message code="user.login"/></th>
                    <th class="col-md-3"><spring:message code="user.name"/></th>
                    <th class="col-md-3"><spring:message code="user.position"/></th>
                    <th class="col-md-2"><spring:message code="user.department"/></th>
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
                            <label for="login" class="control-label col-xs-3"><spring:message code="user.login"/></label>
                            <div class="col-xs-9">
                            <input type="text" class="form-control" id="login" name="login"
                                      placeholder="<spring:message code="user.login"/>">
                            </textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label col-xs-3"><spring:message code="user.password"/></label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="password" name="password"
                                       placeholder="<spring:message code="user.password"/>">
                                </textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="control-label col-xs-3"><spring:message code="user.name"/></label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="name" name="name"
                                       placeholder="<spring:message code="user.name"/>">
                                </textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="position" class="control-label col-xs-3"><spring:message code="user.position"/></label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="position" name="position"
                                       placeholder="<spring:message code="user.position"/>">
                                </textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="department" class="control-label col-xs-3"><spring:message code="user.department"/></label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="department" name="department"
                                       placeholder="<spring:message code="user.department"/>">
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
        i18n["addTitle"] = "<spring:message code="user.add"/>";
        i18n["editTitle"] = "<spring:message code="user.edit"/>";
    </script>
</html>