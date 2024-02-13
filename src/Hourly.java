/**
 * Class: Hourly
 * 
 * @author Nate Paprocki
 * @version 1.0 
 * Course: CSE 274 Spring 2024 
 * Written: Feburary 16, 2024
 * 
 * Purpose: This class represents an Hourly Employee (inherits from
 *          Employee) with an Hourly Rate and a Hours Worked. It provides
 *          methods to retrieve and modify these attributes, as well as a method
 *          to obtain a formatted string representation of the Hourly Employee.
 */

public class Hourly extends Employee {

	private double hourlyRate;
	private double hoursWorked;

	/**
	 * This constructor sets the passed values to local variables
	 * 
	 * @param uniqueId    Inherited, Passed Employee Id
	 * @param name        Inherited, Passed Employee name
	 * @param type        Inherited, Passed Employee type
	 * @param hoursWorked Passed Employee hours worked
	 * @param hourlyRate  Passed Employee's Hourly Rate
	 */

	Hourly(int uniqueId, String name, String type, double hoursWorked, double hourlyRate) {
		super(uniqueId, name, type);

		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;

	}

	/**
	 * This method returns the value of hourlyRate
	 * 
	 * @return hourlyRate Employee's hourly rate
	 */

	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * This method sets the value of hourlyRate
	 * 
	 * @param hourlyRate Passeed hourly rate
	 */

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * This method returns the value of hoursWorked
	 * 
	 * @return hoursWorked Employee's hourly rate
	 */

	public double getHoursWorked() {
		return hoursWorked;
	}

	/**
	 * This method sets the value of hoursWorked
	 * 
	 * @param hoursWorked Passed hours worked
	 */

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	/**
	 * This method returns a formatted string of all Employee and Hourly variables
	 * 
	 * return formatted string
	 */

	@Override
	public String toString() {
		return super.toString() + String.format(" worked %.2f hours at $%.2f", getHoursWorked(), getHourlyRate());
	}

}
