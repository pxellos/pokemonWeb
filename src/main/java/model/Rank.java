package model;

import java.util.List;

public class Rank {
	private Integer rankingNumber;
	private String userinfo_id;
	private Integer rating;
	
	private List<Integer> deckList;
	
	public Integer getRankingNumber() {
		return rankingNumber;
	}
	public void setRankingNumber(Integer rankingNumber) {
		this.rankingNumber = rankingNumber;
	}
	public String getUserinfo_id() {
		return userinfo_id;
	}
	public void setUserinfo_id(String userinfo_id) {
		this.userinfo_id = userinfo_id;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public List<Integer> getDeckList() {
		return deckList;
	}
	public void setDeckList(List<Integer> deckList) {
		this.deckList = deckList;
	}
	
	
}
