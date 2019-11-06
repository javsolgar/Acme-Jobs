<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	
	<h2><acme:message code="administrator.dashboard.form.title.application-statuses"/></h2>
	<div><canvas id="canvas"></canvas></div>
	<!-- Puede faltar un paréntesis -->
	<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels	:	[
					"ANNOUNCEMENT", "INVESTORS RECORD", "COMPANY RECORDS"
				],
				datasets	:	[ 
					{
						data : [
							<jstl:out value ="${totalAnnouncment}"/>,
							<jstl:out value ="${totalInvestorsRecord}"/>,
							<jstl:out value ="${totalCompanyRecords}"/>
							
						]
					
				}
					]
		
		
	};
	
	var options =	{
			scales	:	{
				yAxes	:	[
					{
						ticks	:	{
							suggestedMin	:	0.0,
							suggestedMax	:	20.0
						}
					}
				]
			},
			legend	:	{
				display : false
			}
	};
	
	var canvas, context;
	
	canvas = document.getElementById("canvas");
	context = canvas.getContext("2d");
	mew Chart(context, {
		type	:	"bar",
		data	:	data,
		options	:	options
	});
});
	
	
	</script>
	
	<acme:form-return code="administrator.configuration.form.label.button.return"/>
</acme:form>