package logic;

import newModel.UserInfo;

public interface LoginCatalog {
//	String getPwd(String id);
//	Integer getIdCnt(String id);
//	void entryUser(User user);
	
	String getPwd(String id);
	Integer getIdCnt(String id);
	void entryUser(UserInfo user);
	
}
