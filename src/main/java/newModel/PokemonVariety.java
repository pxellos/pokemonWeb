package newModel;

import java.sql.PreparedStatement;
import java.sql.Types;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class PokemonVariety {
	@NotEmpty
	private Integer varietyNumber;
	private String pokemonName;
	private String typeOne;
	private String typeTwo;
	private Integer evolutionLevel;
	private Integer varietyPhysicalAttack;
	private Integer varietyPhysicalDefense;
	private Integer varietyTypeAttack;
	private Integer varietyTypeDefense;
	private Integer varietySpeed;
	private Integer varietyHealth;
	private Integer varietyTotal;
	private String normalSkill;
	private String typeSkill;
	private String descript;
	private String imageRoot;
	private Integer potential;
	private Integer price;
	private MultipartFile image;
	
	
	public PokemonEntity insertEntity(PokemonEntity poke, Integer count, String id, Integer code) {//종족값 참조하여 엔티티 생
		
		poke.setEntityHealth(this.varietyHealth);
		poke.setEntityNumber(count);
		poke.setEntityPhysicalAttack(this.varietyPhysicalAttack);
		poke.setEntityPhysicalDefense(this.varietyPhysicalDefense);
		poke.setEntitySpeed(this.varietySpeed);
		poke.setEntityTotal(this.varietyTotal);
		poke.setEntityTypeAttack(this.varietyTypeAttack);
		poke.setEntityTypeDefense(this.varietyTypeDefense);
		poke.setEvolutionLevel(this.evolutionLevel);
		poke.setNormalSkill(this.normalSkill);
		poke.setPokemon_Variety_VarietyNumber(this.varietyNumber);
		poke.setPokemonName(this.pokemonName);
		poke.setTypeOne(this.typeOne);
		if(this.typeTwo == null) {
			poke.setTypeTwo("없음");
		} else {
			poke.setTypeTwo(this.typeTwo);
		}
		poke.setTypeSkill(this.typeSkill);
		poke.setUserInfo_Id(id);
		poke.setCharacter("없음");
		poke.setImageRoot("없음");
		
		return poke;
		
	}
	
	
	/** getter setter **/
	public Integer getVarietyNumber() {
		return varietyNumber;
	}
	public void setVarietyNumber(Integer varietyNumber) {
		this.varietyNumber = varietyNumber;
	}
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public String getTypeOne() {
		return typeOne;
	}
	public void setTypeOne(String typeOne) {
		this.typeOne = typeOne;
	}
	public String getTypeTwo() {
		return typeTwo;
	}
	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}
	public Integer getEvolutionLevel() {
		return evolutionLevel;
	}
	public void setEvolutionLevel(Integer evolutionLevel) {
		this.evolutionLevel = evolutionLevel;
	}
	public Integer getVarietyPhysicalAttack() {
		return varietyPhysicalAttack;
	}
	public void setVarietyPhysicalAttack(Integer varietyPhysicalAttack) {
		this.varietyPhysicalAttack = varietyPhysicalAttack;
	}
	public Integer getVarietyPhysicalDefense() {
		return varietyPhysicalDefense;
	}
	public void setVarietyPhysicalDefense(Integer varietyPhysicalDefense) {
		this.varietyPhysicalDefense = varietyPhysicalDefense;
	}
	public Integer getVarietyTypeAttack() {
		return varietyTypeAttack;
	}
	public void setVarietyTypeAttack(Integer varietyTypeAttack) {
		this.varietyTypeAttack = varietyTypeAttack;
	}
	public Integer getVarietyTypeDefense() {
		return varietyTypeDefense;
	}
	public void setVarietyTypeDefense(Integer varietyTypeDefense) {
		this.varietyTypeDefense = varietyTypeDefense;
	}
	public Integer getVarietySpeed() {
		return varietySpeed;
	}
	public void setVarietySpeed(Integer varietySpeed) {
		this.varietySpeed = varietySpeed;
	}
	public Integer getVarietyHealth() {
		return varietyHealth;
	}
	public void setVarietyHealth(Integer varietyHealth) {
		this.varietyHealth = varietyHealth;
	}
	public Integer getVarietyTotal() {
		return varietyTotal;
	}
	public void setVarietyTotal(Integer varietyTotal) {
		this.varietyTotal = varietyTotal;
	}
	
	public String getNormalSkill() {
		return normalSkill;
	}


	public void setNormalSkill(String normalSkill) {
		this.normalSkill = normalSkill;
	}


	public String getTypeSkill() {
		return typeSkill;
	}


	public void setTypeSkill(String typeSkill) {
		this.typeSkill = typeSkill;
	}


	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getImageRoot() {
		return imageRoot;
	}
	public void setImageRoot(String imageRoot) {
		this.imageRoot = imageRoot;
	}
	public Integer getPotential() {
		return potential;
	}
	public void setPotential(Integer potential) {
		this.potential = potential;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
}
