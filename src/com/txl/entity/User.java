package com.txl.entity;


import java.util.Set;



public class User {
private int userid;
private String username;
private String password;
private String sex;
private String qq;
private String phone;
private String image;
private String motto;
private Set<School> school;

public int getUserid() {
	return userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getQq() {
	return qq;
}
public void setQq(String qq) {
	this.qq = qq;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getMotto() {
	return motto;
}
public void setMotto(String motto) {
	this.motto = motto;
}
public Set<School> getSchool() {
	return school;
}
public void setSchool(Set<School> school) {
	this.school = school;
}
}
