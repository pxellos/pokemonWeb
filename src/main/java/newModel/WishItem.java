package newModel;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class WishItem {
	@NotEmpty
	private String id; // 구매자 ID
	private Integer pokemonVarietyVarietyNumber;
	private String pokemonName; // 포켓몬이름
	private String imageRoot;
	private Integer price; // 포켓몬 가격
	private Integer varietyTotal;
	private MultipartFile image;
	private Integer seqno; // 포켓몬 일련번호
	private Integer num; // 포켓몬 마릿수
	private String code; // 포켓몬 번호
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPokemonVarietyVarietyNumber() {
		return pokemonVarietyVarietyNumber;
	}
	public void setPokemonVarietyVarietyNumber(Integer pokemonVarietyVarietyNumber) {
		this.pokemonVarietyVarietyNumber = pokemonVarietyVarietyNumber;
	}
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public String getImageRoot() {
		return imageRoot;
	}
	public void setImageRoot(String imageRoot) {
		this.imageRoot = imageRoot;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getVarietyTotal() {
		return varietyTotal;
	}
	public void setVarietyTotal(Integer varietyTotal) {
		this.varietyTotal = varietyTotal;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}