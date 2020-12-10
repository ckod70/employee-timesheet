import { EmployeeType } from './employee.enum';
export class Employee {
	userId: number;
	userName: string;
	age: number;
	designation: string;
	type: EmployeeType;
	vacations: number;
	workDays: number;
}