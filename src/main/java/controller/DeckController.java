package controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.PokemonEntityDao;
import newModel.PokemonEntity;

@Controller
public class DeckController {
	@Autowired
	private PokemonEntityDao pokemonEntityDao;
	@RequestMapping(value="/home/deck.html",
			method=RequestMethod.GET)
	public ModelAndView entryForm(HttpSession session) {
		
		String userId = (String) session.getAttribute("loginUser");
		
		if(userId == null) {//로그인 하지 않은 경우
			ModelAndView mav = new ModelAndView("redirect:/war/deckLogin.html");
			mav.addObject("RESULT","nodeck");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("home/template");
//	UserInfo userInfo =  userInfoDao.user("${sessionScope.loginUser }");
		String id = (String) session.getAttribute("loginUser");
		List<PokemonEntity> pokemonEntityList = pokemonEntityDao.pokemonentityList(id);
//		PokemonEntity pokemonEntity = pokemonEntityDao.pokemonentity(id);
		mav.addObject("pokemonEntityList",pokemonEntityList);
		mav.addObject("BODY","deck.jsp");
		return mav;
	}
	
	@RequestMapping(value="/deck/delete.html",
	         method=RequestMethod.GET)
	   public ModelAndView delete(HttpServletRequest request, HttpSession session) {
	      String id = (String) session.getAttribute("loginUser");
	      String name = request.getParameter("pokemonname");
	      Integer number = Integer.parseInt(name);
	      System.out.println(number);
	      PokemonEntity pokemonEntity = new PokemonEntity();
	      pokemonEntity.setUserInfo_Id(id);
	      pokemonEntity.setPokemon_Variety_VarietyNumber(number);
	      pokemonEntityDao.deleteDeck(pokemonEntity);
	      ModelAndView mav = new ModelAndView("home/template");
	      mav.addObject("BODY","deleteSuccess.jsp");
	      return mav;
	   }
}
