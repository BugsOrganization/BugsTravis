package model;

public class BugThread {
	private int Id;
	private String Comment;
	private int BugId;
	
	public BugThread() {
		
	}
	
	public void setId(int id) {
		Id = id;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public void setBugId(int bugId) {
		BugId = bugId;
	}

	public BugThread(int id, String comment, int bugId) {
		this.Id = id;
		this.Comment = comment;
		this.BugId = bugId;
	}
	
	public int getId() {
		return Id;
	}

	public String getComment() {
		return Comment;
	}

	public int getBugId() {
		return BugId;
	}	
	
}
