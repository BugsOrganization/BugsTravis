package bll;

import data_access.BugGateway;
import data_access.BugThreadGateway;
import data_access.EmployeeGateway;
import data_access.Products;
import model.Bug;
import model.BugThread;
import model.Employee;

public class BugLogic {
	
	public static BugThread giveThreadForBug(int bugId) {
		int idRow = 1;
		while(1 == 1) {
			
			BugThread bugThread = BugThreadGateway.selectById(idRow);
			
			if(bugThread.getBugId() == bugId) {
				return bugThread;
			}
			else idRow++;		
		}
		
	}
	
	public String readBug(int id) {
		Bug bug = BugGateway.selectById(id);
		Employee registered = EmployeeGateway.selectById(bug.getRegisteredBy());
		Employee assigned = EmployeeGateway.selectById(bug.getAssignedTo());
	
		BugThread bugThread = BugLogic.giveThreadForBug(id);
		
		Products products = Products.selectById(bug.getProductId());
		
		return "Bag with status: " + bug.getStatus() + " and priority: " + bug.getPriority() +
				" is from product " + products.getName() + ", was registered by: " + 
				registered.getName() + " and assigned to: " + assigned.getName() + 
				"; the comments from his thread are: " + bugThread.getComment();
	}
	
	public String insertIntoBug(int id, int productId, String status, int priority, int registeredBy, int assignedTo) {
		
	    Bug bug = new Bug();
	    bug = BugGateway.insertIntoTableById(id, productId, status, priority, registeredBy, assignedTo);

	    Employee registered = EmployeeGateway.selectById(registeredBy);
		Employee assigned = EmployeeGateway.selectById(assignedTo);
	
		Products products = Products.selectById(productId);
		
		return "Bag with status: " + status + " and priority: " + priority +
				" is from product " + products.getName() + ", was registered by: " + 
				registered.getName() + " and assigned to: " + assigned.getName();
	}
	
}
