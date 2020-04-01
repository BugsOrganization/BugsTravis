package unit_testing;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	boolean checkEqualProducts(Products a, Products b)
	{
		return a.getId() == b.getId() && a.getDate().equals(b.getDate())
				&& a.getDescription().equals(b.getDescription())
				&& a.getName().equals(b.getName());
	}
	
	boolean checkEqualBugs(Bug a, Bug b)
	{
		return a.getId() == b.getId() && a.getProductId() == b.getProductId()
				&& a.getStatus().equals(b.getStatus()) && a.getPriority() == b.getPriority()
				&& a.getRegisteredBy() == b.getRegisteredBy() 
				&& a.getAssignedTo() == b.getAssignedTo();
	}
	
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
			
		assertTrue(checkEqualProducts(b, dbProduct));
		
		
		b.setName("Updated name");
		
		b.updateTableById();
		
		dbProduct = Products.selectById(6);
		assertTrue(checkEqualProducts(b, dbProduct));
	
		b.deleteFromTableById();
		dbProduct = Products.selectById(6);
		assertNull(dbProduct);
		
	}
	
	
	@Test
	public void testBugs() throws Exception {
		
		Bug bug = new Bug(2, 1, "Assigned", 3, 2, 1);
		Bug dbBug = BugGateway.selectById(2);
		
		assertTrue(checkEqualBugs(bug, dbBug));
		
		bug = BugGateway.insertIntoTableById(17, 2, "New", 2, 2, 2);
		dbBug = BugGateway.selectById(17);
		
		assertTrue(checkEqualBugs(bug, dbBug));
	}
}
