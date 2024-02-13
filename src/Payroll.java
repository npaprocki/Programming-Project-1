import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: Payroll
 * 
 * @author Nate Paprocki
 * @version 1.0 
 * Course: CSE 274 Spring 2024 
 * Written: Feburary 16, 2024
 * 
 * Purpose: This class runs the payroll system that reads employee data
 *          from a file, displays an UI, adds and deletes employee, outputs
 *          payroll information, and saves changes back to a file.
 */

public class Payroll {

	/**
	 * This method reads data from a file, creates the appropriate object, and adds
	 * to arrayList
	 * 
	 * @param fileName name of file to be read
	 * @return ArrayList<Employee> list of employees added
	 */

	public static ArrayList<Employee> readFromFile(String fileName) {

		ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();

		try {

			File wordBankFile = new File(fileName);
			Scanner reader = new Scanner(wordBankFile);

			while (reader.hasNextLine()) {

				int employeeId = Integer.parseInt(reader.nextLine());
				String name = reader.nextLine();
				String type = reader.nextLine();

				if (type.equals("hourly")) {

					Hourly newHourlyEmployee = new Hourly(employeeId, name, type, Double.parseDouble(reader.nextLine()),
							Double.parseDouble(reader.nextLine()));

					listOfEmployees.add(newHourlyEmployee);

				} else {

					if (type.equals("monthly")) {

						Monthly newMonthlyEmployee = new Monthly(employeeId, name, type,
								Double.parseDouble(reader.nextLine()));

						listOfEmployees.add(newMonthlyEmployee);

					}

				}

			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error!\n" + e.getMessage() + "\n\nPlease check name of file");
			System.exit(0);

		}
		return listOfEmployees;

	}

	/**
	 * This method presents the user a menu, accepts a selection, and calls
	 * appropriate method
	 * 
	 * @param employeeDirectory List of employees
	 */

	public static void ui(ArrayList<Employee> employeeDirectory) {

		Scanner input = new Scanner(System.in);

		// menu
		System.out.println("\nPayroll Processing\n");
		System.out.print("1. View Employee Information \n2. Add an Employee"
				+ "\n3. Delete an Employee \n4. Output Payroll Information\n" + "5. Save Changes to File \n6. Exit\n");

		System.out.println("\nMake a Selection (1-6): ");

		int userSelection = 0;

		// makes sure a number is entered
		try {

			userSelection = Integer.parseInt(input.nextLine());

		} catch (NumberFormatException e) {

			System.out.println("\nPlease choose an option 1-6\n");
			ui(employeeDirectory);

		}

		// switch based on selection
		switch (userSelection) {
		case 1:

			viewEmployeeInfo(employeeDirectory);
			ui(employeeDirectory);

			break;

		case 2:

			addEmployee(employeeDirectory, input);
			ui(employeeDirectory);

			break;

		case 3:

			deleteEmployee(employeeDirectory, input);
			ui(employeeDirectory);

			break;

		case 4:

			outputPayroll(employeeDirectory);
			ui(employeeDirectory);

			break;

		case 5:

			saveChanges(employeeDirectory, "employees.txt");
			ui(employeeDirectory);

			break;

		case 6:

			System.exit(0);

			break;

		default:

			System.out.println("\nPlease choose an option 1-6\n");
			ui(employeeDirectory);

			break;

		}

		input.close();
	}

	/**
	 * This method loops through arraylist and calls toString method for each object
	 * 
	 * @param employeeDirectory List of employees
	 */

	public static void viewEmployeeInfo(ArrayList<Employee> employeeDirectory) {

		System.out.print("\nView Employee Information: \n\n");

		for (Employee x : employeeDirectory) {

			System.out.println(x);

		}

	}

	/**
	 * This method creates an Employee based on user import and adds to arrayList
	 * 
	 * @param employeeDirectory List of employees
	 * @param input             Scanner object to collect input
	 */

	public static void addEmployee(ArrayList<Employee> employeeDirectory, Scanner input) {

		System.out.println("\nEnter Employee ID: ");
		int enteredEmployeeId = Integer.parseInt(input.nextLine());

		System.out.println("\nEnter Employee Name: ");
		String enteredEmployeeName = input.nextLine();

		System.out.println("\nEnter Employee Type: ");
		String enteredEmployeeType = (input.nextLine()).toLowerCase();

		// create correct object based on type input
		if (enteredEmployeeType.equals("hourly")) {
			System.out.println("\nEnter Hours Worked: ");
			double enteredHoursWorked = Double.parseDouble(input.nextLine());

			System.out.println("\nEnter Hourly Rate: ");
			double enteredHourlyRate = Double.parseDouble(input.nextLine());

			Hourly newHourlyEmployee = new Hourly(enteredEmployeeId, enteredEmployeeName, enteredEmployeeType,
					enteredHoursWorked, enteredHourlyRate);
			employeeDirectory.add(newHourlyEmployee);

			System.out.print("\n\nThe following employee has been added: " + newHourlyEmployee + "\n");

		} else {
			if (enteredEmployeeType.equals("monthly")) {

				System.out.println("\nEnter Monthly Salary: ");
				double enteredMonthlySalary = Double.parseDouble(input.nextLine());

				Monthly newMonthlyEmployee = new Monthly(enteredEmployeeId, enteredEmployeeName, enteredEmployeeType,
						enteredMonthlySalary);
				employeeDirectory.add(newMonthlyEmployee);

				System.out.print("\n\nThe following employee has been added:\n" + newMonthlyEmployee + "\n");

			} else {
				// if user doesn't enter monthly or hourly
				System.out.println("\nPlease enter a valid employee type (hourly or monthly)");

				addEmployee(employeeDirectory, input);

			}

		}

	}

	/**
	 * This method removes an employee from list by employeeID
	 * 
	 * @param employeeDirectory List of employees
	 * @param input             Scanner object to collect input
	 */

	public static void deleteEmployee(ArrayList<Employee> employeeDirectory, Scanner input) {

		boolean removed = false;
		int removeIndex = 0;

		// gets employee id to be deleted
		System.out.println("\nEnter Employee ID of Employee to Delete: ");
		int enteredEmployeeIdRemove = Integer.parseInt(input.nextLine());

		// loops through array
		for (Employee x : employeeDirectory) {

			// compares each id to entered id
			if (x.getUniqueId() == enteredEmployeeIdRemove) {

				System.out.println("\nThe following employee has been removed:\n" + x.toString() + "\n");

				removeIndex = employeeDirectory.indexOf(x);

				removed = true;

			}
		}

		// if id exist, remove from list
		if (removed) {

			employeeDirectory.remove(removeIndex);

		} else {

			System.out.println("\nNo employee exist with that ID\n");

		}

	}

	/**
	 * This method outputs employee name and how much to be paid
	 * 
	 * @param employeeDirectory
	 */

	public static void outputPayroll(ArrayList<Employee> employeeDirectory) {

		for (Employee selectedEmployee : employeeDirectory) {

			if (selectedEmployee.getType().equals("hourly")) {

				System.out.printf("\n%-15s $%.2f", selectedEmployee.getName(),
						((Hourly) selectedEmployee).getHoursWorked() * ((Hourly) selectedEmployee).getHourlyRate());

			} else {

				System.out.printf("\n%-15s $%.2f", selectedEmployee.getName(),
						((Monthly) selectedEmployee).getMonthlySalary());

			}

		}

		// for formatting
		System.out.println("\n");

	}

	/**
	 * This method rewrites .txt file with current array
	 * 
	 * @param employeeDirectory
	 * @param fileName
	 */

	public static void saveChanges(ArrayList<Employee> employeeDirectory, String fileName) {

		try {

			PrintWriter output = new PrintWriter(fileName);

			for (Employee selectedEmployee : employeeDirectory) {

				output.println(selectedEmployee.getUniqueId());
				output.println(selectedEmployee.getName());
				output.println(selectedEmployee.getType());

				if (selectedEmployee.getType().equals("hourly")) {

					output.println(((Hourly) selectedEmployee).getHoursWorked());
					output.println(((Hourly) selectedEmployee).getHourlyRate());

				} else {

					output.println(((Monthly) selectedEmployee).getMonthlySalary());

				}

			}

			output.flush();
			output.close();

			System.out.println("\nFile saved successfully.");

		} catch (IOException e) {

			System.out.println("Error!\n" + e.getMessage() + "\n\nPlease check FileWriter");
			System.exit(0);

		}

	}

	/**
	 * Main method, calls readFromFile and starts ui
	 * 
	 * @param args Command line argument, not used
	 */

	public static void main(String[] args) {

		ArrayList<Employee> employeeDirectory = readFromFile("employees.txt");
		ui(employeeDirectory);

	}

}
