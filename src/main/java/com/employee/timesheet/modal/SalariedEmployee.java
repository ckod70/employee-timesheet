package com.employee.timesheet.modal;

import java.text.DecimalFormat;

public class SalariedEmployee extends Employee {

	@Override
	public void logWork(int numberOfDaysWorked) throws Exception {
		super.validateWorkDays(numberOfDaysWorked);
		setVacationDays(numberOfDaysWorked);
	}

	private void setVacationDays(int numberOfDaysWorked) {
		float vacations = (Float.valueOf(numberOfDaysWorked) / MAX_WORK_DAYS_TO_LOG) * 15;
		setVacations(getVacations() + vacations);
		DecimalFormat df = new DecimalFormat(".00");
		setVacations(Float.valueOf(df.format(getVacations())));
	}

}