package com.ssafy.web.vo;

public class MemberVO {

	private int no;
	private String id,name,pw,email;
	
	public MemberVO() {
		super();
	}
	public MemberVO(int no, String id, String name, String pw, String email) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
	}
	public MemberVO(String id, String pw) {
		setId(id);
		setPw(pw);
	}
	
	public MemberVO(String id, String pw, String name) {
		setId(id);
		setPw(pw);
		setName(name);
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email + "]";
	}
}
