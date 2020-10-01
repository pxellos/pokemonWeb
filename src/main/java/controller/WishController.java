package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import newModel.UserInfo;
import newModel.Wish;
import newModel.WishItem;

@Controller
public class WishController {
	@Autowired
	private Wish wish;
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping(value="/wish/show.html",
			method=RequestMethod.GET)
	public ModelAndView showWish(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/template");
		String id = (String)session.getAttribute("loginUser");
		if(id == null) return mav;//로그인을 하지 않은 경우
		List<WishItem> wishList = wish.getWish(id); //DB에서 검색
		int totalAmount = 0;
		if(wishList.size() > 0) {//장바구니에 상품이 존재하는 경우
			Iterator it = wishList.iterator();
			while(it.hasNext()) {
				WishItem wishItem = (WishItem)it.next();
				int total = wishItem.getPrice()* wishItem.getNum();
				totalAmount = totalAmount + total;//합계 누적
			}
			mav.addObject("SIZE","YES");
			
		}else {//장바구니에 상품이 없는 경우
			mav.addObject("SIZE","NO");
		}
		mav.addObject("totalAmount",totalAmount);
		mav.addObject("BODY","cartListView.jsp");
		mav.addObject("CART_LIST",wishList);
		
		return mav;
	}
	
	@RequestMapping(value="/wish/login.html",
			method=RequestMethod.POST)
	public ModelAndView login(@Valid UserInfo user,
		BindingResult bindingResult,HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/cartLogin");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/loginResult");
		String password = loginDao.getPassword(user.getId());
		if( ! user.getPassword().equals(password)) {
			mav.addObject("cartlogin","YES");
			return mav;
		}else {
			mav.addObject("cartlogin","SUCCESS");
			session.setAttribute("loginUser", user.getId());
			List<WishItem> wishList=wish.getWish(user.getId());
			if(wishList != null) {//장바구니 정보가 존재하는 경우
				Iterator it = wishList.iterator();
				int i=0;
				while(it.hasNext()) {
					WishItem ci = (WishItem)it.next();
					this.wish.setCodeList(i, ci.getCode());
					this.wish.setNumList(i, ci.getNum());
					i++;
				}
				session.setAttribute("CART", this.wish);
			}
		}
		return mav;
	}
	@RequestMapping(value="/wish/login.html",
			method=RequestMethod.GET)
	public ModelAndView open() {
		ModelAndView mav = new ModelAndView("home/cartLogin");
		mav.addObject("RESULT","nologin");
		mav.addObject(new UserInfo());
		return mav;
	}
	
	@RequestMapping(value="/wish/addCart.html", method=RequestMethod.GET)
	public ModelAndView addCart(String CODE,HttpSession session) {
		String id=(String)session.getAttribute("loginUser");
		if(id == null) {//로그인 하지 않은 경우
			ModelAndView mav = new ModelAndView(
				"redirect:/wish/login.html");
			mav.addObject("RESULT","nologin");
			return mav;
		}
		Wish wish = (Wish)session.getAttribute("CART");
		if(wish == null) wish = this.wish;//세션에 카트가 없으면 생성
		wish.addWish(CODE, 1, id);
		session.setAttribute("CART", wish);//카트를 세션에 저장
		ModelAndView mav = new ModelAndView("home/addCartResult");
		mav.addObject("ITEM_NUM",1);
		return mav;
	}
}














