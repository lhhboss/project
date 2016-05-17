package abd.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import abd.web.bean.Category;
import abd.web.service.ICategoryService;
import abd.web.service.impl.CategoryServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport  {

	private static final long serialVersionUID = 1L;
	private List<Category> categoryList;
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	
	/**
	 * 跳转到首页
	 */
	@Action(value="toIndex",results={
			@Result(name="success",location="/WEB-INF/jsp/index.jsp")})
	public String toIndex(){
		categoryList=categoryService.list();
		return "success";
	}
	
	@Action(value="toList",results={
			@Result(name="success",location="/WEB-INF/jsp/list.jsp")})
	public String toList(){
		
		return "success";
	}
	
	@Action(value="toContent",results={
			@Result(name="success",location="/WEB-INF/jsp/content.jsp")})
	public String toContent(){
		
		return "success";
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

}
