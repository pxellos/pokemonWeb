package newModel;

import org.hibernate.validator.constraints.NotEmpty;

public class Skill {
	@NotEmpty
	private String skillNumber;
	private String skillName;
	private Integer skillPower;
	private String skillType;
	private Integer accuracyRate;
	private Integer skillAttackPoint;
	private Integer skillType2;
	
	
	/**getter setter **/
	public String getSkillNumber() {
		return skillNumber;
	}
	public void setSkillNumber(String skillNumber) {
		this.skillNumber = skillNumber;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public Integer getSkillPower() {
		return skillPower;
	}
	public void setSkillPower(Integer skillPower) {
		this.skillPower = skillPower;
	}
	public Integer getAccuracyRate() {
		return accuracyRate;
	}
	public void setAccuracyRate(Integer accuracyRate) {
		this.accuracyRate = accuracyRate;
	}
	public Integer getSkillAttackPoint() {
		return skillAttackPoint;
	}
	public void setSkillAttackPoint(Integer skillAttackPoint) {
		this.skillAttackPoint = skillAttackPoint;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public Integer getSkillType2() {
		return skillType2;
	}
	public void setSkillType2(Integer skillType2) {
		this.skillType2 = skillType2;
	}
	
	
}
