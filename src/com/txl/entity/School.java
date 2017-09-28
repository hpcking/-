package com.txl.entity;

import java.util.Set;

public class School {
private int schoolid;
private String schoolname;
private String image;
private String motto;
private Set<User> user;
private int userid;



public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getSchoolid() {
	return schoolid;
}
public void setSchoolid(int schoolid) {
	this.schoolid = schoolid;
}
public String getSchoolname() {
	return schoolname;
}
public void setSchoolname(String schoolname) {
	this.schoolname = schoolname;
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
public Set<User> getUser() {
	return user;
}
public void setUser(Set<User> user) {
	this.user = user;
}


}
