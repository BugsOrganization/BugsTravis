package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.BugThread;

public class BugThreadGateway {

	public static BugThread selectById(int idRow) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM BugThread WHERE Id "+ " =? ";
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			statement.setInt(1, idRow);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
								
				String comment = resultSet.getString("Comment");
				int bugId = resultSet.getInt("BugId");
				
				BugThread bugThread = new BugThread();
				bugThread.setId(idRow);
				bugThread.setComment(comment);
				bugThread.setBugId(bugId);
			
				return bugThread;
				
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


