package org.example.DAO;

import org.example.model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImpl {
    public static void main(String[] args) {
        try {
        DAOoperations daOoperations = new DAOoperations();
        Scanner scanner = new Scanner(System.in);
            System.out.println("==========================Employee Details========================");
            System.out.println();

        boolean flag= true;
        while(flag) {
            daOoperations.printOptions();

            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    List<Employee> employees = daOoperations.getAllemployees();
                    System.out.format("%-30s %-30s %-30s\n", "Employee id", "Employee Name", "Employee Salary");
                    for (Employee employee : employees) {
                        System.out.format("%-30d %-30s %-30s\n", employee.getEmp_id(), employee.getEmp_name(), employee.getEmp_salary());
                    }
                    System.out.println();
                    break;
                case 2:
                    boolean flag1 = true;
                    while(flag1) {
                        System.out.println("Press 1 to add"+"\n"+
                                            "Press 2 to go back");
                        int b = scanner.nextInt();
                        switch (b) {
                            case 1:
                                System.out.println("Enter the name of the employee");
                                scanner.nextLine();
                                String name = scanner.nextLine();
                                System.out.println("Enter the salary of the employee");
                                double salary = scanner.nextDouble();
                                int row = daOoperations.addEmployee(name, salary);
                                if (row == 1) {
                                    System.out.println("Employee added");
                                    System.out.println();
                                } else {
                                    System.out.println("Employee not added");
                                }
                            break;
                            case 2:
                                flag1 = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean flag2 = true;
                    while(flag2) {
                        System.out.println("Press 1 to update employee's name"+"\n"+
                                            "Press 2 to update employee's salary"+"\n"+
                                            "Press 3 to update both name and salary"+"\n"+
                                            "Press 4 to go back");
                        int c = scanner.nextInt();
                        switch(c) {
                            case 1:
                                List<Employee> employeesList = daOoperations.getAllemployees();
                                System.out.format("%-30s %-30s %-30s\n", "Employee id", "Employee Name", "Employee Salary");
                                for (Employee employee : employeesList) {
                                   System.out.format("%-30d %-30s %-30s\n", employee.getEmp_id(), employee.getEmp_name(), employee.getEmp_salary());
                                }
                                System.out.println("Enter the employee id you want to update");
                                int id = scanner.nextInt();
                                System.out.println("Enter the name of the employee");
                                scanner.nextLine();
                                String name1 = scanner.nextLine();
                                int row1 = daOoperations.updateEmployeeByName(id, name1);
                                if (row1 == 1) {
                                    System.out.println("Employee updated");
                                    System.out.println();
                                } else {
                                    System.out.println("Employee not updated");
                                }
                                break;
                            case 2:
                                List<Employee> employeesLists = daOoperations.getAllemployees();
                                System.out.format("%-30s %-30s %-30s\n", "Employee id", "Employee Name", "Employee Salary");
                                for (Employee employee : employeesLists) {
                                    System.out.format("%-30d %-30s %-30s\n", employee.getEmp_id(), employee.getEmp_name(), employee.getEmp_salary());
                                }
                                System.out.println("Enter the employee id you want to update");
                                int id1 = scanner.nextInt();
                                System.out.println("Enter the salary of the employee");
                                double salary = scanner.nextDouble();
                                int row2=daOoperations.updateEmployeeBySalary(id1,salary);
                                if (row2 == 1) {
                                    System.out.println("Employee updated");
                                    System.out.println();
                                } else {
                                    System.out.println("Employee not updated");
                                }
                                break;
                            case 3:
                                List<Employee> employeesLists1 = daOoperations.getAllemployees();
                                System.out.format("%-30s %-30s %-30s\n", "Employee id", "Employee Name", "Employee Salary");
                                for (Employee employee : employeesLists1) {
                                    System.out.format("%-30d %-30s %-30s\n", employee.getEmp_id(), employee.getEmp_name(), employee.getEmp_salary());
                                }
                                System.out.println("Enter the employee id you want to update");
                                int id2 = scanner.nextInt();
                                System.out.println("Enter the name of the employee");
                                scanner.nextLine();
                                String name2 = scanner.nextLine();
                                System.out.println("Enter the salary of the employee");
                                double salary1 = scanner.nextDouble();
                                int row3 = daOoperations.updateEmployee(id2,name2,salary1);
                                if (row3 == 1) {
                                    System.out.println("Employee updated");
                                    System.out.println();
                                } else {
                                    System.out.println("Employee not updated");
                                }
                                break;
                            case 4:
                                flag2 = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
