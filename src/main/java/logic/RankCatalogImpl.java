package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RankDao;
import model.Rank;

@Service
public class RankCatalogImpl implements RankCatalog {

	@Autowired
	private RankDao rankDao; 
	
	public List<Rank> rankingList() {
		return rankDao.rankingList();
	}

}
