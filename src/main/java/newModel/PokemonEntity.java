package newModel;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import model.TypeVs;

public class PokemonEntity {

	@NotEmpty
	private Integer entityNumber;
	@NotEmpty
	private String userInfo_Id;
	@NotEmpty
	private Integer pokemon_Variety_VarietyNumber;
	private String pokemonName;
	private String typeOne;
	private String typeTwo;
	private Integer EvolutionLevel;
	private Integer EntityPhysicalAttack;
	private Integer EntityPhysicalDefense;
	private Integer EntityTypeAttack;
	private Integer EntityTypeDefense;
	private Integer EntitySpeed;
	private Integer EntityHealth;
	private Integer EntityTotal;
	private String NormalSkill;
	private String TypeSkill;
	private String ImageRoot;
	private String Character;

	private MultipartFile image;
	
	private List<Skill> normalSkills;
	private List<Skill> typeSkills;
	
	private TypeVs typeVs;
	
	@Autowired
	private SqlSession sqlSession;
	
	/**포켓몬 개체 스킬 세팅 메소드**/
	public String[] normalSkillSub() {//db에서 개체가 가진 노멀스킬을 3글자씩 잘라서 배열에 저장
		String temp = this.NormalSkill;
		String[] tempArray;
		int j = 0;
		if(temp.length() == 3) {
			tempArray = new String[1];
			tempArray[0] = temp;
			return tempArray;
		} else {
			tempArray = new String[temp.length()/3];
			for(int i=0; i<tempArray.length; i++) {
				tempArray[i] = temp.substring(j,j+3);
				j = j+3;
			}
			return tempArray;
		}
	}
	public String[] typeSkillSub() {//db에서 개체가 가진 타입스킬을 3글자씩 잘라서 배열에 저장
		String temp = this.TypeSkill;
		String[] tempArray;
		int j = 0;
		if(temp.length() == 3) {
			tempArray = new String[1];
			tempArray[0] = temp;
			return tempArray;
		} else {
			tempArray = new String[temp.length()/3];
			for(int i=0; i<tempArray.length; i++) {
				tempArray[i] = temp.substring(j,j+3);
				j = j+3;
			}
			return tempArray;
		}
	}
	@SuppressWarnings("null")
	public void normalSkillSet(Integer entityNumber){//3글자씩 자른 스킬넘버를 기준으로 스킬 객체 생성하여 리스트에 저장
		String[] temp = normalSkillSub();
		List<Skill> skillTemp = new ArrayList<Skill>();
		for(String i : temp) {
			System.out.println(i);
			Skill tempSkill = new Skill();
			tempSkill =	sqlSession.selectOne("mappers.myMapper.selectNormalSkill",i);
			skillTemp.add(tempSkill);
		}
		this.normalSkills = skillTemp;
	}
	@SuppressWarnings("null")
	public void typeSkillSet(Integer entityNumber){//3글자씩 자른 스킬넘버를 기준으로 스킬 객체 생성하여 리스트에 저장
		String[] temp = typeSkillSub();
		List<Skill> skillTemp = new ArrayList<Skill>();
		for(String i : temp) {
			System.out.println(i);
			Skill tempSkill = new Skill();
			tempSkill =	sqlSession.selectOne("mappers.myMapper.selectTypeSkill",i);
			skillTemp.add(tempSkill);
		}
		this.typeSkills = skillTemp;
	}
	
	public void skillSet(Integer entityNumber) {//개체를 생성한 다음에 반드시 1번씩 실행
		normalSkillSet(entityNumber); 
		typeSkillSet(entityNumber);
	}
	
	/**포켓몬 개체 전투 관련 메소드**/
	public Integer attack(Skill skill, PokemonEntity enemy) {//skill 객체를 받아서 공격 데미지 리턴
		double damage = 0; double typeResult=1;
		int temp = skill.getSkillAttackPoint();
		
		typeResult = typeVs(skill, enemy);
		
		if(temp == 0) {
			return 0;
		} else {
			if(skill.getSkillType2() == 1) {
				double d = (double)this.EntityPhysicalAttack / (double)enemy.EntityPhysicalDefense;
				damage =  d * skill.getSkillPower() ;
			} else {
				double d = (double)this.EntityTypeAttack / (double)enemy.EntityTypeDefense;
				damage =  d * skill.getSkillPower() ;
			}
			//사용 횟수 1 감소
			skill.setSkillAttackPoint(temp-1);
		}
		
		damage = damage * typeResult;
		
		return (int)damage;
	}
	
	public double typeVs(Skill skill, PokemonEntity enemy) {// 타입 상성 계산
		double typeResult=1;
		
		String skillType = skill.getSkillType();
		String enemyType = enemy.typeOne;
		
		System.out.println(skillType + " , " + enemyType);
		
		int temp = 0; int temp1 = 0; int j = 0;
		
		typeVs = new TypeVs();
		
		for(String i : typeVs.type) {
			if(i.equals(skillType)) {
				temp = j;
			}
			if(i.equals(enemyType)) {
				temp1 = j;
			}
			j++;
		}
		
		System.out.println("공격 스킬타입 인덱스" + temp + "적 타입 인덱스" + temp1);
		
		typeResult = typeVs.vs[temp][temp1];
		
		return typeResult;
	}
	
	public Integer healthDecrease(Skill skill, Integer damage) {//데미지 입력 받아서 체력 감소
//		if(skill.getSkillType2() == 1) {
//			damage = damage - EntityPhysicalDefense;
//			if(damage <= 0) {
//				damage = 0;
//			} 
//		} else {
//			damage = damage - EntityTypeDefense;
//			if(damage <= 0) {
//				damage = 0;
//			}
//		}
		
		int temp = damage;
		
		this.EntityHealth =  this.EntityHealth - temp;
		
		return temp;
	}

	
	/**getter setter**/
	public Integer getEntityNumber() {
		return entityNumber;
	}

	public void setEntityNumber(Integer entityNumber) {
		this.entityNumber = entityNumber;
	}

	public String getUserInfoId() {
		return userInfo_Id;
	}

	public void setUserInfoId(String userInfoId) {
		this.userInfo_Id = userInfoId;
	}

	public Integer getPokemonVarietyVarietyNumber() {
		return pokemon_Variety_VarietyNumber;
	}

	public void setPokemonVarietyVarietyNumber(Integer pokemonVarietyVarietyNumber) {
		this.pokemon_Variety_VarietyNumber = pokemonVarietyVarietyNumber;
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
		return EvolutionLevel;
	}

	public void setEvolutionLevel(Integer evolutionLevel) {
		EvolutionLevel = evolutionLevel;
	}

	public Integer getEntityPhysicalAttack() {
		return EntityPhysicalAttack;
	}

	public void setEntityPhysicalAttack(Integer entityPhysicalAttack) {
		EntityPhysicalAttack = entityPhysicalAttack;
	}

	public Integer getEntityPhysicalDefense() {
		return EntityPhysicalDefense;
	}

	public void setEntityPhysicalDefense(Integer entityPhysicalDefense) {
		EntityPhysicalDefense = entityPhysicalDefense;
	}

	public Integer getEntitySpeed() {
		return EntitySpeed;
	}

	public void setEntitySpeed(Integer entitySpeed) {
		EntitySpeed = entitySpeed;
	}

	public Integer getEntityHealth() {
		return EntityHealth;
	}

	public void setEntityHealth(Integer entityHealth) {
		EntityHealth = entityHealth;
	}

	public Integer getEntityTotal() {
		return EntityTotal;
	}

	public void setEntityTotal(Integer entityTotal) {
		EntityTotal = entityTotal;
	}

	public String getNormalSkill() {
		return NormalSkill;
	}

	public void setNormalSkill(String normalSkill) {
		NormalSkill = normalSkill;
	}

	public String getTypeSkill() {
		return TypeSkill;
	}

	public void setTypeSkill(String typeSkill) {
		TypeSkill = typeSkill;
	}

	public String getImageRoot() {
		return ImageRoot;
	}

	public void setImageRoot(String imageRoot) {
		ImageRoot = imageRoot;
	}

	public String getCharacter() {
		return Character;
	}

	public void setCharacter(String character) {
		Character = character;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public List<Skill> getNormalSkills() {
		return normalSkills;
	}
	public void setNormalSkills(List<Skill> normalSkills) {
		this.normalSkills = normalSkills;
	}
	public List<Skill> getTypeSkills() {
		return typeSkills;
	}
	public void setTypeSkills(List<Skill> typeSkills) {
		this.typeSkills = typeSkills;
	}
	public Integer getEntityTypeAttack() {
		return EntityTypeAttack;
	}
	public void setEntityTypeAttack(Integer entityTypeAttack) {
		EntityTypeAttack = entityTypeAttack;
	}
	public Integer getEntityTypeDefense() {
		return EntityTypeDefense;
	}
	public void setEntityTypeDefense(Integer entityTypeDefense) {
		EntityTypeDefense = entityTypeDefense;
	}
	public String getUserInfo_Id() {
		return userInfo_Id;
	}
	public void setUserInfo_Id(String userInfo_Id) {
		this.userInfo_Id = userInfo_Id;
	}
	public Integer getPokemon_Variety_VarietyNumber() {
		return pokemon_Variety_VarietyNumber;
	}
	public void setPokemon_Variety_VarietyNumber(Integer pokemon_Variety_VarietyNumber) {
		this.pokemon_Variety_VarietyNumber = pokemon_Variety_VarietyNumber;
	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
