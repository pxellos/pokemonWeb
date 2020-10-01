package newModel;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Trade {
	@NotEmpty
	private Integer tradeNumber;
	@NotEmpty
	private String userInfoId;
	@NotEmpty
	private Integer pokemonEntityEntityNumber;
	private Integer tradeGroupNumber;
	private Integer tradeParentNumber;
	private Integer tradePrintNumber;
	private String tradeDate;
	private Integer tradePrice;
	private String tradeDescript;
	private String tradeImageRoot;
	private String tradeResult;
	private MultipartFile image;
	public Integer getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(Integer tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public Integer getPokemonEntityEntityNumber() {
		return pokemonEntityEntityNumber;
	}
	public void setPokemonEntityEntityNumber(Integer pokemonEntityEntityNumber) {
		this.pokemonEntityEntityNumber = pokemonEntityEntityNumber;
	}
	public Integer getTradeGroupNumber() {
		return tradeGroupNumber;
	}
	public void setTradeGroupNumber(Integer tradeGroupNumber) {
		this.tradeGroupNumber = tradeGroupNumber;
	}
	public Integer getTradeParentNumber() {
		return tradeParentNumber;
	}
	public void setTradeParentNumber(Integer tradeParentNumber) {
		this.tradeParentNumber = tradeParentNumber;
	}
	public Integer getTradePrintNumber() {
		return tradePrintNumber;
	}
	public void setTradePrintNumber(Integer tradePrintNumber) {
		this.tradePrintNumber = tradePrintNumber;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public Integer getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(Integer tradePrice) {
		this.tradePrice = tradePrice;
	}
	public String getTradeDescript() {
		return tradeDescript;
	}
	public void setTradeDescript(String tradeDescript) {
		this.tradeDescript = tradeDescript;
	}
	public String getTradeImageRoot() {
		return tradeImageRoot;
	}
	public void setTradeImageRoot(String tradeImageRoot) {
		this.tradeImageRoot = tradeImageRoot;
	}
	public String getTradeResult() {
		return tradeResult;
	}
	public void setTradeResult(String tradeResult) {
		this.tradeResult = tradeResult;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	  
}
