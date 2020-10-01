package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import newModel.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private SqlSession session;

	public List<UserInfo> userInfoList() {
		return session.selectList("mappers.myMapper.selectUserInfoList");
	}

	public UserInfo user(String id) {
		return session.selectOne("mappers.myMapper.getUser2", id); // 계정으로 사용자 검색
	}

	public List<String> userIdList() {
		return session.selectList("mappers.myMapper.");
	}

	public void chargeGold(UserInfo userInfo) {
		session.update("mappers.myMapper.chargeMoney", userInfo);
	}
	
	public Integer getMoney(UserInfo userInfo) {
		return session.selectOne("mappers.myMapper.getMoney",userInfo);
		
	}

	public void deduct(UserInfo userInfo) {
		session.update("mappers.myMapper.deduct", userInfo);
		
	}

}