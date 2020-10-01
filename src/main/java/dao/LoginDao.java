package dao;

import newModel.UserInfo;

public interface LoginDao {
	
	UserInfo getUser(String id);
	String getPassword(String id);
	Integer getIdCount(String id);
	
}
