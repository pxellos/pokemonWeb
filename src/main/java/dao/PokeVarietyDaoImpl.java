package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import newModel.PokemonVariety;

@Repository
public class PokeVarietyDaoImpl implements PokeVarietyDao {
	@Autowired
	SqlSession session;

	public PokemonVariety selectValue(Integer code) {
		return session.selectOne("mappers.myMapper.selectVariety", code);
	}

}
