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
import edu.mum.mscrum.hrss.model.User;
import edu.mum.mscrum.hrss.service.EmployeeService;
import edu.mum.mscrum.hrss.service.RoleService;
import edu.mum.mscrum.hrss.service.UserService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private UserService userService;

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

		if (employee.getId() != null) {

			Employee dbEmployee = employeeService.getById(employee.getId());

			copyProperties(employee, dbEmployee);

			employeeService.save(dbEmployee);
		} else {

			String roleId = employee.getUser().getRoleId();
			Role role = roleService.getRole(Long.valueOf(roleId));

			employee.getUser().addRole(role);
			employeeService.save(employee);
		}

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

	private void copyProperties(Employee source, Employee destination) {

		destination.setSsn(source.getSsn());
		destination.setFirstName(source.getFirstName());
		destination.setLastName(source.getLastName());
		destination.setEmail(source.getEmail());
		destination.setPhone(source.getPhone());
		destination.setStreet(source.getStreet());
		destination.setCity(source.getCity());
		destination.setState(source.getState());
		destination.setZipcode(source.getZipcode());
		destination.setSalary(source.getSalary());
	}
	@RequestMapping("/{userName}/Details/")
	public String viewEmployeeDetails(@PathVariable String userName,
			Map<String, Object> map) {

		User user = userService.getUser(userName);

		Employee employee = user.getEmployee();

		map.put("employee", employee);

		return "/employee/viewEmployeeDetails";
	}

	@RequestMapping("/{userName}/Details/update")
	public String getEmployeeDetails(@PathVariable String userName,
			Map<String, Object> map) {

		User user = userService.getUser(userName);

		Employee employee = user.getEmployee();

		map.put("employee", employee);

		return "/employee/updateEmployeeDetails";
	}

	@RequestMapping(value = "/{userName}/Details/save", method = RequestMethod.POST)
	public String updateEmployee(@PathVariable String userName,
			@ModelAttribute("employee") Employee employee, BindingResult result) {

		User user = userService.getUser(userName);

		Employee old_employee = user.getEmployee();

		old_employee.setFirstName(employee.getFirstName());
		old_employee.setLastName(employee.getLastName());
		old_employee.setEmail(employee.getEmail());
		old_employee.setStreet(employee.getStreet());
		old_employee.setPhone(employee.getPhone());
		old_employee.setSsn(employee.getSsn());
		old_employee.setCity(employee.getCity());
		old_employee.setState(employee.getState());

		employeeService.save(old_employee);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/employee/" + userName + "/Details/";
	}

}
