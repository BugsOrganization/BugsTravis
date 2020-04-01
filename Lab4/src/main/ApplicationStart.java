package main;

import java.sql.Date;
import java.util.Scanner;

import bll.BugLogic;
import data_access.Products;
import unit_testing.JUnit;

public class ApplicationStart {

	void testProducts() {

		System.out.println("Products are");
	
		for(Products s: Products.selectAllProducts()) {
			System.out.println(Products.toString(s));	
		}
		
		Scanner inScanner = new Scanner(System.in);
		
		System.out.println("Type the id of the product wanted...");
		int productId = inScanner.nextInt();
		
		Products a = Products.selectById(productId);
		System.out.println("Product with id " + productId + " is " + Products.toString(a));

		Products b = new Products();
		b.setId(4);
		b.setName("Pay app new");
		b.setDescription("Try out the new product app for making online trades");
		b.setDate(new Date(116, 07, 24));
		
		System.out.println("Insert a new row");
		b.insertIntoTableById();
		
		System.out.println(Products.toString(b));
		
		b.setName("Pay app updated");
		System.out.println("Update a row");
		b.updateTableById();
		
		System.out.println(Products.toString(b));
		
		b.setId(5);
		b.setName("Pay app new");
		b.setDescription("Try out the new product app for making online trades");
		b.setDate(new Date(116, 07, 24));
		
		b.deleteFromTableById();
		
	}
	
	void testBugs() {
		BugLogic bugLogic = new BugLogic();
		System.out.println("Read bug");
		System.out.println(bugLogic.readBug(4));
		System.out.println("Insert bug");
		System.out.println(bugLogic.insertIntoBug(15, 2, "Assigned", 1, 1, 2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JUnit jUnit = new JUnit();
		ApplicationStart applicationStart = new ApplicationStart();
		applicationStart.testProducts();
		applicationStart.testBugs();
	}

}
