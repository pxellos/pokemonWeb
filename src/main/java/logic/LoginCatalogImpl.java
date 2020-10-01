package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EntryDao;
import dao.LoginDao;
import newModel.UserInfo;

@Service
public class LoginCatalogImpl implements LoginCatalog {
//	@Autowired
//	private LoginDao loginDao;
//	@Autowired
//	private EntryDao entryDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private EntryDao entryDao;
	public String getPwd(String id) {
		return loginDao.getPassword(id);
	}
	public Integer getIdCnt(String id) {
		return loginDao.getIdCount(id);
	}
	public void entryUser(UserInfo user) {
		entryDao.entryUser(user);
	}

	
	
	
//	public void entryUser(User user) {
//		entryDao.entryUser(user);
//	}
//
//	public String getPwd(String id) {
//		return loginDao.getPassword(id);
//	}
//
//	public Integer getIdCnt(String id) {
//		return loginDao.getIdCount(id);
//	}

}





