package abd.web.service.impl;

import java.util.List;

import abd.web.bean.Article;
import abd.web.dao.ArticleDao;
import abd.web.service.IArticleService;

public class ArticleServiceImpl implements IArticleService {
	
	private ArticleDao articleDao=new ArticleDao();
	
	@Override
	public void add(Article article) {
		articleDao.save(article);
	}

	@Override
	public void remove(long id) {
		
	}

	@Override
	public List<Article> list() {
		return articleDao.findAll();
	}

	@Override
	public Article scanner(long id) {
		return null;
	}

	@Override
	public List<Article> listByCategory(long c_id) {
		return null;
	}
	
}
