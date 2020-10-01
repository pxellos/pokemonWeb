package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.PokemonCatalog;
import newModel.PokemonVariety;

@Controller
public class PokemonController {
	@Autowired
	private PokemonCatalog pokemonCatalog;
	
	// 포켓몬 도감(능력치)
	@RequestMapping(value = "/pokemon/pokemonList.html", method = RequestMethod.GET)
	public ModelAndView readPokemons() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList",pokemonList);
		mav.addObject("BODY","pokemonListView.jsp");
		return mav;
	}
	
	// 포켓몬 도감(썸네일)
	@RequestMapping(value = "/pokemon/pokemonList2.html", method = RequestMethod.GET)
	public ModelAndView readPokemons2() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList",pokemonList);
		mav.addObject("BODY","pokemonListView2.jsp");
		return mav;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "/pokemon/pokemonList100.html", method = RequestMethod.GET)
	public ModelAndView readPokemons100() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons100();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList100",pokemonList);
		mav.addObject("BODY","pokemonListView100.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList01.html", method = RequestMethod.GET)
	public ModelAndView readPokemons01() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons1();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList01",pokemonList);
		mav.addObject("BODY","pokemonListView01.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList02.html", method = RequestMethod.GET)
	public ModelAndView readPokemons02() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons2();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList02",pokemonList);
		mav.addObject("BODY","pokemonListView02.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList03.html", method = RequestMethod.GET)
	public ModelAndView readPokemons03() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons3();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList03",pokemonList);
		mav.addObject("BODY","pokemonListView03.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList04.html", method = RequestMethod.GET)
	public ModelAndView readPokemons04() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons4();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList04",pokemonList);
		mav.addObject("BODY","pokemonListView04.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList05.html", method = RequestMethod.GET)
	public ModelAndView readPokemons05() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons5();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList05",pokemonList);
		mav.addObject("BODY","pokemonListView05.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList06.html", method = RequestMethod.GET)
	public ModelAndView readPokemons06() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons6();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList06",pokemonList);
		mav.addObject("BODY","pokemonListView06.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList07.html", method = RequestMethod.GET)
	public ModelAndView readPokemons07() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons7();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList07",pokemonList);
		mav.addObject("BODY","pokemonListView07.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList08.html", method = RequestMethod.GET)
	public ModelAndView readPokemons08() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons8();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList08",pokemonList);
		mav.addObject("BODY","pokemonListView08.jsp");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/pokemon/pokemonList11.html", method = RequestMethod.GET)
	public ModelAndView readPokemons11() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons11();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList11",pokemonList);
		mav.addObject("BODY","pokemonListView11.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList22.html", method = RequestMethod.GET)
	public ModelAndView readPokemons22() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons22();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList22",pokemonList);
		mav.addObject("BODY","pokemonListView22.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList33.html", method = RequestMethod.GET)
	public ModelAndView readPokemons33() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons33();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList33",pokemonList);
		mav.addObject("BODY","pokemonListView33.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList44.html", method = RequestMethod.GET)
	public ModelAndView readPokemons44() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons44();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList44",pokemonList);
		mav.addObject("BODY","pokemonListView44.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList55.html", method = RequestMethod.GET)
	public ModelAndView readPokemons55() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons55();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList55",pokemonList);
		mav.addObject("BODY","pokemonListView55.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList66.html", method = RequestMethod.GET)
	public ModelAndView readPokemons66() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons66();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList66",pokemonList);
		mav.addObject("BODY","pokemonListView66.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList77.html", method = RequestMethod.GET)
	public ModelAndView readPokemons77() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons77();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList77",pokemonList);
		mav.addObject("BODY","pokemonListView77.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/pokemon/pokemonList88.html", method = RequestMethod.GET)
	public ModelAndView readPokemons88() {
		ModelAndView mav = new ModelAndView("home/template");
		//다섯개의 게시글을 찾는다.(조건 검색)
		List<PokemonVariety> pokemonList = pokemonCatalog.getPokemons88();
		//검색된 결과를 mav에 저장
		mav.addObject("pokemonList88",pokemonList);
		mav.addObject("BODY","pokemonListView88.jsp");
		return mav;
	}
	
}
