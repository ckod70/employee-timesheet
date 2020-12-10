package com.employee.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.timesheet.modal.Employee;
import com.employee.timesheet.service.EmployeeTimesheetManagementService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class EmployeeTimesheetManagementController {

	@Autowired
	private EmployeeTimesheetManagementService employeeTimesheetManagementService;

	@ApiOperation(value = "getEmployees", notes = "get employees list", nickname = "getEmployees")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Employee.class, responseContainer = "List") })
	@GetMapping(value = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeTimesheetManagementService.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, null, HttpStatus.OK);
	}

	@ApiOperation(value = "logWork", notes = "log work days", nickname = "logWork")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 200, message = "Successful logged the work days", response = Employee.class, responseContainer = "List") })
	@PostMapping(value = "/work", produces = "application/json")
	public ResponseEntity<List<Employee>> logWork(
			@ApiParam(value = "id", required = true) @RequestParam("id") int employeeId,
			@ApiParam(value = "days", required = true) @RequestParam("days") int days) throws Exception {
		List<Employee> employees = employeeTimesheetManagementService.logWork(employeeId, days);
		return new ResponseEntity<List<Employee>>(employees, null, HttpStatus.OK);
	}

	@ApiOperation(value = "takeVacation", notes = "Apply for vacations", nickname = "takeVacation")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
			@ApiResponse(code = 200, message = "Successful applied for the vacations", response = Employee.class, responseContainer = "List") })
	@PostMapping(value = "/vacation", produces = "application/json")
	public ResponseEntity<List<Employee>> takeVacation(
			@ApiParam(value = "id", required = true) @RequestParam("id") int employeeId,
			@ApiParam(value = "days", required = true) @RequestParam("days") float days) throws Exception {
		List<Employee> employees = employeeTimesheetManagementService.takeVacation(employeeId, days);
		return new ResponseEntity<List<Employee>>(employees, null, HttpStatus.OK);
	}
}
