package dao;

import java.util.List;

import model.Bbs;
import newModel.UserInfo;

public interface UserInfoDao {
	
	public List<UserInfo> userInfoList();

	UserInfo user(String id);
	
	public List<String> userIdList();
	
	void chargeGold(UserInfo userInfo);
	Integer getMoney(UserInfo userInfo);
	void deduct(UserInfo userInfo);
}
