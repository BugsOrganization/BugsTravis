package data_access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Products {
	private int Id;
	private String Name;
	private String Description;
	private Date ReleaseDate;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getDescription() {
		return this.Description;
	}
	
	public void setDescription(String description) {
		this.Description = description;
	}
	
	public Date getDate() {
		return this.ReleaseDate;
	}
	
	public void setDate(Date date) {
		this.ReleaseDate = date;
	}
	
	private final static String selectByIdStatement = "SELECT * FROM Products WHERE Id "+ " =? ";
	private final static String selectStatement = "SELECT * FROM Products";
	
	
	public static ArrayList<Products> selectAllProducts(){

		ArrayList<Products> listOfProducts = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = selectStatement;
		
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			resultSet = statement.executeQuery();
			int i = 0;
			while(resultSet.next()) {
				
				int idRow = resultSet.getInt("Id");
				String name = resultSet.getString("Name");
				String description = resultSet.getString("Description");
				Date release = resultSet.getDate("ReleaseDate");
				
				Products product = new Products();
				product.setId(idRow);
				product.setName(name);
				product.setDescription(description);
				product.setDate(release);
				
				listOfProducts.add(i, product);
				i++;
				
			}
			return listOfProducts;

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		return null;
	
	}
	
	public static Products selectById(int idRow) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = selectByIdStatement;
		
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			statement.setInt(1, idRow);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
				String name = resultSet.getString("Name");
				String description = resultSet.getString("Description");
				Date release = resultSet.getDate("ReleaseDate");
				
				Products product = new Products();
				product.setId(idRow);
				product.setName(name);
				product.setDescription(description);
				product.setDate(release);
				
				return product;
			}

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		return null;
	
	}
	
	
	private String updateStatementId() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("UPDATE ");
		stringBuilder.append(" Products ");
		stringBuilder.append(" SET ");
		stringBuilder.append(" Name =?, Description =?, ReleaseDate =? ");
		stringBuilder.append(" WHERE " +  " Id " + " =? ");

		return stringBuilder.toString();
		
	}
	
	public void updateTableById() {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = updateStatementId();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			
			statement.setString(1, this.Name);
			statement.setString(2, this.Description);
			statement.setDate(3, this.ReleaseDate);
			statement.setInt(4, this.Id);
			
			statement.executeUpdate();

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
	}
	
	private String insertStatement() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO ");
		stringBuilder.append(" Products ");
		stringBuilder.append(" VALUES ");
		stringBuilder.append(" (?, ?, ?, ?) ");

		return stringBuilder.toString();
	}

	public void insertIntoTableById() {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = insertStatement();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			
			statement.setInt(1, this.Id);
			statement.setString(2, this.Name);
			statement.setString(3, this.Description);
			statement.setDate(4, this.ReleaseDate);
			
			statement.executeUpdate();

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
	}
	
	private String deleteStatementId() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DELETE FROM ");
		stringBuilder.append(" Products ");
		stringBuilder.append(" WHERE " +  " Id " + " =? ");

		return stringBuilder.toString();
		
	}
	
	public void deleteFromTableById() {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = deleteStatementId();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			
			statement.setInt(1, this.Id);
			statement.executeUpdate();

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
	}
	
	public static String toString(Products a)
	{
		String message = "Id: " + a.Id + "; Name: " + a.Name + "; Description: " 
				+ a.Description + "; Release date: " + a.ReleaseDate;
		
		return message;
	}
	
}
