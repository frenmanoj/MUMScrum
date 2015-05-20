package edu.mum.mscrum.hrss.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.hrss.model.Role;
import edu.mum.mscrum.hrss.service.EmployeeService;
import edu.mum.mscrum.hrss.service.RoleService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = { "/", "/listEmployees" })
	public String listEmployees(Map<String, Object> map) {

		map.put("employee", new Employee());
		map.put("employeeList", employeeService.listAll());
		map.put("roles", roleService.getRoles());

		return "/employee/listEmployees";
	}

	@RequestMapping("/get/{employeeId}")
	public String getEmployee(@PathVariable Long employeeId,
			Map<String, Object> map) {

		Employee employee = employeeService.getById(employeeId);

		map.put("employee", employee);

		return "/employee/employeeForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			BindingResult result) {

		System.out.println(employee.getUser().getUsername());
		System.out.println("Employee Id: " + employee.getId());
		System.out.println("User Id: " + employee.getUser().getId());

		String roleId = employee.getUser().getRoleId();

		Role role = roleService.getRole(Long.valueOf(roleId));

		employee.getUser().getRoles().add(role);

		employeeService.save(employee);

		System.out.println(":::: AFTER :::");
		System.out.println(employee.getUser().getUsername());
		System.out.println("Employee Id: " + employee.getId());
		System.out.println("User Id: " + employee.getUser().getId());

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listEmployees";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long id) {

		employeeService.deleteById(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listEmployees";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/employee/listEmployees";
	}

}
