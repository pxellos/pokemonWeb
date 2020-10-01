package newModel;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WishDao;
@Service
public class Wish {
   @Autowired
   private WishDao wishDao;
   
   private LinkedList<String> codeList = new LinkedList<String>();	//상품코드
   private LinkedList<Integer> numList = new LinkedList<Integer>();	//상품갯수
   
   private void insertCart(String code, int num, String id) {
	   Integer seqno = wishDao.selectMaxCart();
	   if(seqno == null) seqno = 0;
	   WishItem wishItem = new WishItem();
	   wishItem.setSeqno(seqno + 1);	//일련번호
	   wishItem.setCode(code);
	   wishItem.setNum(num);
	   wishItem.setId(id);
	   wishDao.insertCart(wishItem);	//DB에 Insert
   }
   
   private void updateCart(String code,int num, String id) {
	   WishItem wishItem = new WishItem();
	   wishItem.setCode(code);
	   wishItem.setNum(num);
	   wishItem.setId(id);
	   wishDao.updateCart(wishItem);	//DB를 update
   }
   
   public void modifyItem(String code, int num, String id) {
	   for(int i = 0; i < codeList.size(); i++) {
		   if(codeList.get(i).equals(code)) {
			   numList.set(i, num);	//갯수변경
			   updateCart(code,num,id);	//DB에서도 변경
		   }
	   }
   }
   
   public void deleteItem(String code, String id) {
	   for(int i = 0; i < codeList.size(); i++) {
		   if(codeList.get(i).equals(code)) {
			   codeList.remove(i);  //해당 상품을 장바구니에서 삭제
			   numList.remove(i);	//해당 상품의 갯수를 장바구니에서 삭제
			   WishItem wishItem = new WishItem();
			   wishItem.setCode(code);
			   wishItem.setId(id);
			   wishDao.deleteCart(wishItem); //DB에서 delete
			   return;	//메소드 종료
		   }	//삭제할 상품을 찾은 경우
	   }
   }
   
   	public void addWish(String code, int num, String id) {
   		for(int i = 0; i < codeList.size(); i++) {
   			if(codeList.get(i).equals(code)) {
   				numList.set(i, numList.get(i)+1);//갯수를 1증가
   				updateCart(code, numList.get(i), id);//DB에서 변경
   				return;
   			}	//상품코드가 일치하는 경우
   		}	//동일한 상품이 이미 장바구니에 있는지 검사
   		codeList.add(code);
   		numList.add(num);
   		insertCart(code, num, id); //DB에 삽입
   	}//장바구니에 상품을 담는다.ㅏ
   
   	public List<WishItem> getWish(String id){
   		return this.wishDao.selectCart(id);
   	}
   	
   	public int getNum(int i) {
   		return numList.get(i);
   	}

	public void setCodeList(int index, String code) {
		this.codeList.add(index,code);
	}
	
	public void setNumList(int index, Integer num) {
		this.numList.add(index,num);
	}
   	
   	
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
//   private LinkedList<String> codeList = new LinkedList<String>();//상품코드
//   private LinkedList<Integer> numList = new LinkedList<Integer>();//상품갯수
//   
//   private void insertCart(String code,int num,String id) {
//      Integer seqno = pokeCartDao.selectMaxCart();
//      if(seqno == null) seqno = 0;
//      WishItem cartItem = new WishItem();
//      cartItem.setSeqno(seqno + 1);//일련번호
//      cartItem.setCode(code);   cartItem.setNum(num);
//      cartItem.setUserInfoId(id);
//      pokeCartDao.insertCart(cartItem);//DB에 insert
//   }
//   
//   private void updateCart(String code,int num,String id) {
//      WishItem cartItem = new WishItem();
//      cartItem.setCode(code);      cartItem.setNum(num);
//      cartItem.setUserInfoId(id);
//      pokeCartDao.updateCart(cartItem);//DB를 update
//   }
//   public void modifyItem(String code,int num,String id) {
//      for(int i=0;i<codeList.size(); i++) {
//         if(codeList.get(i).equals(code)) {
//            numList.set(i, num);//갯수 변경
//            updateCart(code,num,id);//DB에서도 변경
//         }
//      }
//   }
//   
//   public void deleteItem(String code, String id) {
//      for(int i=0; i<codeList.size(); i++) {
//         if(codeList.get(i).equals(code)) {
//            codeList.remove(i);//해당 상품을 장바구니에서 삭제
//            numList.remove(i);//해당 상품의 갯수를 장바구니에서 삭제
//            WishItem cartItem = new WishItem();
//            cartItem.setCode(code); cartItem.setUserInfoId(id);
//            pokeCartDao.deleteCart(cartItem);//DB에서 delete
//            return;//메서드 종료
//         }//삭제할 상품을 찾은 경우
//      }
//   }
//   
//   public void addCart(String code,int num,String id) {
//      for(int i=0; i<codeList.size(); i++) {
//         if(codeList.get(i).equals(code)) {
//            numList.set(i, numList.get(i)+1);//갯수를 1증가
//            updateCart(code,numList.get(i),id);//DB에서 변경
//            return;
//         }//상품코드가 일치하는 경우
//      }//동일한 상품이 이미 장바구니에 있는지 검사
//      codeList.add(code);   numList.add(num);
//      insertCart(code,num,id);//DB에 삽입
//   }//장바구니에 상품을 담는다.
//   
//
//   public int getSize() {
//      return codeList.size();
//   }
//   
//   public List<WishItem> getCart(String id){
//      return this.pokeCartDao.selectCart(id);
//   }
//   public int getNum(int i) {
//      return numList.get(i);
//   }
//   public void setCodeList(int index, String code) {
//      this.codeList.add(index,code);
//   }
//   public void setNumList(int index,Integer num) {
//      this.numList.add(index,num);
//   }
//}

}





