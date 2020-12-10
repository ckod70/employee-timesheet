package com.employee.timesheet.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.employee.timesheet.controller.EmployeeTimesheetManagementController;
import com.employee.timesheet.modal.Employee;
import com.employee.timesheet.modal.HourlyEmployee;
import com.employee.timesheet.service.EmployeeTimesheetManagementService;

public class EmployeeTimesheetManagementControllerTest {	
	
	private EmployeeTimesheetManagementService employeeTimesheetManagementService;
	
	@InjectMocks
	@Resource
	private EmployeeTimesheetManagementController employeeTimesheetManagementController;
	
	@BeforeEach
	public void setup() throws Exception {
		employeeTimesheetManagementService = Mockito.mock(EmployeeTimesheetManagementService.class);
		MockitoAnnotations.initMocks(this);
		employeeTimesheetManagementController = new EmployeeTimesheetManagementController();
		MockitoAnnotations.initMocks(this);
		List<Employee> employees = new ArrayList<>();
		Employee emp = new HourlyEmployee();
		emp.setUserName("Tom");
		emp.setUserId(12);
		employees.add(emp);
		Mockito.when(employeeTimesheetManagementService.getEmployees()).thenReturn(employees);
		Mockito.when(employeeTimesheetManagementService.logWork(Mockito.anyInt(), Mockito.anyInt())).thenReturn(employees);
		Mockito.when(employeeTimesheetManagementService.takeVacation(Mockito.anyInt(), Mockito.anyFloat())).thenReturn(employees);
	}

	@Test
	public void test_GetAllEmployees() {
		ResponseEntity<List<Employee>> employees = employeeTimesheetManagementController.getEmployees();
		assertEquals(1, employees.getBody().size());
		assertEquals(12, employees.getBody().get(0).getUserId());
		assertEquals("Tom", employees.getBody().get(0).getUserName());
	}
	
	@Test
	public void test_logWork() throws Exception {
		ResponseEntity<List<Employee>> employees = employeeTimesheetManagementController.logWork(12, 260);
		assertEquals(1, employees.getBody().size());
		assertEquals(12, employees.getBody().get(0).getUserId());
		assertEquals("Tom", employees.getBody().get(0).getUserName());
	}
	
	@Test
	public void test_takeVacation () throws Exception {
		ResponseEntity<List<Employee>> employees = employeeTimesheetManagementController.takeVacation(12, 10.0f);
		assertEquals(1, employees.getBody().size());
		assertEquals(12, employees.getBody().get(0).getUserId());
		assertEquals("Tom", employees.getBody().get(0).getUserName());
	}
}
