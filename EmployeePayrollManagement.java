import java.util.Scanner;

public class EmployeePayrollManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays to store employee data (fixed size for simplicity)
        int[] empId = new int[100];
        String[] empName = new String[100];
        double[] basicSalary = new double[100];
        double[] netSalary = new double[100];
        int count = 0;

        int choice;

        do {
            System.out.println("\n====== Employee Payroll Management System ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Calculate Salary");
            System.out.println("4. Generate Payslip");
            System.out.println("5. Search Employee");
            System.out.println("6. Update Employee Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    empId[count] = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    empName[count] = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    basicSalary[count] = sc.nextDouble();

                    netSalary[count] = 0; // not yet calculated
                    count++;
                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:
                    System.out.println("\n=== Employee Records ===");
                    for (int i = 0; i < count; i++) {
                        System.out.println("ID: " + empId[i] + " | Name: " + empName[i] + " | Basic Salary: " + basicSalary[i]);
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Calculate Salary: ");
                    int id = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (empId[i] == id) {
                            found = true;
                            double da = 0.2 * basicSalary[i];   // 20% DA
                            double hra = 0.1 * basicSalary[i];  // 10% HRA
                            double pf = 0.08 * basicSalary[i];  // 8% PF deduction
                            double gross = basicSalary[i] + da + hra;
                            double tax = 0;

                            // Apply tax using decision-making
                            if (gross > 50000)
                                tax = 0.1 * gross;
                            else if (gross > 30000)
                                tax = 0.05 * gross;

                            netSalary[i] = gross - (pf + tax);
                            System.out.println("Net Salary Calculated: " + netSalary[i]);
                        }
                    }
                    if (!found)
                        System.out.println("Employee ID not found!");
                    break;

                case 4:
                    System.out.print("Enter Employee ID for Payslip: ");
                    int pid = sc.nextInt();
                    boolean slip = false;
                    for (int i = 0; i < count; i++) {
                        if (empId[i] == pid) {
                            slip = true;
                            System.out.println("\n=== PAYSLIP ===");
                            System.out.println("Employee ID: " + empId[i]);
                            System.out.println("Employee Name: " + empName[i]);
                            System.out.println("Basic Salary: " + basicSalary[i]);
                            System.out.println("Net Salary: " + netSalary[i]);
                        }
                    }
                    if (!slip)
                        System.out.println("Employee not found!");
                    break;

                case 5:
                    System.out.print("Enter Employee Name to Search: ");
                    String name = sc.nextLine();
                    boolean search = false;
                    for (int i = 0; i < count; i++) {
                        if (empName[i].equalsIgnoreCase(name)) {
                            search = true;
                            System.out.println("Found Employee: ID " + empId[i] + ", Basic Salary: " + basicSalary[i]);
                        }
                    }
                    if (!search)
                        System.out.println("Employee not found!");
                    break;

                case 6:
                    System.out.print("Enter Employee ID to Update: ");
                    int uid = sc.nextInt();
                    boolean update = false;
                    for (int i = 0; i < count; i++) {
                        if (empId[i] == uid) {
                            update = true;
                            System.out.print("Enter New Basic Salary: ");
                            basicSalary[i] = sc.nextDouble();
                            System.out.println("Employee Salary Updated Successfully!");
                        }
                    }
                    if (!update)
                        System.out.println("Employee not found!");
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);
    }
}