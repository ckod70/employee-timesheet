package com.employee.timesheet.modal;

import java.text.DecimalFormat;

import com.employee.timesheet.enums.EmployeeType;
import com.employee.timesheet.exceptions.ValidationFailedException;

public abstract class Employee implements IEmployee{

	private int userId;
	private String userName;
	private int age;
	private String designation;
	private float vacations;
	private int workDays;
	private EmployeeType type;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getVacations() {
		return vacations;
	}

	public void setVacations(float vacations) {
		this.vacations = vacations;
	}

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public abstract void logWork(int days) throws Exception;

	@Override
	public void takeVacation(float days) throws RuntimeException {
		if (days > this.vacations) {
			throw new ValidationFailedException("Vacations are not enough to avail.");
		}
		float vacations = this.vacations - days;
		setVacations(vacations);
		DecimalFormat df = new DecimalFormat(".00");
		setVacations(Float.valueOf(df.format(getVacations())));
	}

	@Override
	public void validateWorkDays(int numberOfDaysWorked) throws RuntimeException {
		this.workDays += numberOfDaysWorked;
		if (this.workDays < MIN_WORK_DAYS_TO_LOG || this.workDays > MAX_WORK_DAYS_TO_LOG) {
			this.workDays -= numberOfDaysWorked;
			throw new ValidationFailedException("Work days are not valid.");
		}
	}
}
