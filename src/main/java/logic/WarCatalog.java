package logic;

import java.util.List;

import dao.RankDao;
import newModel.PokemonEntity;

public interface WarCatalog {
	
	public PokemonEntity pokeEntity(String userId);
	
	public List<String> warPlay(String userinfo_id, String userId2, RankDao rankDao);
	
}
