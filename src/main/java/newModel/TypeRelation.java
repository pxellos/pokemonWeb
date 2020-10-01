package newModel;

import org.hibernate.validator.constraints.NotEmpty;

public class TypeRelation {
	@NotEmpty
	private String typeType;
	private Integer normal;
	private Integer fire;
	private Integer water;
	private Integer plant;
	private Integer thunder;
	private Integer ice;
	private Integer fighter;
	private Integer poison;
	private Integer earth;
	private Integer fly;
	private Integer esper;
	private Integer insect;
	private Integer rock;
	private Integer ghost;
	private Integer dragon;
	private Integer evil;
	private Integer steel;
	private Integer fairy;
	public String getTypeType() {
		return typeType;
	}
	public void setTypeType(String typeType) {
		this.typeType = typeType;
	}
	public Integer getNormal() {
		return normal;
	}
	public void setNormal(Integer normal) {
		this.normal = normal;
	}
	public Integer getFire() {
		return fire;
	}
	public void setFire(Integer fire) {
		this.fire = fire;
	}
	public Integer getWater() {
		return water;
	}
	public void setWater(Integer water) {
		this.water = water;
	}
	public Integer getPlant() {
		return plant;
	}
	public void setPlant(Integer plant) {
		this.plant = plant;
	}
	public Integer getThunder() {
		return thunder;
	}
	public void setThunder(Integer thunder) {
		this.thunder = thunder;
	}
	public Integer getIce() {
		return ice;
	}
	public void setIce(Integer ice) {
		this.ice = ice;
	}
	public Integer getFighter() {
		return fighter;
	}
	public void setFighter(Integer fighter) {
		this.fighter = fighter;
	}
	public Integer getPoison() {
		return poison;
	}
	public void setPoison(Integer poison) {
		this.poison = poison;
	}
	public Integer getEarth() {
		return earth;
	}
	public void setEarth(Integer earth) {
		this.earth = earth;
	}
	public Integer getFly() {
		return fly;
	}
	public void setFly(Integer fly) {
		this.fly = fly;
	}
	public Integer getEsper() {
		return esper;
	}
	public void setEsper(Integer esper) {
		this.esper = esper;
	}
	public Integer getInsect() {
		return insect;
	}
	public void setInsect(Integer insect) {
		this.insect = insect;
	}
	public Integer getRock() {
		return rock;
	}
	public void setRock(Integer rock) {
		this.rock = rock;
	}
	public Integer getGhost() {
		return ghost;
	}
	public void setGhost(Integer ghost) {
		this.ghost = ghost;
	}
	public Integer getDragon() {
		return dragon;
	}
	public void setDragon(Integer dragon) {
		this.dragon = dragon;
	}
	public Integer getEvil() {
		return evil;
	}
	public void setEvil(Integer evil) {
		this.evil = evil;
	}
	public Integer getSteel() {
		return steel;
	}
	public void setSteel(Integer steel) {
		this.steel = steel;
	}
	public Integer getFairy() {
		return fairy;
	}
	public void setFairy(Integer fairy) {
		this.fairy = fairy;
	}
	
}
