package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Employee;

public class EmployeeGateway {

	public static Employee selectById(int idRow) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM Employee WHERE Id "+ " =? ";
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			statement.setInt(1, idRow);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
								
				String name = resultSet.getString("Name");
				Date hireDate = resultSet.getDate("HireDate");
				int bugThreadId = resultSet.getInt("BugThreadId");
				
				Employee employee = new Employee();
				employee.setId(idRow);
				employee.setName(name);
				employee.setHireDate(hireDate);
				employee.setBugThreadId(bugThreadId);
				
				return employee;
				
			}

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		return null;
	
	}
	
}


