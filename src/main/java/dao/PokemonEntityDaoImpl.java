package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import newModel.PokemonEntity;
import newModel.UserInfo;
@Repository
public class PokemonEntityDaoImpl implements PokemonEntityDao {
	@Autowired
	private SqlSession session;


	public PokemonEntity pokemonentity(String id) {
		return session.selectOne("mappers.myMapper.selectPokemonEntity", id ); //주인계정으로 포켓몬 검색
	}												


	public List<PokemonEntity> pokemonentityList(String id) {
		return session.selectList("mappers.myMapper.selectPokemonEntityList",id);
	}
	
	public void deleteDeck(PokemonEntity pokemonentity) {
		session.delete("mappers.myMapper.deleteDeck",pokemonentity);
	}
}