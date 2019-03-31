
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/test_page.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>
<div class="grid-container">
  
   
  <header class="header">
   <div class="topnav">
   <a href="#"  style="width:18px;" class="active">""</a>
  <a href="${pageContext.request.contextPath}/homePage">Dashboard</a>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="${pageContext.request.contextPath}/admin/usermanagement">User Management</a>
</sec:authorize>
  <a href="javascript:document.getElementById('logout').submit()">Log out</a>

</div>
  
  </header>

  <aside class="sidenav">
     <div id="menuwrapper">
        <ul id="sidemenu">
            <li><a href="#"><i class="fa fa-bars" style="font-size:36px;"></i></a>
             <ul>
                    <li> Settings</li>
            </ul>
            
            <li>
                <ul>
                    <li> Container 1 </li>
                </ul>
            </li>
            
           
    	</ul>
</div>
  </aside>

  <main class="main">
    <div class="main-header">
      <div class="main-header__heading">Hello
      ${username}</div>
      <div class="main-header__updates">Recent Items</div>
    </div>

    <div class="main-overview">
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
    </div>

    <div class="main-cards">
      <div class="card">
      <div id="chartContainer" style="height: 370px; width: 100%;"></div>
	 <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
      </div>
      <div class="card">Chart #2
      ${datetime}</div>

      <div class="card">
       <div id="chartContainer2" style="height: 370px; width: 100%;"></div>
       <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
      
      </div>
    </div>
  </main>

  <footer class="footer">
    <div class="footer__copyright" style="float:left">&copy; 2019</div>
    <div class="footer__signature">Made by me...</div>
  </footer>
</div>
<c:url value="/logout" var="logoutUrl" />
 <form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
 <!-- <h3>${_csrf.parameterName}</h3>
 <h3>${_csrf.token}</h3>



 <form:form name="login" modelAttribute="login" action="loginProcess" method="post">
                <table>
                    <tr>
                     
                        <td align="left">
                            <form:button id="login" name="login">Login</form:button>
                        </td>
                    </tr>
                   
                </table>
            </form:form>
-->

 </body>
 <script type="text/javascript">
window.onload = function() {
 
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: true,
	animationEnabled: true,
	title: {
		text: "Monthly Sales"
	},
	data: [{
		type: "pie",
		showInLegend: "true",
		legendText: "{label}",
		yValueFormatString: "#,###\" \"",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}",
		dataPoints: dps[0]
	}]
});
 
var yValue;
var label;
 
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		label = "${dataPoint.label}";
		dps[parseInt("${loop.index}")].push({
			label : label,
			y : yValue,
		});		
	</c:forEach>	
</c:forEach> 
 
chart.render();





var dps = [[], [], [], [],[]];
var chart = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "Sales by county"
	},
	axisY: {
		includeZero: false,
		title: "Sold products"	
	},
	 
	legend:{
		cursor: "pointer",
		itemclick: toggleDataSeries
	},
	toolTip: {
		shared: true
	},
	
	data: [{
		type: "stackedBar",
		name: "Osobný účet - Premium",
		showInLegend: true,
	
		dataPoints: dps[0]
	},{
		type: "stackedBar",
		name: "Osobný účet - Junior",
		showInLegend: true,
		
		dataPoints: dps[1]
	},{
		type: "stackedBar",
		name: "Vkladná knižka",
		showInLegend: true,
		
		dataPoints: dps[2]
	},{
		type: "stackedBar",
		name: "Hypotéka na bývanie",
		showInLegend: true,
		
		dataPoints: dps[3]
	},{
		type: "stackedBar",
		name: "Úver na auto",
		showInLegend: true,
		
		dataPoints: dps[4]
	}]
});
function toggleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else{
		e.dataSeries.visible = true;
	}
	chart.render();
}
 
var xValue;
var yValue;
var label;
<c:forEach items="${dataPointsListCounty}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
	label = "${dataPoint.label}";	
	xValue = parseInt("${dataPoint.x}");
		yValue = parseFloat("${dataPoint.y}");
		dps[parseInt("${loop.index}")].push({
			label: label,
			x : xValue,
			y : yValue
		});		
	</c:forEach>	
</c:forEach> 

}






</script>

 </html>
 