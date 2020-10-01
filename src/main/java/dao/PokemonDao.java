package dao;

import java.util.List;

import model.Bbs;
import newModel.PokemonVariety;

public interface PokemonDao {

	void putPokemon(PokemonVariety poke);
	List<PokemonVariety> getPokemons();
	List<PokemonVariety> getPokemons100();
	
	List<PokemonVariety> getPokemons1();
	List<PokemonVariety> getPokemons2();
	List<PokemonVariety> getPokemons3();
	List<PokemonVariety> getPokemons4();
	List<PokemonVariety> getPokemons5();
	List<PokemonVariety> getPokemons6();
	List<PokemonVariety> getPokemons7();
	List<PokemonVariety> getPokemons8();
	
	List<PokemonVariety> getPokemons11();
	List<PokemonVariety> getPokemons22();
	List<PokemonVariety> getPokemons33();
	List<PokemonVariety> getPokemons44();
	List<PokemonVariety> getPokemons55();
	List<PokemonVariety> getPokemons66();
	List<PokemonVariety> getPokemons77();
	List<PokemonVariety> getPokemons88();
	
	Integer getPokemonCount();
	PokemonVariety getPokeDetail(Integer seqno);//특정 게시글 검색
}
