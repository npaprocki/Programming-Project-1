/**
 * Class: Monthly
 * 
 * @author Nate Paprocki
 * @version 1.0 
 * Course: CSE 274 Spring 2024 
 * Written: Feburary 16, 2024
 * 
 * Purpose: This class represents an Monthly Employee (inherits from Employee) with an monthly salary.
			It provides methods to retrieve and modify these attributes, as well as a
			method to obtain a formatted string representation of the Monthly Employee.
 */

public class Monthly extends Employee {

	private double monthlySalary;

	/**
	 * This constructor sets the passed values to local variables
	 * 
	 * @param uniqueId      Inherited, Passed Employee Id
	 * @param name          Inherited, Passed Employee name
	 * @param type          Inherited, Passed Employee type
	 * @param monthlySalary Passed Employee monthly salary
	 */

	public Monthly(int uniqueId, String name, String type, double monthlySalary) {
		super(uniqueId, name, type);

		this.monthlySalary = monthlySalary;
	}

	/**
	 * This method returns the value of monthlySalary
	 * 
	 * @return monthlySalary Employee's monthly salary
	 */

	public double getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * This method sets the value of monthlySalary
	 * 
	 * @param monthlySalary Passed monthly salary
	 */

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	/**
	 * This method returns a formatted string of all Employee and Monthly variables
	 * 
	 * return formatted string
	 */

	@Override
	public String toString() {
		return super.toString() + String.format(" salary at $%.2f", getMonthlySalary());
	}

}
