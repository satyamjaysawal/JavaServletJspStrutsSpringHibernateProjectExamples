package example;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagementWithFile {
	private static final String FILE_PATH = "C:\\Users\\sjaysawa\\Desktop\\Filestream\\sample.txt";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbcfiledb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Satyam@#567";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Employee> employees = loadEmployeesFromFile(); // Load employees from file

		int choice;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Add Employee");
			System.out.println("2. Display Employees");
			System.out.println("3. Sort Employees by EmpNo (In File)");
			System.out.println("4. Sort Employees by EmpName Asc/Desc(In File)");
			System.out.println("5. Sort Employees by Salary Asc/Desc(In File)");
			System.out.println("6. Sort Employees by Salary Asc/Desc(In Database)");
			System.out.println("7. Deleting an Employee from both Database and File:");
			System.out.println("8. Share Data if Either Database or File is Empty");
			System.out.println("9. Filter Employees by Name");
			System.out.println("10. Synchronize Database and File Data");
			System.out.println("11. Check if an employee with a given EmpNo exists");
			System.out.println("0. Exit");

			System.out.print("Enter Your Choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				// Add Employee
				System.out.print("Enter the number of employees to add: ");
				int numEmployees = scanner.nextInt();
				scanner.nextLine();

				for (int i = 0; i < numEmployees; i++) {
					System.out.print("Enter EmpNo: ");
					int empNo = scanner.nextInt();
					scanner.nextLine();

					// Check if empNo is already taken
					boolean empNoTaken = employees.stream().anyMatch(emp -> emp.getEmpNo() == empNo);
					if (empNoTaken) {
						System.out.println("Employee with EmpNo " + empNo + " already exists. Skipping.");
						continue;
					}

					System.out.print("Enter EmpName: ");
					String empName = scanner.nextLine();
					System.out.print("Enter Salary: ");
					double salary = scanner.nextDouble();

					try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
							PreparedStatement pstmt = con.prepareStatement(
									"INSERT INTO employees (empNo, empName, salary) VALUES (?, ?, ?)")) {
						pstmt.setInt(1, empNo);
						pstmt.setString(2, empName);
						pstmt.setDouble(3, salary);
						pstmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// Save employee data to file
					employees.add(new Employee(empNo, empName, salary));
					saveEmployeesToFile(employees);
				}
				System.out.println("Employee data added to database and saved to file: " + FILE_PATH);
				break;

			case 2:
				// Display Employees from Database
				System.out.println("\nEmployees from database:");
				try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
						Statement stmt = con.createStatement()) {
					ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
					while (rs.next()) {
						int fetchedEmpNo = rs.getInt("empNo");
						String fetchedEmpName = rs.getString("empName");
						double fetchedSalary = rs.getDouble("salary");
						System.out.println("EmpNo: " + fetchedEmpNo + " | EmpName: " + fetchedEmpName + " | Salary: "
								+ fetchedSalary);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// Display Employees from File
				System.out.println("\nEmployees from file:");
				for (Employee emp : employees) {
					System.out.println(emp);
				}
				break;

			case 3:
				// Sort Employees by EmpNo (In File Only)
				Collections.sort(employees, new EmployeeComparatorByEmpNo());
				System.out.println("Employees sorted by EmpNo :");
				for (Employee emp : employees) {
					System.out.println(emp);
				}

				// Ask user if they want to save the sorted data to file
				System.out.print("!!! Do you want to save the sorted data to file? (Y/N): ");
				String saveChoice = scanner.nextLine();
				if (saveChoice.equalsIgnoreCase("Y")) {
					// Update file
					saveEmployeesToFile(employees);
					System.out.println("Sorted data saved to file.");
				}
				break;

			case 4:
				// Ask user for sorting order
				System.out.print(
						"Sort Employees by EmpName: \n1. Ascending Order\n2. Descending Order\nEnter your choice: ");
				int sortChoiceEmpName = scanner.nextInt();
				scanner.nextLine();

				// Sort Employees by EmpName
				if (sortChoiceEmpName == 1) {
					Collections.sort(employees, new EmployeeComparatorByEmpName());
				} else if (sortChoiceEmpName == 2) {
					Collections.sort(employees, Collections.reverseOrder(new EmployeeComparatorByEmpName()));
				} else {
					System.out.println("Invalid sorting choice. Returning to the menu.");
					break;
				}

				System.out.println("Employees sorted by EmpName:");
				for (Employee emp : employees) {
					System.out.println(emp);
				}

				// Ask user if they want to save the sorted data to file
				System.out.print("!!! Do you want to save the sorted data to file? (Y/N): ");
				String saveChoiceEmpName = scanner.nextLine();
				if (saveChoiceEmpName.equalsIgnoreCase("Y")) {
					// Update file
					saveEmployeesToFile(employees);
					System.out.println("Sorted data saved to file.");
				}
				break;

			case 5:
				// Ask the user for sorting order
				System.out.println("Sort Employees by Salary:");
				System.out.println("1. Ascending Order");
				System.out.println("2. Descending Order");
				System.out.print("Enter your choice: ");
				int sortChoice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline

				// Sort Employees by Salary
				if (sortChoice == 1) {
					Collections.sort(employees, new EmployeeComparatorBySalaryAsc());
					System.out.println("Employees sorted by Salary (Ascending):");
				} else if (sortChoice == 2) {
					Collections.sort(employees, new EmployeeComparatorBySalaryDesc());
					System.out.println("Employees sorted by Salary (Descending):");
				} else {
					System.out.println("Invalid choice.");
					break;
				}

				// Display sorted employees on the screen
				for (Employee emp : employees) {
					System.out.println(emp);
				}

				// Ask the user if they want to save the sorted data to the file
				System.out.print("Do you want to save the sorted data to file? (Y/N): ");
				String saveChoiceSalary = scanner.nextLine();
				if (saveChoiceSalary.equalsIgnoreCase("Y")) {
					// Update file
					saveEmployeesToFile(employees);
					System.out.println("Sorted data saved to file.");
				}
				break;

			case 6:
				// Ask the user for sorting order
				System.out.println("Sort Employees by Salary in Database:");
				System.out.println("1. Ascending Order");
				System.out.println("2. Descending Order");
				System.out.print("Enter your choice: ");
				int sortChoiceSalary = scanner.nextInt();
				scanner.nextLine(); // Consume the newline

				// Retrieve employee data from the database
				List<Employee> employeesFromDatabase = new ArrayList<>();
				try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
						Statement stmt = con.createStatement()) {
					ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
					while (rs.next()) {
						int empNo = rs.getInt("empNo");
						String empName = rs.getString("empName");
						double salary = rs.getDouble("salary");
						employeesFromDatabase.add(new Employee(empNo, empName, salary));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// Sort Employees by Salary
				if (sortChoiceSalary == 1) {
					Collections.sort(employeesFromDatabase, Comparator.comparing(Employee::getSalary));
					System.out.println("Employees sorted by Salary in Ascending Order:");
				} else if (sortChoiceSalary == 2) {
					Collections.sort(employeesFromDatabase, Comparator.comparing(Employee::getSalary).reversed());
					System.out.println("Employees sorted by Salary in Descending Order:");
				} else {
					System.out.println("Invalid choice.");
					break;
				}

				// Display sorted employees on the screen
				for (Employee emp : employeesFromDatabase) {
					System.out.println(emp);
				}
				break;

			case 7:
				// Delete Employee
				System.out.print("Enter EmpNo of the employee to delete: ");
				int deleteEmpNo = scanner.nextInt();
				scanner.nextLine();

				boolean employeeFound = false;
				Employee employeeToDelete = null;

				for (Employee emp : employees) {
					if (emp.getEmpNo() == deleteEmpNo) {
						employeeToDelete = emp;
						employeeFound = true;
						break;
					}
				}

				if (employeeFound) {
					try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
							PreparedStatement pstmt = con.prepareStatement("DELETE FROM employees WHERE empNo = ?")) {
						pstmt.setInt(1, deleteEmpNo);
						pstmt.executeUpdate();
						System.out.println("Employee deleted from database.");
					} catch (SQLException e) {
						e.printStackTrace();
					}

					employees.remove(employeeToDelete);
					saveEmployeesToFile(employees);
					System.out.println("Employee deleted from file: " + FILE_PATH);
				} else {
					System.out.println("Employee with EmpNo " + deleteEmpNo + " not found.");
				}

				// Ask user if they want to delete all data
				System.out.print("!!! Delete all data from both database and file? (Y/N): ");
				String deleteAllChoice = scanner.nextLine();
				if (deleteAllChoice.equalsIgnoreCase("Y")) {
					System.out.print("Are you sure? This will delete all data permanently. (Y/N): ");
					String confirmDeleteAll = scanner.nextLine();
					if (confirmDeleteAll.equalsIgnoreCase("Y")) {
						try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
								Statement stmt = con.createStatement()) {
							stmt.executeUpdate("DELETE FROM employees");
							System.out.println("All data deleted from database.");

							employees.clear();
							saveEmployeesToFile(employees);
							System.out.println("All data deleted from file: " + FILE_PATH);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Delete all operation canceled.");
					}
				}
				break;

			case 8:
				// Share Data if Either Database or File is Empty
				if (employees.isEmpty()) {
					System.out.println("No data available in the collection.");

					// Load data from database and save to file
					try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
							Statement stmt = con.createStatement()) {
						ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
						while (rs.next()) {
							int fetchedEmpNo = rs.getInt("empNo");
							String fetchedEmpName = rs.getString("empName");
							double fetchedSalary = rs.getDouble("salary");
							employees.add(new Employee(fetchedEmpNo, fetchedEmpName, fetchedSalary));
						}
						saveEmployeesToFile(employees);
						System.out.println("Data loaded from database and saved to file.");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					if (employees.isEmpty()) {
						System.out.println("No data available in the collection.");
					} else {
						// Load data from file and save to database
						List<Employee> newEmployees = loadEmployeesFromFile();
						if (!newEmployees.isEmpty()) {
							try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
									PreparedStatement pstmt = con.prepareStatement(
											"INSERT INTO employees (empNo, empName, salary) VALUES (?, ?, ?)")) {
								for (Employee emp : newEmployees) {
									pstmt.setInt(1, emp.getEmpNo());
									pstmt.setString(2, emp.getEmpName());
									pstmt.setDouble(3, emp.getSalary());
									pstmt.executeUpdate();
								}
								System.out.println("Data loaded from file and saved to database.");
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} else {
							System.out.println("No data found in the file to share.");
						}
					}
				}
				break;

			case 9:
			    // Filter Employees by Name
			    System.out.print("Enter the name to search for: ");
			    String searchName = scanner.nextLine();

			    // Filter employees from database
			    System.out.println("Employees from database matching the search name:");
			    try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees WHERE empName LIKE ?")) {
			        pstmt.setString(1, "%" + searchName + "%");
			        ResultSet rs = pstmt.executeQuery();
			        while (rs.next()) {
			            int fetchedEmpNo = rs.getInt("empNo");
			            String fetchedEmpName = rs.getString("empName");
			            double fetchedSalary = rs.getDouble("salary");
			            System.out.println("EmpNo: " + fetchedEmpNo + " | EmpName: " + fetchedEmpName + " | Salary: "
			                    + fetchedSalary);
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			    // Filter employees from file
			    System.out.println("Employees from file matching the search name:");
			    List<Employee> filteredEmployees = employees.stream()
			            .filter(emp -> emp.getEmpName().toLowerCase().contains(searchName.toLowerCase()))
			            .collect(Collectors.toList());

			    for (Employee emp : filteredEmployees) {
			        System.out.println(emp);
			    }
			    break;


			case 10:
				// Synchronize Database and File Data
				if (employees.size() == 0) {
					System.out.println("No employee data available to synchronize.");
					break;
				}

				try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM employees");
					rs.next();
					int databaseCount = rs.getInt(1);

					if (databaseCount == employees.size()) {
						System.out.println("Database and file employee data are already in sync.");
						break;
					}

					if (databaseCount < employees.size()) {
						// Add missing employees from file to database
						System.out.println("Synchronizing database with file...");
						for (Employee emp : employees) {
							try (PreparedStatement pstmt = con.prepareStatement(
									"INSERT INTO employees (empNo, empName, salary) VALUES (?, ?, ?)")) {
								pstmt.setInt(1, emp.getEmpNo());
								pstmt.setString(2, emp.getEmpName());
								pstmt.setDouble(3, emp.getSalary());
								pstmt.executeUpdate();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						System.out.println("Database synchronized with file data.");
					} else {
						// Add missing employees from database to file
						System.out.println("Synchronizing file with database...");
						List<Employee> newEmployees = new ArrayList<>();
						try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees")) {
							ResultSet resultSet = pstmt.executeQuery();
							while (resultSet.next()) {
								int empNo = resultSet.getInt("empNo");
								String empName = resultSet.getString("empName");
								double salary = resultSet.getDouble("salary");
								newEmployees.add(new Employee(empNo, empName, salary));
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}

						// Update the file with data from the database
						employees.clear();
						employees.addAll(newEmployees);
						saveEmployeesToFile(employees);
						System.out.println("File synchronized with database data.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case 11:
				// Check if an employee with a given EmpNo exists
				System.out.print("Enter EmpNo to check: ");
				int checkEmpNo = scanner.nextInt();
				scanner.nextLine();

				Employee checkEmployee = new Employee(checkEmpNo, "", 0); // Create a temporary employee for comparison

				boolean employeeExistsInCollection = false;
				Employee matchedEmployeeInCollection = null;

				for (Employee emp : employees) {
					if (emp.equals(checkEmployee)) {
						employeeExistsInCollection = true;
						matchedEmployeeInCollection = emp;
						break;
					}
				}

				boolean employeeExistsInDatabase = false;
				Employee matchedEmployeeInDatabase = null;

				// Check if employee exists in the database
				try (Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
						PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees WHERE empNo = ?")) {
					pstmt.setInt(1, checkEmpNo);
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						employeeExistsInDatabase = true;
						int fetchedEmpNo = rs.getInt("empNo");
						String fetchedEmpName = rs.getString("empName");
						double fetchedSalary = rs.getDouble("salary");
						matchedEmployeeInDatabase = new Employee(fetchedEmpNo, fetchedEmpName, fetchedSalary);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (employeeExistsInCollection && employeeExistsInDatabase) {
					System.out.println(
							"Employee with EmpNo " + checkEmpNo + " exists both in the collection and database.");
					System.out.println("Matched Employee data in collection: " + matchedEmployeeInCollection);
					System.out.println("Matched Employee data in database: " + matchedEmployeeInDatabase);
				} else if (employeeExistsInCollection) {
					System.out.println(
							"Employee with EmpNo " + checkEmpNo + " exists in the collection but not in the database.");
					System.out.println("Matched Employee data in collection: " + matchedEmployeeInCollection);
				} else if (employeeExistsInDatabase) {
					System.out.println(
							"Employee with EmpNo " + checkEmpNo + " exists in the database but not in the collection.");
					System.out.println("Matched Employee data in database: " + matchedEmployeeInDatabase);
				} else {
					System.out.println("Employee with EmpNo " + checkEmpNo
							+ " does not exist in both the collection and database.");
				}

				// Calculate and display hash code value for a specific EmpNo
				System.out.print("Enter EmpNo for hash code comparison: ");
				int hashCodeEmpNo = scanner.nextInt();
				scanner.nextLine();

				Employee hashCodeEmployee = new Employee(hashCodeEmpNo, "", 0);
				int hashCodeValue = hashCodeEmployee.hashCode();
				System.out.println("Hash code value for Employee with EmpNo " + hashCodeEmpNo + ": " + hashCodeValue);
				break;

			///// ....

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice.");
				break;
			}

		} while (choice != 0);

		scanner.close();
	}

	private static List<Employee> loadEmployeesFromFile() {
		List<Employee> employees = new ArrayList<>();
		try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] data = line.split(",");
				if (data.length == 3) {
					int empNo = Integer.parseInt(data[0]);
					String empName = data[1];
					double salary = Double.parseDouble(data[2]);
					employees.add(new Employee(empNo, empName, salary));
				}
			}
			System.out.println("Data loaded from file: " + FILE_PATH);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + FILE_PATH);
		}
		return employees;
	}

	private static void saveEmployeesToFile(List<Employee> employees) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
			for (Employee emp : employees) {
				writer.println(emp.getEmpNo() + "," + emp.getEmpName() + "," + emp.getSalary());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
