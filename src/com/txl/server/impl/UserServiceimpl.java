package com.txl.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.txl.dao.BaseDao;
import com.txl.entity.User;
import com.txl.server.UserService;
import com.txl.until.ValidateUtils;

@Service("userService")
public class UserServiceimpl extends BaseServiceimpl<User> implements UserService{

	@Resource(name = "userDao")
	@Override
	public void setBaseDao(BaseDao<User> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Override
	public User validateUserInfo(User user) {
		String hql = "from User where username=? and password=?";
		String password = user.getPassword();
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		List<User> users = this.findEntiyByHql(hql, user.getUsername(), password);
		return ValidateUtils.isValidate(users) ? users.get(0) : null;
	}

	@Override
	public User reseeion(Object userid) {
		String hql = "from User where userid=?";
		List<User> users = this.findEntiyByHql(hql,userid);
		return ValidateUtils.isValidate(users) ? users.get(0) : null;
	}

	@Override
	public User findusername(Object userid) {
		String hql = "from User where userid=?";
		List<User> users = this.findEntiyByHql(hql,userid);
		return ValidateUtils.isValidate(users) ? users.get(0) : null;
	}

}
