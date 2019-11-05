<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.challenge.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.challenge.form.label.description" path="description"/>
	<acme:form-moment code="authenticated.challenge.form.label.deadline" path="deadline"/>
	<acme:form-integer  code="authenticated.challenge.form.label.goalGold" path="goalGold"/>
	<acme:form-textarea code="authenticated.challenge.form.label.goldDescription" path="goldDescription"/>	
	<acme:form-integer code="authenticated.challenge.form.label.goalSilver" path="goalSilver"/>
	<acme:form-textarea code="authenticated.challenge.form.label.silverDescription" path="silverDescription"/>	
	<acme:form-integer  code="authenticated.challenge.form.label.goalBronze" path="goalBronze"/>	
	<acme:form-textarea code="authenticated.challenge.form.label.bronzeDescription" path="bronzeDescription"/>	

	
	
	<acme:form-return code="authenticated.challenge.form.label.button.return"/>
</acme:form>