package abd.web.service.impl;

import java.util.List;

import abd.web.bean.Category;
import abd.web.dao.CategoryDao;
import abd.web.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	//创建Dao层对象，方便Service层的各个方法调用Dao层的方法
	private CategoryDao categoryDao=new CategoryDao();
	@Override
	public void add(Category category) {
		categoryDao.save(category);
	}
	
	@Override
	public List<Category> list() {
		List<Category> list=categoryDao.findAll();
		return list;
	}
	
	@Override
	public void delete(long id) {
		categoryDao.deleteById(id);
	}

}
