package com.employee.timesheet.modal;

public interface IEmployee {
	public static final int MAX_WORK_DAYS_TO_LOG = 260;
	public static final int MIN_WORK_DAYS_TO_LOG = 1;
	
	public abstract void logWork(int days) throws Exception;
	public void takeVacation(float days) throws RuntimeException;
	public void validateWorkDays(int numberOfDaysWorked) throws RuntimeException;
}
