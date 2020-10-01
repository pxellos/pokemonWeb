package dao;

import java.util.List;

import model.Rank;
import newModel.UserInfo;

public interface RankDao {
	
	public List<Rank> rankingList();
	
	public void insertRank(String userId1);
	
	public void updatePlusRank(String userId);
	
	public void updateMinusRank(String userId);
	
	public Integer selectRating(String userId1);
	
	Rank playerRank(String id);
}
