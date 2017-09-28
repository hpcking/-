package com.txl.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;

import com.txl.entity.School;
import com.txl.entity.User;
import com.txl.server.SchoolService;
import com.txl.server.UserService;


public class UserServiceTest {

	@Test
	public void save() {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		UserService Service = act.getBean(UserService.class);
		User user = new User();
		School school=new School();
		school.setSchoolid(6);
		Set<School> schools = new HashSet<School>();
		schools.add(school);
		user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
		user.setUsername("ÕÅÈý");
		user.setSchool(schools);
		Service.saveEntity(user);
		System.out.println(user.getUserid());
	}
	@Test
	public void save1() {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		SchoolService Service = act.getBean(SchoolService.class);
		School user = new School();
		user.setSchoolname("dasdwda");
		user.setImage("dsadwada");
		Service.saveEntity(user);
		System.out.println(user.getSchoolid());
	}
	@Test
	public void save2() {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		SchoolService Service = act.getBean(SchoolService.class);
		User user = new User();
		School school=new School();
		school.setSchoolname("chengdu");
		Set<School> schools = new HashSet<School>();
		schools.add(school);
		user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
		user.setUsername("lisi");
		Set<User> users=new HashSet<User>();
		users.add(user);
		school.setUser(users);
		Service.saveEntity(school);
	}
	@Test
	public void save3() {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		SchoolService Service = act.getBean(SchoolService.class);
		User user = new User();
		School school=new School();
		school.setSchoolname("chengdu");
		Set<School> schools = new HashSet<School>();
		schools.add(school);
		user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
		user.setUsername("lisi");
		Set<User> users=new HashSet<User>();
		users.add(user);
		school.setUser(users);
		Service.saveEntity(school);
	}

}
