package org.example.DAO;

import org.example.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

   List<Employee> getAllemployees() throws SQLException, ClassNotFoundException;
   int addEmployee(String emp_name,double emp_salary) throws SQLException, ClassNotFoundException;

   int updateEmployeeByName(int emp_id,String emp_name) throws SQLException, ClassNotFoundException;
   int updateEmployeeBySalary(int emp_id,double emp_salary) throws SQLException, ClassNotFoundException;

   int updateEmployee(int emp_id,String emp_name,double emp_salary) throws SQLException, ClassNotFoundException;
}
