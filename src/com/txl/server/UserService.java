package com.txl.server;


import com.txl.entity.User;

public interface UserService extends BaseService<User> {

	/**
	 * 用户登录校验
	 * @param student 校验用户数据 用户名 和密码
	 * @return null 表示校验失败　登录失败
	 */
	User validateUserInfo(User user);
	User reseeion(Object userid);
    User findusername(Object userid);
}
