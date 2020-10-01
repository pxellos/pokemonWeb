package logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PokeEntityDaoImpl;
import newModel.PokemonEntity;
import test.CRUDprocess;

public class Couple {
	public PokemonEntity red,blue;
	public List<PokemonEntity> redList, blueList;
	@Autowired
	public PokeEntityDaoImpl poke;
	
	Couple(String userId1, String userId2){
		
		PokeEntityDaoImpl poke = new PokeEntityDaoImpl();
		
		CRUDprocess crud = new CRUDprocess(); 
		poke.setSqlSession(crud.getSession());
		
		redList = new ArrayList<PokemonEntity>();
		blueList = new ArrayList<PokemonEntity>();
		
		redList = poke.pokeEntityList(userId1);
		blueList = poke.pokeEntityList(userId2);
		
		poke.getSqlSession().close(); //세션 종료
		
		int j = 0;
		System.out.println(redList.size() + " , " + blueList.size());
		
		for(PokemonEntity i :redList) {
			j = 0;
			redList.get(j).setSqlSession(crud.getSession());
			redList.get(j).skillSet(redList.get(j).getEntityNumber());
			j++;
		}
		for(PokemonEntity i :blueList) {
			j = 0;
			blueList.get(j).setSqlSession(crud.getSession());
			blueList.get(j).skillSet(blueList.get(j).getEntityNumber());
			j++;
		}
		
		for(PokemonEntity i :redList) {//세션 종료
			j = 0;
			redList.get(j).getSqlSession().close();
			j++;
		}
		
		for(PokemonEntity i :blueList) {//세션 종료
			j = 0;
			blueList.get(j).getSqlSession().close();
			j++;
		}
		
		/** 여러 마리 대전을 위해서 수정 필요 **/
		red = redList.get(0);
		blue = blueList.get(0);
	}
}
