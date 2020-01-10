<%@page import="java.sql.ResultSet"%>
<%@page import="databaseconnection.DatabaseConnection"%>
<%@page import="java.sql.*;"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="//code.jquery.com/jquery-1.9.1.js"></script>
<body>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<!-- Content-Starts-Here -->
	<div class="content">
			<!-- chart-Starts-Here -->
			<div class="admissions slideanim" id="chart">
				<h3>Chart</h3>
				<%
			String reqfrom = request.getParameter("trustuser");
		 	DatabaseConnection db = new DatabaseConnection();
		 	db.dbconnection();
			String leakcount="";
							double totalshares = 0;
							double leakcounts = 0;
							String query2 = "Select count(leaker) as leakcount from leak where leaker='"+reqfrom+ "'";
							ResultSet rs2 = db.getResultSet(query2);
							if(rs2.next()) 
							{
								leakcount=rs2.getString("leakcount");
								leakcounts = Double.parseDouble(leakcount);
								//System.out.println(leakcount);
							}
							String totalshare="";
							String query3 = "Select count(receiver) as totalshare from sharefiles where receiver='"+reqfrom+ "'";
							ResultSet rs3 = db.getResultSet(query3);
							if(rs3.next()) 
							{
								totalshare=rs3.getString("totalshare");
								totalshares = Double.parseDouble(totalshare);
								//System.out.println(totalshare);
							}
							double leakage=(leakcounts/totalshares)*100;
		%>
	<script type='text/javascript'>
	//<![CDATA[

	$(function() {

		$(document)
				.ready(
						function() {

							// Build the chart
							$('#container')
									.highcharts(
											{
												chart : {
													plotBackgroundColor : null,
													plotBorderWidth : null,
													plotShadow : false,
													type : 'pie'
												},
												title : {
													text : 'College Rating through Review Analysis'
												},
												tooltip : {
													pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
												},
												plotOptions : {
													pie : {
														allowPointSelect : true,
														cursor : 'pointer',
														dataLabels : {
															enabled : false
														},
														showInLegend : true
													}
												},
												series : [ {
													name : 'Rate',
													colorByPoint : true,
													data : [ {
														name : 'Positive',
														y : 50,
													}, {
														name : 'Negative',
														y : 20,
														sliced : true,
														selected : true
													}, {
														name : 'Neutral',
														y : 30
					} ]
																} ]
															});
										});
					});
					//]]>
				</script>
			<div id="container"
				style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
			</div>
			<!-- //chart-Ends-Here -->
</body>
<!-- Body-Ends-Here -->
</html>