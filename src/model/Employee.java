package model;

import java.util.Date;

public class Employee {
	private int Id;
	private String Name;
	private Date HireDate;
	private int BugThreadId;
	
	public void setId(int id) {
		Id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setHireDate(Date hireDate) {
		HireDate = hireDate;
	}

	public void setBugThreadId(int bugThreadId) {
		BugThreadId = bugThreadId;
	}
	
	public Employee() {
		
	}
	
	public Employee(int Id, String name, Date date, int bugThreadId)
	{
		this.Id = Id;
		this.Name = name;
		this.HireDate = date;
		this.BugThreadId = bugThreadId;
	}
	
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public Date getHireDate() {
		return HireDate;
	}
	public int getBugThreadId() {
		return BugThreadId;
	}
	
}
