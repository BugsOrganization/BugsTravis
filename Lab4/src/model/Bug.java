package model;

public class Bug {
	private int Id;
	private int ProductId;
	private String Status;
	private int Priority;
	private int RegisteredBy;
	private int AssignedTo;
	
	public void setId(int id) {
		Id = id;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public void setRegisteredBy(int registeredBy) {
		RegisteredBy = registeredBy;
	}

	public void setAssignedTo(int assignedTo) {
		AssignedTo = assignedTo;
	}

	public Bug() {
		
	}
	
	public Bug(int id, int productId, String status, int priority, int registeredBy, int assignedTo) {
		this.Id = id;
		this.ProductId = productId;
		this.Status = status;
		this.Priority = priority;
		this.RegisteredBy = registeredBy;
		this.AssignedTo = assignedTo;
	}

	public int getId() {
		return Id;
	}

	public int getProductId() {
		return ProductId;
	}

	public String getStatus() {
		return Status;
	}

	public int getPriority() {
		return Priority;
	}

	public int getRegisteredBy() {
		return RegisteredBy;
	}

	public int getAssignedTo() {
		return AssignedTo;
	}
	
	
	
}
