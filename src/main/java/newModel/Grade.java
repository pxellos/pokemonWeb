package newModel;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Grade {
	@NotEmpty
	private String gradeName;
	private Integer gradeMinScore;
	private String gradeImageRoot;
	private MultipartFile image;
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getGradeImageRoot() {
		return gradeImageRoot;
	}
	public void setGradeImageRoot(String gradeImageRoot) {
		this.gradeImageRoot = gradeImageRoot;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public Integer getGradeMinScore() {
		return gradeMinScore;
	}
	public void setGradeMinScore(Integer gradeMinScore) {
		this.gradeMinScore = gradeMinScore;
	}

}

