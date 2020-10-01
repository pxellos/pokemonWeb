package newModel;

import org.hibernate.validator.constraints.NotEmpty;

public class Deck {
	@NotEmpty
	private String userInfoId;
	private String fullDeck;
	private Integer entityNumberOne;
	private Integer entityNumberTwo;
	private Integer entityNumberThree;
	private Integer entityNumberFour;
	private Integer entityNumberFive;
	private Integer entityNumberSix;
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getFullDeck() {
		return fullDeck;
	}
	public void setFullDeck(String fullDeck) {
		this.fullDeck = fullDeck;
	}
	public Integer getEntityNumberOne() {
		return entityNumberOne;
	}
	public void setEntityNumberOne(Integer entityNumberOne) {
		this.entityNumberOne = entityNumberOne;
	}
	public Integer getEntityNumberTwo() {
		return entityNumberTwo;
	}
	public void setEntityNumberTwo(Integer entityNumberTwo) {
		this.entityNumberTwo = entityNumberTwo;
	}
	public Integer getEntityNumberThree() {
		return entityNumberThree;
	}
	public void setEntityNumberThree(Integer entityNumberThree) {
		this.entityNumberThree = entityNumberThree;
	}
	public Integer getEntityNumberFour() {
		return entityNumberFour;
	}
	public void setEntityNumberFour(Integer entityNumberFour) {
		this.entityNumberFour = entityNumberFour;
	}
	public Integer getEntityNumberFive() {
		return entityNumberFive;
	}
	public void setEntityNumberFive(Integer entityNumberFive) {
		this.entityNumberFive = entityNumberFive;
	}
	public Integer getEntityNumberSix() {
		return entityNumberSix;
	}
	public void setEntityNumberSix(Integer entityNumberSix) {
		this.entityNumberSix = entityNumberSix;
	}

}
