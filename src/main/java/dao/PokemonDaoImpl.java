package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import newModel.PokemonVariety;
@Repository
public class PokemonDaoImpl implements PokemonDao {
	@Autowired
	private SqlSession session;

	public void putPokemon(PokemonVariety poke) {
		session.insert("mappers.myMapper.putPokemon",poke);
	}

	public List<PokemonVariety> getPokemons() {
		return session.selectList("mappers.myMapper.getPokemonList");
	}
	
	public List<PokemonVariety> getPokemons100() {
		return session.selectList("mappers.myMapper.getPokemonList100");
	}

	public Integer getPokemonCount() {
		return session.selectOne("mappers.myMapper.getPokemonCount");
	}


	public List<PokemonVariety> getPokemons1() {
		return session.selectList("mappers.myMapper.getPokemonList1");
	}

	public List<PokemonVariety> getPokemons2() {
		return session.selectList("mappers.myMapper.getPokemonList2");
	}

	public List<PokemonVariety> getPokemons3() {
		return session.selectList("mappers.myMapper.getPokemonList3");
	}

	public List<PokemonVariety> getPokemons4() {
		return session.selectList("mappers.myMapper.getPokemonList4");
	}

	public List<PokemonVariety> getPokemons5() {
		return session.selectList("mappers.myMapper.getPokemonList5");
	}

	public List<PokemonVariety> getPokemons6() {
		return session.selectList("mappers.myMapper.getPokemonList6");
	}

	public List<PokemonVariety> getPokemons7() {
		return session.selectList("mappers.myMapper.getPokemonList7");
	}
	
	public List<PokemonVariety> getPokemons8() {
		return session.selectList("mappers.myMapper.getPokemonList8");
	}

	
	
	public List<PokemonVariety> getPokemons11() {
		return session.selectList("mappers.myMapper.getPokemonList11");
	}

	public List<PokemonVariety> getPokemons22() {
		return session.selectList("mappers.myMapper.getPokemonList22");
	}

	public List<PokemonVariety> getPokemons33() {
		return session.selectList("mappers.myMapper.getPokemonList33");
	}

	public List<PokemonVariety> getPokemons44() {
		return session.selectList("mappers.myMapper.getPokemonList44");
	}

	public List<PokemonVariety> getPokemons55() {
		return session.selectList("mappers.myMapper.getPokemonList55");
	}

	public List<PokemonVariety> getPokemons66() {
		return session.selectList("mappers.myMapper.getPokemonList66");
	}

	public List<PokemonVariety> getPokemons77() {
		return session.selectList("mappers.myMapper.getPokemonList77");
	}

	public List<PokemonVariety> getPokemons88() {
		return session.selectList("mappers.myMapper.getPokemonList88");
	}

	public PokemonVariety getPokeDetail(Integer seqno) {
		return session.selectOne("mappers.myMapper.getPokeDetail");
	}
	
	
	

}
