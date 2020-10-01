package controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.RankDao;
import dao.UserInfoDao;
import model.Rank;
import newModel.UserInfo;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private RankDao rankDao;
	@RequestMapping(value="/home/userinfo.html",
			method=RequestMethod.GET)
	public ModelAndView entryForm(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("home/template");
//	UserInfo userInfo =  userInfoDao.user("${sessionScope.loginUser }");
		String id = (String) session.getAttribute("loginUser");
		UserInfo userInfo =  userInfoDao.user(id);
		Rank rank = rankDao.playerRank(id);	

		mav.addObject("playerRank", rank);
		mav.addObject("userInfo",userInfo);
//		mav.addObject(new UserInfo());
		mav.addObject("BODY","userInfo.jsp");
		return mav;
	}
	@RequestMapping(value="/userInfo/charge.html",
			method=RequestMethod.GET)
	public ModelAndView charge(HttpSession session) {
		String id = (String) session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY","chargeMoney.jsp");
		mav.addObject(new UserInfo());
		return mav;
	}
	

	@RequestMapping(value="/userInfo/getGold.html",
			method=RequestMethod.POST)
	public ModelAndView chargeSuccess(UserInfo userinfo, HttpSession session) {
		this.userInfoDao.chargeGold(userinfo);
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY","chargeSuccess.jsp");
		return mav;
	}
}
