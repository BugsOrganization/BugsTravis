package unit_testing;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.*;

import data_access.BugGateway;
import data_access.ConnectionFactory;
import data_access.Products;
import model.Bug;

public class JUnit {
	
	
	@Test
	public void testProduct() throws Exception {
		
		Products b = new Products();
		b.setId(6);
		b.setName("Pay app new23");
		b.setDescription("Try out the new product app for making online trades22");
		b.setDate(new Date(116, 02, 26));
		
		Connection connection = null;
	
		connection = ConnectionFactory.getConnection();
		b.insertIntoTableById();
			
		Products dbProduct = Products.selectById(6);
			
		assertTrue(b.equals(dbProduct));
		
		
		b.setName("Updated name");
		
		b.updateTableById();
		
		dbProduct = Products.selectById(6);
		assertTrue(b.equals(dbProduct));
	
		b.deleteFromTableById();
		dbProduct = Products.selectById(6);
		assertNull(dbProduct);
		
	}
	
	
	@Test
	public void testBugs() throws Exception {
		
		Bug bug = new Bug(2, 1, "Assigned", 3, 2, 1);
		Bug dbBug = BugGateway.selectById(2);
		
		assertTrue(bug.equals(dbBug));
		
		bug = BugGateway.insertIntoTableById(20, 2, "New", 2, 2, 2);
		dbBug = BugGateway.selectById(20);
		
		assertTrue(bug.equals(dbBug));
	}
}
