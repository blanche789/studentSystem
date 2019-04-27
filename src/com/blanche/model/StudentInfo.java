package com.blanche.model;

public class StudentInfo {
	private int id;
	private String stuNum;
	private String name;
	private String sex;
	private int age;
	private String _class;
	private String academy;
	private String telephone;
	public StudentInfo() {
		super();
	}
	public StudentInfo(int id, String stuNum, String name, String sex, int age, String _class, String academy,
			String telephone) {
		this.id = id;
		this.stuNum = stuNum;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this._class = _class;
		this.academy = academy;
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public String getStuNum() {
		return stuNum;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public String get_Class() {
		return _class;
	}
	public String getAcademy() {
		return academy;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setClass(String _class) {
		this._class = _class;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
