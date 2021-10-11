package server.User;

public class User {
	private String uID;
	private String pw;
	private String uName;
	private String uTel;
	public User(String uID, String pw, String uName, String uTel) {
		this.uID = uID;
		this.pw = pw;
		this.uName = uName;
		this.uTel = uTel;
	}
	
	
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}

}
