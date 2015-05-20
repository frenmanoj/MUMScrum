<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Oranization Chart</title>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery.orgchart.css"/>'>
	
</head>

<body>

	<%@ include file="../common/header.jsp"%>
	
  

   <div id="chart_div""></div>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["orgchart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('string', 'Manager');
        data.addColumn('string', 'ToolTip');

        data.addRows([
          [{v:'Name1', f:'Name1<div style="color:red; font-style:italic">The President</div>'}, '', 'The President'],  
          [{v:'Name2', f:'Name2<div style="color:red; font-style:italic">Vice President</div>'}, 'Name1', 'Vice President'],
          [{v:'Name3', f:'Name3<div style="color:red; font-style:italic">HR Manager</div>'}, 'Name2', 'HR Manager'],
          [{v:'Name4', f:'Name4<div style="color:red; font-style:italic">Admin Manager</div>'}, 'Name2', 'Admin Manager'],
          [{v:'Name5', f:'Name5<div style="color:red; font-style:italic">Product Owner</div>'}, 'Name3', 'Product Owner'],
          [{v:'Name6', f:'Name2<div style="color:red; font-style:italic">Scrum Master</div>'}, 'Name5', 'Scrum Master'],
          
          ['Dev1', 'Name6', ''],
          ['Dev2', 'Name6', ''],
          ['Dev3', 'Name6', ''],
          ['Tester1', 'Name6', ''],
          ['Tester2', 'Name6', '']
        ]);

        var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
        chart.draw(data, {allowHtml:true});
      }
   </script>


	
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
		
		
		
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/bootstrap3-dialog/js/bootstrap-dialog.js"/>'></script>
		
	<script type="text/javascript"
		src='<c:url value="/web-resources/js/common.js"/>'></script>
</body>
</html>