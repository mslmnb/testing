<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="name"
              required="true"
              description="Name of corresponding property in bean object" %>
<%@ attribute name="label"
              required="true"
              description="Field label" %>

<spring:bind path="${name}">
    <div class="form-group ${status.error ? 'error' : ''}">
        <label class="control-label col-sm-2">${label}</label>
        <div class="col-sm-3">
            <form:input path="${name}" class="form-control"/>
        </div>

        <div class="col-sm-7">
            <span class="help-inline">${status.errorMessage}</span>
        </div>
    </div>
</spring:bind>