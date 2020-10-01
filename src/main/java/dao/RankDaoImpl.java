package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Rank;
import newModel.UserInfo;

@Repository
public class RankDaoImpl implements RankDao {
	@Autowired
	private SqlSession session;
	
	public List<Rank> rankingList() {
		
		return session.selectList("mappers.myMapper.selectRanking");
	}

	public void insertRank(String userinfo_id) {
		session.insert("mappers.myMapper.insertRank", userinfo_id);
		
	}

	public Integer selectRating(String userId1) {
		return session.selectOne("mappers.myMapper.selectRating", userId1);
	}

	public void updatePlusRank(String userId) {
		session.update("mappers.myMapper.updatePlusRank",userId);
		
	}

	public void updateMinusRank(String userId) {
		session.update("mappers.myMapper.updateMinusRank",userId);
		
	}
	public Rank playerRank(String id) {
		return session.selectOne("mappers.myMapper.playerRank",id);
	}


}
