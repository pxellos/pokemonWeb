package newModel;

import org.hibernate.validator.constraints.NotEmpty;

public class Ranking {
	@NotEmpty
	private Integer rankingNumber;
	@NotEmpty
	private String userInfoId;
	private Integer rating;
	public Integer getRankingNumber() {
		return rankingNumber;
	}
	public void setRankingNumber(Integer rankingNumber) {
		this.rankingNumber = rankingNumber;
	}
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
