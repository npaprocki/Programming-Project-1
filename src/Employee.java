/**
 * Class: Employee
 * 
 * @author Nate Paprocki
 * @version 1.0 
 * Course: CSE 274 Spring 2024 
 * Written: Feburary 16, 2024
 * 
 * Purpose: This class represents an Employee with a unique ID, name,
 *          and type. It provides methods to retrieve and modify these
 *          attributes, as well as a method to obtain a formatted string
 *          representation of the Employee.
 */

public class Employee {

	private int uniqueId;
	private String name;
	private String type;

	/**
	 * This constructor sets the passed values to local variables
	 * 
	 * @param uniqueId Passed employee ID
	 * @param name     Passed employee name
	 * @param type     Passed employee type
	 */

	Employee(int uniqueId, String name, String type) {

		this.uniqueId = uniqueId;
		this.name = name;
		this.type = type;

	}

	/**
	 * This method returns the value of uniqueId
	 * 
	 * @return uniqueId Employee Id
	 */

	public int getUniqueId() {
		return uniqueId;
	}

	/**
	 * This method sets the value of uniqueId
	 * 
	 * @param uniqueId Passed employee ID
	 */

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * This method returns value of name
	 * 
	 * @return name Employee name
	 */

	public String getName() {
		return name;
	}

	/**
	 * This method sets the value of name
	 * 
	 * @param name Passed employee name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns value of type
	 * 
	 * @return type Employee type
	 */

	public String getType() {
		return type;
	}

	/**
	 * This method sets the value of type
	 * 
	 * @param type Passed employee type
	 */

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method returns a formatted string of all Employee variables
	 * 
	 * return formatted string
	 */

	@Override
	public String toString() {

		return String.format("%-3s %s %-7s", getUniqueId(), getName(), getType());

	}

}
