package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.PokeEntityDao;
import dao.PokeVarietyDao;
import dao.UserInfoDao;
import dao.WishDao;
import dao.WishDaoImpl;
import model.WishCart;
import newModel.PokemonEntity;
import newModel.PokemonVariety;
import newModel.UserInfo;
import newModel.Wish;
import newModel.WishItem;

@Controller
public class PurchaseController {
   @Autowired
   private WishDao wishDao;
   @Autowired
   private PokeEntityDao pokeDao;
   @Autowired
   private PokeVarietyDao pokeV;
   @Autowired
   private UserInfoDao userInfoDao;
   
   @RequestMapping(value="/purchase/purchaseSuccess.html", method = RequestMethod.GET)
   ModelAndView purchaseSuccess(HttpServletRequest request, HttpSession session) {
      
      String id;
      String number; Integer code, count;
      number = request.getParameter("number");
      code = Integer.valueOf(number);
      id = (String) session.getAttribute("loginUser");
            
      //2. 개체 생성 (덱에 이동 )
      PokemonVariety pokeOld = new PokemonVariety();
      pokeOld = pokeV.selectValue(code);
      System.out.println(code);
   
      
      //3. 포인트 차감 필요
      UserInfo userInfo = new UserInfo();
      int price = pokeOld.getPrice();
      System.out.println(price);
      userInfo.setId(id);
      int pocketMoney = userInfoDao.getMoney(userInfo);
      System.out.println(userInfoDao.getMoney(userInfo));
      if(pocketMoney>=price) {
         userInfo.setUserGold(pocketMoney-price);
         userInfoDao.deduct(userInfo);
         
         //1. 장바구니 삭제 
         WishCart wish = new WishCart();
         wish.setCode(code); wish.setId(id);
         wishDao.deleteWish(wish);
         
         PokemonEntity pokeNew = new PokemonEntity();
         count = pokeDao.count()+1;
         System.out.println(count);
         pokeNew = pokeOld.insertEntity(pokeNew, count , id, code); //개체 맥스 카운트 찾아서 입
         pokeDao.pokeNew(pokeNew);
         
         
      }
      else {
         ModelAndView mav= new ModelAndView("home/purchaseFail");
         return mav;

      }
      
      ModelAndView mav = new ModelAndView("home/purchaseSuccess");
      
      return mav;
      
   }
}