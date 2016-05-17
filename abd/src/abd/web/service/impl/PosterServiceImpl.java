package abd.web.service.impl;

import java.util.List;

import abd.web.bean.Poster;
import abd.web.dao.PosterDao;
import abd.web.service.IPosterService;

public class PosterServiceImpl implements IPosterService {
	
	private PosterDao posterDao=new PosterDao();
	
	@Override
	public void add(Poster poster) {
		posterDao.save(poster);
	}

	@Override
	public void remove(long id) {
		
	}

	@Override
	public List<Poster> list() {
		return posterDao.findAll();
	}

	@Override
	public Poster scanner(long id) {
		return null;
	}

	@Override
	public List<Poster> listByCategory(long c_id) {
		return null;
	}
	
}
