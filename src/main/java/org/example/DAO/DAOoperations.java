package org.example.DAO;

import org.example.config.DBConfig;
import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOoperations implements EmployeeDAO{

    @Override
    public  List<Employee> getAllemployees() throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employeedetails");
        while(resultSet.next()){
            int emp_id = resultSet.getInt(1);
            String emp_name = resultSet.getString(2);
            double emp_salary = resultSet.getDouble(3);

            employeeList.add(new Employee(emp_id,emp_name,emp_salary));
        }
        return employeeList;
    }

    @Override
    public int addEmployee(String emp_name, double emp_salary) throws SQLException, ClassNotFoundException {
        int row = 0;
        Connection connection = DBConfig.getConnection();
        String sql = "insert into employeedetails (emp_name,emp_salary) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,emp_name);
        preparedStatement.setDouble(2,emp_salary);
        row = preparedStatement.executeUpdate();
        return row;
    }

    @Override
    public int updateEmployeeByName(int emp_id, String emp_name) throws SQLException, ClassNotFoundException {
        int row = 0;
        Connection connection = DBConfig.getConnection();
        String sql = "update employeedetails set emp_name=? where emp_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,emp_name);
        preparedStatement.setInt(2,emp_id);
        row = preparedStatement.executeUpdate();
        return row;
    }

    @Override
    public int updateEmployeeBySalary(int emp_id, double emp_salary) throws SQLException, ClassNotFoundException {
        int row = 0;
        Connection connection = DBConfig.getConnection();
        String sql = "update employeedetails set emp_salary=? where emp_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1,emp_salary);
        preparedStatement.setInt(2,emp_id);
        row = preparedStatement.executeUpdate();
        return row;
    }

    public void printOptions(){
        System.out.println("Press 1 to view all employees"+"\n"+
                            "Press 2 to add an employee"+"\n"+
                            "Press 3 to update an employee"+"\n"+
                            "Press 4 to exit this menu");
    }
}
