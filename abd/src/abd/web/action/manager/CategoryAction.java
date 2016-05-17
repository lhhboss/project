package abd.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import abd.web.bean.Category;
import abd.web.service.ICategoryService;
import abd.web.service.impl.CategoryServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//同名参数传值
	private Long id;
	private String name;
	private Integer code;
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	
	private List<Category> categoryList;
	
	@Action(value="toAddCategory",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addCategory.jsp")})
	public String toAddCategory(){
		return "success";
	}
	
	@Action(value="toCategoryManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/categoryManager.jsp")})
	public String toCategoryManager(){
		//调用service层的方法查询所有栏目的信息，并且将这些值赋给categoryList
		categoryList=categoryService.list();
		return "success";
	}
	
	@Action(value="addCategory")
	//将接收到的参数进行封装，封装为一个对象
	public void addCategory(){
		//调用service层的服务，完成添加栏目的功能
		Category category=new Category(name,code);
		categoryService.add(category);
		
	}
	
	@Action(value="delCategory")
	//将接收到的参数进行封装，封装为一个对象
	public void delCategory(){
		categoryService.delete(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
