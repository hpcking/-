package com.txl.server;


import com.txl.entity.User;

public interface UserService extends BaseService<User> {

	/**
	 * �û���¼У��
	 * @param student У���û����� �û��� ������
	 * @return null ��ʾУ��ʧ�ܡ���¼ʧ��
	 */
	User validateUserInfo(User user);
	User reseeion(Object userid);
    User findusername(Object userid);
}
