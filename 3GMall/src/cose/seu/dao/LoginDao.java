package cose.seu.dao;

import cose.seu.entity.UserInfo;

public interface LoginDao {
	
	public boolean Login (String username,String passwd);
	/*
	 * �����û�������û��������룬������֤�������û���������errorname �����û���������󷵻�errorpasswd
	 * */
	
	public boolean Register(UserInfo information );
	/*
	 * ���û�ע�����Ϣ��װ��ʵ���࣬�� ʵ����������ݿ�
	 * */
	public boolean UserinfoChange(Long id,UserInfo updateinfo);
	/*
	 * �û��ύҪ���ĵ���Ϣ
	 * */
	public boolean ChangePasswd(String name,String passwd );
	/*
	 * �û����ĸ�����Ϣ
	 * */
	public boolean checkUsernameExist(String name);
	/*
	 * ����û����������Ƿ����
	 * */
	public UserInfo getUserInfo(String name);
	
	public boolean checkPwd(String user,String pwd);
	
	public boolean checkAnswer(String username,String answer);
	

}
