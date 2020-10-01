package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.WishCart;
import newModel.WishItem;
@Repository
public class WishDaoImpl implements WishDao {
	@Autowired
	private SqlSession session;
		
	public void insertCart(WishItem cartItem) {
		session.insert("mappers.myMapper.insertCart",cartItem);
	}
	public void deleteCart(WishItem cartItem) {
		session.delete("mappers.myMapper.deleteCart",cartItem);
	}
	public void updateCart(WishItem cartItem) {
		session.update("mappers.myMapper.insertCart",cartItem);
	}
	public Integer selectMaxCart() {
		return session.selectOne("mappers.myMapper.selectMaxCart");
	}
	public List<WishItem> selectCart(String id) {
		return session.selectList("mappers.myMapper.selectCart",id);
	}
	public void deleteWish(WishCart wish) {
		session.delete("mappers.myMapper.deleteWish", wish);
	}
	public SqlSession getSession() {
		return session;
	}
	public void setSession(SqlSession session) {
		this.session = session;
	}
	

}
