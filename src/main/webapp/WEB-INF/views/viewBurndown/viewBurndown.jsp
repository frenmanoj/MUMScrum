<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE Html>
<html lang="en">
<head>
<title>View Burndown Chart</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript">
	Array.prototype.insert = function(index, item) {
		this.splice(index, 0, item);
	};
</script>

</head>

<body>

	<%@ include file="../common/header.jsp"%>
	<%@ include file="../common/footer.jsp"%>
	<input id="sprintName" type="hidden" value="${sprint.title}">
	
</body>

<style type="text/css">
#container, #sliders {
	min-width: 310px;
	max-width: 800px;
	margin: 0 auto;
}

#container {
	height: 400px;
}
</style>


<div id="container"></div>
<div id="sliders">
	<table>
		<tr>
			<td>Alpha Angle</td>
			<td><input id="R0" type="range" min="0" max="45" value="15" />
				<span id="R0-value" class="value"></span></td>
		</tr>
		<tr>
			<td>Beta Angle</td>
			<td><input id="R1" type="range" min="0" max="45" value="15" />
				<span id="R1-value" class="value"></span></td>
		</tr>
	</table>
</div>

<script type="text/javascript">
	$(function() {

		//read data from JSON

		// Set up the chart
		var chartOptions = {
			chart : {
				renderTo : 'container',
				type : 'column',
				margin : 75,
				options3d : {
					enabled : true,
					alpha : 0,
					beta : 0,
					depth : 50,
					viewDistance : 25
				}
			},

			credits : {
				enabled : false
			},

			plotOptions : {
				column : {
					depth : 10
				}
			},

			yAxis : {
				
				labels : {
					format : '{value} hrs'
				},

				tickInterval : 5,

				title : {
					enabled : true,
					text : 'Work Remaining',
					style : {
						fontWeight : 'normal'
					}
				}
			},

			xAxis : {
				max : 7,
				labels : {
					format : 'Day  {value}'
				},
				endOnTick : true,
				minTickInterval : 1,
				tickInterval : 1

			},
			title : {
				text : 'Burndown Chart for ' + $("#sprintName").val()
			},

			series : [ {
				name : 'Remaining Effort',
				data : []
			}, {
				type : 'spline',
				name : 'Planned Effort',
				data : [],
				marker : {
					lineWidth : 2,
					lineColor : Highcharts.getOptions().colors[3],
					fillColor : 'white'
				}
			} ]
		};

		$.get("getData", function(results) {
			var counter = 0;
			$.each(results, function(key, value) {

				chartOptions.series[0].data.insert(0, parseFloat(value));
				chartOptions.series[1].data.insert(0, parseFloat(key));

				counter = key;
			});

			
			chart = new Highcharts.Chart(chartOptions);
			chart.yAxis[0].update({ max: counter }); 

			showValues();
		});

		function showValues() {
			$('#R0-value').html(chart.options.chart.options3d.alpha);
			$('#R1-value').html(chart.options.chart.options3d.beta);

		}

		// Activate the sliders
		$('#R0').on('change', function() {
			chart.options.chart.options3d.alpha = this.value;
			showValues();
			chart.redraw(false);
		});
		$('#R1').on('change', function() {
			chart.options.chart.options3d.beta = this.value;
			showValues();
			chart.redraw(false);
		});

	});

	//change Title
</script>

<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js">
	
</script>
<script src="http://code.highcharts.com/highcharts-3d.js"></script>



</html>