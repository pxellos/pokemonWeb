package dao;

import java.util.List;

import newModel.PokemonEntity;

public interface PokeEntityDao {

	public PokemonEntity pokeEntity(String userId);
	
	public void pokeNew(PokemonEntity poke);
	
	public Integer count();
	
	public List<PokemonEntity> pokeEntityList(String userId);
	
	public List<Integer> deckList(String userId);
	
}
