package com.employee.timesheet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.timesheet.modal.Employee;
import com.employee.timesheet.service.EmployeeTimesheetManagementService;
import com.employee.timesheet.service.EmployeeTimsheetManagementServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeTimsheetManagementServiceImpl.class)
public class EmployeeTimesheetManagementServiceTest {

	@Autowired
	private EmployeeTimesheetManagementService employeeTimesheetManagementService;

	@BeforeEach
	public void setup() {
	}

	@Test
	public void test_getAllEmployees() {
		List<Employee> employees = employeeTimesheetManagementService.getEmployees();
		assertEquals(10, employees.size());
		assertEquals("Right", employees.get(0).getUserName());
	}

	@Test
	public void test_LogWork() throws Exception {
		List<Employee> employees = employeeTimesheetManagementService.logWork(1, 200);
		assertEquals(10, employees.size());
		assertEquals(200, employees.get(0).getWorkDays());
	}

	@Test
	public void test_TakeVacation() throws Exception {
		employeeTimesheetManagementService.logWork(2, 260);
		List<Employee> employees = employeeTimesheetManagementService.takeVacation(2, 5);
		assertEquals(10, employees.size());
		assertEquals(5.0f, employees.get(1).getVacations());
	}
}
