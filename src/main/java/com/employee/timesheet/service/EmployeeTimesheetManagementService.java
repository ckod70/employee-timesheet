package com.employee.timesheet.service;

import java.util.List;

import com.employee.timesheet.modal.Employee;

public interface EmployeeTimesheetManagementService {
	List<Employee> getEmployees();
	List<Employee> logWork(int userId, int days) throws Exception;
	List<Employee> takeVacation(int userId, float days) throws Exception;
}
