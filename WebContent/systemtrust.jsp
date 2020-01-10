<%@page import="java.sql.ResultSet"%>
<%@page import="databaseconnection.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*;"%>
<!-- End Header -->
<jsp:include page="header.jsp"></jsp:include>
<!-- End Header -->
	
	<script src="js/highcharts.js"></script>
	<script src="js/exporting.js"></script>
	<div class="admissions slideanim" id="chart" style="padding-top:20px;">
		<%
		 	DatabaseConnection db = new DatabaseConnection();
		 	db.dbconnection();
			String leakcount="";
							double totalshares = 0;
							double leakcounts = 0;
							String query2 = "Select count(leaker) as leakcount from leak";
							ResultSet rs2 = db.getResultSet(query2);
							if(rs2.next()) 
							{
								leakcount=rs2.getString("leakcount");
								leakcounts = Double.parseDouble(leakcount);
								//System.out.println(leakcount);
							}
							String totalshare="";
							String query3 = "Select count(receiver) as totalshare from sharefiles";
							ResultSet rs3 = db.getResultSet(query3);
							if(rs3.next()) 
							{
								totalshare=rs3.getString("totalshare");
								totalshares = Double.parseDouble(totalshare);
								//System.out.println(totalshare);
							}
							double leakage=(leakcounts/totalshares)*100;
							int intleakage=(int)leakage;
							int trust=100-intleakage;
							//System.out.println(intleakage);
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
															text : '<h3 style="font-size:30px;font-weight:bold;font-family:Times New Roman">System Trust Worthiness Chart</h3><br> User Trustworthiness using share files & leak files details'
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
															name : 'Files',
															colorByPoint : true,
															data : [ {
																name : 'Share',
																y : <%=trust%>
															}, {
																name : 'Leak',
																y : <%=intleakage%>,
																sliced : true,
																selected : true
															} ]
														} ]
													});
								});
			});
			//]]>
		</script>
		<div id="container"	style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
</div>
<br><br>
<div class="testimonials-news">.
</div>
<jsp:include page="footer.jsp"></jsp:include>