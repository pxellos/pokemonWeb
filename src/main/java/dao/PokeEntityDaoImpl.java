package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import newModel.PokemonEntity;

@Repository
public class PokeEntityDaoImpl implements PokeEntityDao {
	@Autowired
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public PokemonEntity pokeEntity(String userId) {
		return sqlSession.selectOne("mappers.myMapper.selectEntity",userId);
	}

	public void pokeNew(PokemonEntity poke) {
		sqlSession.insert("mappers.myMapper.insertEntity",poke);
	}

	public Integer count() {
		return sqlSession.selectOne("mappers.myMapper.countEntity");
	}

	public List<PokemonEntity> pokeEntityList(String userId) {
		
		return sqlSession.selectList("mappers.myMapper.selectEntityList", userId);
	}

	public List<Integer> deckList(String userId) {
		return sqlSession.selectList("mappers.myMapper.deckList",userId);
	}

}
