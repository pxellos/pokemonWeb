package dao;

import java.util.List;

import model.Bbs;
import newModel.PokemonEntity;
import newModel.UserInfo;

public interface PokemonEntityDao {


	PokemonEntity pokemonentity(String id);
	
	public List<PokemonEntity> pokemonentityList(String id);

	void deleteDeck(PokemonEntity pokemonentity);
}
