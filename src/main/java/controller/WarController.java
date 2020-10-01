package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.RankDao;
import logic.Couple;
import logic.WarCatalogImpl;
import newModel.PokemonEntity;
import newModel.UserInfo;

@Controller
public class WarController {
	
	@Autowired
	private RankDao rankDao;
	
	@RequestMapping(value = "/war/warPlayerPlay.html", method = RequestMethod.GET)
	public ModelAndView warPlayerPlay(String vsId,HttpSession session) {
		
		String userId = (String) session.getAttribute("loginUser");
		
		if(userId == null) {//로그인 하지 않은 경우
			ModelAndView mav = new ModelAndView("redirect:/war/login.html");
			mav.addObject("RESULT","nowar");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("vsId", vsId);
		mav.addObject("BODY", "warPlayerPlay.jsp");
		return mav;
	}

	@RequestMapping(value = "/war/warSelect.html", method = RequestMethod.GET)
	public ModelAndView warSelect() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY", "warSelect.jsp");
		return mav;
	}

	@RequestMapping(value = "/war/warAiList.html", method = RequestMethod.GET)
	public ModelAndView warAiList() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY", "warAiList.jsp");
		return mav;
	}

	@RequestMapping(value = "/war/warAiPlay.html", method = RequestMethod.GET)
	public ModelAndView warAiPlay(Integer level,HttpSession session) {
		
		String userId = (String) session.getAttribute("loginUser");
		
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("level", level);
		mav.addObject("BODY", "warAiPlay.jsp");
		return mav;
	}
	
	@RequestMapping(value="/war/login.html", method=RequestMethod.GET)
	public ModelAndView open() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("RESULT","nowar");
		mav.addObject(new UserInfo());
		mav.addObject("BODY","nologin.jsp");
		return mav;
	}
	
	@RequestMapping(value="/war/deckLogin.html", method=RequestMethod.GET)
	public ModelAndView deckOpen() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new UserInfo());
		mav.addObject("RESULT","nodeck");
		mav.addObject("BODY","nologin.jsp");
		return mav;
	}

	@RequestMapping(value = "/war/warStart.html", method = RequestMethod.GET)
	public ModelAndView warStart(Integer level,HttpSession session) {
		
		String ai = String.valueOf(level);
		String userId = (String) session.getAttribute("loginUser");
		
		if(userId == null) {//로그인 하지 않은 경우
			ModelAndView mav = new ModelAndView("redirect:/war/login.html");
			mav.addObject("RESULT","nowar");
			return mav;
		}
		
		String vsId = "lion"; // ai 대전 상대
		
		WarCatalogImpl war =  new WarCatalogImpl();
		List<String> warLog = new ArrayList<String>();
		Integer rank = rankDao.selectRating(userId); //레이팅 존재 여부 확인
		warLog = war.warPlay(userId, vsId, rankDao); //대전 결과 출력 및 저장
		//승패와 관계 없이 랭크 테이블 인설트, 단 랭킹 테이블에 아이디 없을 때만
		if(rank==0) {
			rankDao.insertRank(userId);
		}
		
		ModelAndView mav = new ModelAndView();
		mav = inform(war, userId, vsId, warLog);
		
		return mav;
	}
	
	@RequestMapping(value = "/war/warVsStart.html", method = RequestMethod.GET)
	public ModelAndView warStart(String vsId,HttpSession session) {
		
		String userId = (String) session.getAttribute("loginUser");
		
		if(userId == null) {//로그인 하지 않은 경우
			ModelAndView mav = new ModelAndView("redirect:/war/login.html");
			mav.addObject("RESULT","nowar");
			return mav;
		}
		
		WarCatalogImpl war =  new WarCatalogImpl();
		List<String> warLog = new ArrayList<String>();
		Integer rank = rankDao.selectRating(userId); //레이팅 존재 여부 확인
		
		if(rank==0) {//레이팅이 없으면 대전 선택 화면 창으로 이동
			ModelAndView mav = new ModelAndView("redirect:/war/warSelect.html");
			return mav;
		}
		
		warLog = war.warPlay(userId, vsId, rankDao);
		
		ModelAndView mav = new ModelAndView();
		mav = inform(war, userId, vsId, warLog);
		
		return mav;
	}
	
	public ModelAndView inform(WarCatalogImpl war, String userId, String vsId, List<String> warLog) {
		
		warLog = war.warPlay(userId, vsId, rankDao);
		
		Couple couple = war.couple;
		PokemonEntity red = couple.red; PokemonEntity blue = couple.blue;
		
		List<String> redInfo = new ArrayList<String>();
		List<String> blueInfo = new ArrayList<String>();
		String redId = red.getPokemonName(); String blueId = blue.getPokemonName();
		int redNumber = red.getPokemon_Variety_VarietyNumber(); int blueNumber = blue.getPokemon_Variety_VarietyNumber();
		
		redInfo.add("속성1: " + red.getTypeOne());
		redInfo.add("속성2: " +red.getTypeTwo());
		redInfo.add("체력: " +String.valueOf(red.getEntityHealth()));
		redInfo.add("물공: " +String.valueOf(red.getEntityPhysicalAttack()));
		redInfo.add("물방: " +String.valueOf(red.getEntityPhysicalDefense()));
		redInfo.add("특공: " +String.valueOf(red.getEntityTypeAttack()));
		redInfo.add("특방: " +String.valueOf(red.getEntityTypeDefense()));
		redInfo.add("스피드: " +String.valueOf(red.getEntitySpeed()));
		
		blueInfo.add("속성1: " + blue.getTypeOne());
		blueInfo.add("속성2: " +blue.getTypeTwo());
		blueInfo.add("체력: " +String.valueOf(blue.getEntityHealth()));
		blueInfo.add("물공: " +String.valueOf(blue.getEntityPhysicalAttack()));
		blueInfo.add("물방: " +String.valueOf(blue.getEntityPhysicalDefense()));
		blueInfo.add("특공: " +String.valueOf(blue.getEntityTypeAttack()));
		blueInfo.add("특방: " +String.valueOf(blue.getEntityTypeDefense()));
		blueInfo.add("스피드: " +String.valueOf(blue.getEntitySpeed()));
		
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("redId", redId); mav.addObject("blueId", blueId);
		mav.addObject("redInfo", redInfo); mav.addObject("blueInfo", blueInfo);
		mav.addObject("redNumber",redNumber ); mav.addObject("blueNumber",blueNumber);
		mav.addObject("vsId", vsId);
		mav.addObject("BODY", "warPlayerPlay.jsp");
		mav.addObject("warLog",warLog);
		
		return mav;
	}

}
