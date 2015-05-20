package edu.mum.mscrum.hrss.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.hrss.service.EmployeeService;
import edu.mum.mscrum.hrss.service.OrganizationChartService;
import edu.mum.mscrum.model.Burndown;
import edu.mum.mscrum.model.Sprint;

@Controller
@RequestMapping("/organizationChart")
public class OrganizationChartController {

	@Autowired
	private OrganizationChartService organizationChartService;
	
	
	

	@RequestMapping(value = { "/", "/viewOrganizationChart" })
	public String listEmployees(Map<String, Object> map) {

		
		return "/organizationChart/vieworganizationChart";
	}
	
	@RequestMapping("/organizationChart/getData")
	public @ResponseBody Map<Integer, Integer> getOranizationChartData() {
		
		Map<Integer, Integer> chartData = new LinkedHashMap<Integer, Integer>();
			
			chartData.put(1, 1);
		    return chartData;
	}
	
}
