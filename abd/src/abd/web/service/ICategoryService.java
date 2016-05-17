package abd.web.service;

import java.util.List;

import abd.web.bean.Article;
import abd.web.bean.Category;

public interface ICategoryService {

		void add(Category category);

		List<Category> list();
		
		void delete(long id);
}
