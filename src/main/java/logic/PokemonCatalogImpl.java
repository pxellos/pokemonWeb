package logic;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PokemonDao;
import newModel.PokemonVariety;

@Service
public class PokemonCatalogImpl implements PokemonCatalog {
	@Autowired
	private PokemonDao pokemonDao;
	
	public void putPokemon(PokemonVariety poke) {
		pokemonDao.putPokemon(poke);
	}

	public List<PokemonVariety> getPokemons() {
		return pokemonDao.getPokemons();
	}

	public List<PokemonVariety> getPokemons100() {
		return pokemonDao.getPokemons100();
	}

	public Integer getPokemonCount() {
		return pokemonDao.getPokemonCount();
	}

	public List<PokemonVariety> getPokemons1() {
		return pokemonDao.getPokemons1();
	}

	public List<PokemonVariety> getPokemons2() {
		return pokemonDao.getPokemons2();
	}

	public List<PokemonVariety> getPokemons3() {
		return pokemonDao.getPokemons3();
	}

	public List<PokemonVariety> getPokemons4() {
		return pokemonDao.getPokemons4();
	}

	public List<PokemonVariety> getPokemons5() {
		return pokemonDao.getPokemons5();
	}

	public List<PokemonVariety> getPokemons6() {
		return pokemonDao.getPokemons6();
	}

	public List<PokemonVariety> getPokemons7() {
		return pokemonDao.getPokemons7();
	}
	
	public List<PokemonVariety> getPokemons8() {
		return pokemonDao.getPokemons8();
	}
	
	
	

	public List<PokemonVariety> getPokemons11() {
		return pokemonDao.getPokemons11();
	}

	public List<PokemonVariety> getPokemons22() {
		return pokemonDao.getPokemons22();
	}

	public List<PokemonVariety> getPokemons33() {
		return pokemonDao.getPokemons33();
	}

	public List<PokemonVariety> getPokemons44() {
		return pokemonDao.getPokemons44();
	}

	public List<PokemonVariety> getPokemons55() {
		return pokemonDao.getPokemons55();
	}

	public List<PokemonVariety> getPokemons66() {
		return pokemonDao.getPokemons66();
	}

	public List<PokemonVariety> getPokemons77() {
		return pokemonDao.getPokemons77();
	}

	public List<PokemonVariety> getPokemons88() {
		return pokemonDao.getPokemons88();
	}

	public PokemonVariety getPokeDetail(Integer seqno) {
		return pokemonDao.getPokeDetail(seqno);
	}
	
	
	

}
