package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.PokeEntityDao;
import dao.PokeVarietyDao;
import logic.LoginCatalog;
import newModel.PokemonEntity;
import newModel.PokemonVariety;
import newModel.UserInfo;

@Controller
public class EntryController {
	@Autowired
	private LoginCatalog loginCatalog;
	@Autowired
	private PokeEntityDao pokeDao;
	@Autowired
	private PokeVarietyDao pokeV;
	
//	@RequestMapping(value="/entry/entry.html",
//			method=RequestMethod.POST)
//	public ModelAndView entry(User user, HttpSession session) {
//		this.loginCatalog.entryUser(user);//DB에 저장
//		ModelAndView mav = new ModelAndView("home/template");
//		session.setAttribute("loginUser", user.getId());
//		mav.addObject("BODY","loginResult.jsp");
//		return mav;
//	}
	
	@RequestMapping(value="/entry/entry.html",method=RequestMethod.POST)
	public ModelAndView entry(UserInfo user, HttpSession session) {
		this.loginCatalog.entryUser(user);	//DB에 저장
		
		//포켓몬 랜덤으로 하나 등록
		Integer code, count;
		code = (int)((Math.random()*151) + 1) ; 
		PokemonVariety pokeOld = new PokemonVariety();
	    pokeOld = pokeV.selectValue(code);	    
	    PokemonEntity pokeNew = new PokemonEntity();
        count = pokeDao.count()+1;
        pokeNew = pokeOld.insertEntity(pokeNew, count , user.getId(), code); //개체 맥스 카운트 찾아서 입
        pokeDao.pokeNew(pokeNew);
		
		ModelAndView mav = new ModelAndView("home/template");
		session.setAttribute("loginUser", user.getId());
		mav.addObject("BODY","loginResult.jsp");
		return mav;
	}
}












