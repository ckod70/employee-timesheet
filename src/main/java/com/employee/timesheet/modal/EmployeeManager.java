package com.employee.timesheet.modal;

import java.text.DecimalFormat;

public class EmployeeManager extends SalariedEmployee {

	@Override
	public void logWork(int numberOfDaysWorked) throws Exception {
		super.validateWorkDays(numberOfDaysWorked);
		float vacations = (Float.valueOf(numberOfDaysWorked) / MAX_WORK_DAYS_TO_LOG) * 30;
		setVacations(getVacations() + vacations);
		DecimalFormat df = new DecimalFormat(".00");
		setVacations(Float.valueOf(df.format(getVacations())));
	}

}