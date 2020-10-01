package newModel;

import org.hibernate.validator.constraints.NotEmpty;

public class WarLog {
	@NotEmpty
	private Integer warNumber;
	private String warDate;
	private String attackId;
	private String defenseId;
	private String warDescript;
	private String warResult;
	private Integer beforeAttackRating;
	private Integer beforeDefenseRating;
	private Integer attackRatingChange;
	private Integer defenseRatingChange;
	public Integer getWarNumber() {
		return warNumber;
	}
	public void setWarNumber(Integer warNumber) {
		this.warNumber = warNumber;
	}
	public String getWarDate() {
		return warDate;
	}
	public void setWarDate(String warDate) {
		this.warDate = warDate;
	}
	public String getAttackId() {
		return attackId;
	}
	public void setAttackId(String attackId) {
		this.attackId = attackId;
	}
	public String getDefenseId() {
		return defenseId;
	}
	public void setDefenseId(String defenseId) {
		this.defenseId = defenseId;
	}
	public String getWarDescript() {
		return warDescript;
	}
	public void setWarDescript(String warDescript) {
		this.warDescript = warDescript;
	}
	public String getWarResult() {
		return warResult;
	}
	public void setWarResult(String warResult) {
		this.warResult = warResult;
	}
	public Integer getBeforeAttackRating() {
		return beforeAttackRating;
	}
	public void setBeforeAttackRating(Integer beforeAttackRating) {
		this.beforeAttackRating = beforeAttackRating;
	}
	public Integer getBeforeDefenseRating() {
		return beforeDefenseRating;
	}
	public void setBeforeDefenseRating(Integer beforeDefenseRating) {
		this.beforeDefenseRating = beforeDefenseRating;
	}
	public Integer getAttackRatingChange() {
		return attackRatingChange;
	}
	public void setAttackRatingChange(Integer attackRatingChange) {
		this.attackRatingChange = attackRatingChange;
	}
	public Integer getDefenseRatingChange() {
		return defenseRatingChange;
	}
	public void setDefenseRatingChange(Integer defenseRatingChange) {
		this.defenseRatingChange = defenseRatingChange;
	}
	
}
