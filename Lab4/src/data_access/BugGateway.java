package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Bug;

public class BugGateway {
	
	public static Bug selectById(int idRow) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM Bug WHERE Id "+ " =? ";
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			statement.setInt(1, idRow);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
				int productId = resultSet.getInt("ProductId");
				String status = resultSet.getString("Status");
				int priority = resultSet.getInt("Priority");
				int registeredBy = resultSet.getInt("RegisteredBy");
				int assignedTo = resultSet.getInt("AssignedTo");
				
				Bug bug = new Bug();
				bug.setId(idRow);
				bug.setStatus(status);
				bug.setPriority(priority);
				bug.setRegisteredBy(registeredBy);
				bug.setAssignedTo(assignedTo);
				bug.setProductId(productId);
				
				return bug;
				
			}

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		return null;
	
	}
	
	private static String insertStatement() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO ");
		stringBuilder.append(" Bug ");
		stringBuilder.append(" VALUES ");
		stringBuilder.append(" (?, ?, ?, ?, ?, ?) ");

		return stringBuilder.toString();
	}

	public static Bug insertIntoTableById(int id, int productId, String status, int priority, int registeredBy, int assignedTo) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = insertStatement();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			
			Bug bug = new Bug();
			bug.setId(id);
			bug.setStatus(status);
			bug.setPriority(priority);
			bug.setRegisteredBy(registeredBy);
			bug.setAssignedTo(assignedTo);
			bug.setProductId(productId);
			
			statement.setInt(1, id);
			statement.setInt(2, productId);
			statement.setString(3, status);
			statement.setInt(4, priority);
			statement.setInt(5, registeredBy);
			statement.setInt(6, assignedTo);
			
			statement.executeUpdate();
			
			return bug;

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
		
	}
	
}
