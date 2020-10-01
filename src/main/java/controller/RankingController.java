package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.PokeEntityDao;
import dao.RankDao;
import dao.UserInfoDao;
import model.Rank;
import newModel.PokemonEntity;

@Controller
public class RankingController {
	@Autowired
	private RankDao rankDao;
	@Autowired
	private PokeEntityDao pokeEntityDao;
	@Autowired
	private UserInfoDao userInfoDao;
	
	@RequestMapping(value="/ranking/rankingList.html",method=RequestMethod.GET)
	public ModelAndView rankingList() {
		
		ModelAndView mav = new ModelAndView("home/template");
		
		List<Rank> rankingList =  rankDao.rankingList();
		
		for(Rank i: rankingList) {
			i.setDeckList(pokeEntityDao.deckList(i.getUserinfo_id()));
		}
		
		mav.addObject("rankingList",rankingList);
		mav.addObject("BODY","rankingList.jsp");
		
		return mav;
	}
}
