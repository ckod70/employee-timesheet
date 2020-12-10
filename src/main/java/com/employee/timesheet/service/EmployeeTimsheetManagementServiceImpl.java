package com.employee.timesheet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.employee.timesheet.enums.EmployeeType;
import com.employee.timesheet.exceptions.UserNotFoundException;
import com.employee.timesheet.modal.HourlyEmployee;
import com.employee.timesheet.modal.SalariedEmployee;
import com.employee.timesheet.modal.Employee;
import com.employee.timesheet.modal.EmployeeManager;

@Service
public class EmployeeTimsheetManagementServiceImpl implements EmployeeTimesheetManagementService {

	private static List<Employee> employees;

	@PostConstruct
	private void createUsers() {
		employees = new ArrayList<>();
		employees.add(getUser(1, "Right", 25, "Junior Engineer", EmployeeType.HOURLY));
		employees.add(getUser(2, "Laz", 30, "Junior Engineer", EmployeeType.HOURLY));
		employees.add(getUser(3, "Chris", 25, "Software Engineer", EmployeeType.HOURLY));
		employees.add(getUser(4, "Tim", 25, "Software Engineer", EmployeeType.HOURLY));
		employees.add(getUser(5, "Jos", 29, "Software Engineer I", EmployeeType.SALARIED));
		employees.add(getUser(6, "Iva", 25, "Software Engineer II", EmployeeType.SALARIED));
		employees.add(getUser(7, "Adam", 25, "Software Engineer I", EmployeeType.SALARIED));
		employees.add(getUser(8, "Losy", 45, "Manager", EmployeeType.MANAGER));
		employees.add(getUser(9, "Rose", 42, "Manager", EmployeeType.MANAGER));
		employees.add(getUser(10, "Michal", 40, "Manager", EmployeeType.MANAGER));
	}

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public List<Employee> logWork(int userId, int days) throws Exception {
		Optional<Employee> userOptional = employees.stream().filter(user -> user.getUserId() == userId).findFirst();
		if (userOptional.isPresent()) {
			userOptional.get().logWork(days);
		} else {
			throw new UserNotFoundException();
		}
		return employees;
	}

	@Override
	public List<Employee> takeVacation(int userId, float days) throws Exception {
		Optional<Employee> userOptional = employees.stream().filter(user -> user.getUserId() == userId).findFirst();
		if (userOptional.isPresent()) {
			userOptional.get().takeVacation(days);
		} else {
			throw new UserNotFoundException();
		}
		return employees;
	}

	private Employee getUser(int userId, String userName, int age, String designation, EmployeeType type) {
		Employee user = null;
		switch (type) {
		case HOURLY:
			user = new HourlyEmployee();
			user.setType(EmployeeType.HOURLY);
			break;
		case SALARIED:
			user = new SalariedEmployee();
			user.setType(EmployeeType.SALARIED);
			break;
		case MANAGER:
			user = new EmployeeManager();
			user.setType(EmployeeType.MANAGER);
			break;
		}
		user.setUserId(userId);
		user.setUserName(userName);
		user.setAge(age);
		user.setDesignation(designation);
		return user;
	}

}
