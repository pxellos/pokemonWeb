package dao;

import java.util.List;

import model.WishCart;
import newModel.WishItem;

public interface WishDao {
	void insertCart(WishItem cartItem);//삽입
	void deleteCart(WishItem cartItem);//삭제
	void updateCart(WishItem cartItem);//변경
	Integer selectMaxCart();//가장 큰 일련번호
	List<WishItem> selectCart(String id);//지정된 ID의 상품목록
	
	void deleteWish(WishCart wish);
}
