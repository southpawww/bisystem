window.onload = function() {
var dps = [[], [], [], []];
var chartCounty = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	title: {
		text: "Fixed Voice Call Volume - UK"
	},
	axisY: {
		includeZero: false,
		title: "Call Duration (in billion minutes)"
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
		name: "Local Calls",
		showInLegend: true,
		xValueType: "dateTime",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0 billion minutes",
		dataPoints: dps[0]
	},{
		type: "stackedBar",
		name: "Call to Mobile",
		showInLegend: true,
		xValueType: "dateTime",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0 billion minutes",
		dataPoints: dps[1]
	},{
		type: "stackedBar",
		name: "International Call",
		showInLegend: true,
		xValueType: "dateTime",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0 billion minutes",
		dataPoints: dps[2]
	},{
		type: "stackedBar",
		name: "Other Calls",
		showInLegend: true,
		xValueType: "dateTime",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0 billion minutes",
		dataPoints: dps[3]
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
 

 
chartCounty.render();
}
