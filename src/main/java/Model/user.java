package Model;

public class user implements java.io.Serializable{
	

	private int id;
	private String email;
	private String pass;
	private String first;
	private String last;
	private String dept;
    public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public String getDept() {
		return dept;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
