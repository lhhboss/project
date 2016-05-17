package abd.web.service;

import java.util.List;

import abd.web.bean.Article;

public interface IArticleService {
	void add(Article article);
	
	void remove(long id);
	
	List<Article> list();
	
	Article scanner(long id);
	
	List<Article> listByCategory(long c_id);
}
