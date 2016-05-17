package abd.web.service;

import java.util.List;

import abd.web.bean.Poster;

public interface IPosterService {
	void add(Poster poster);
	
	void remove(long id);
	
	List<Poster> list();
	
	Poster scanner(long id);
	
	List<Poster> listByCategory(long c_id);
}
