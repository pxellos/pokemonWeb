package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import newModel.UserInfo;

@Repository
public class EntryDaoImpl implements EntryDao {
	@Autowired
	private SqlSession session;

	public void entryUser(UserInfo user) {
		session.insert("mappers.myMapper.putUser",user);
		
	}


	
	
	
//	public void entryUser(User user) {
//		session.insert("mappers.myMapper.putUser",user);
//	}
	
	

}










