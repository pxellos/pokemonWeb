package newModel;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInfo {
	@NotEmpty
	private String id;
	private String gradeGradeName;
	@NotEmpty
	private String password;
	private String userName;
	private String email;
	private Integer phoneNumber;
	private Integer birthDay;
	private String address;
	private String job;
	private Integer userGold;
	private Integer rating;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGradeGradeName() {
		return gradeGradeName;
	}
	public void setGradeGradeName(String gradeGradeName) {
		this.gradeGradeName = gradeGradeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserGold() {
		return userGold;
	}
	public void setUserGold(Integer userGold) {
		this.userGold = userGold;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
