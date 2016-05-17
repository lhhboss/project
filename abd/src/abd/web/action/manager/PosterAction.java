package abd.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import abd.web.bean.Category;
import abd.web.bean.Poster;
import abd.web.service.ICategoryService;
import abd.web.service.IPosterService;
import abd.web.service.impl.CategoryServiceImpl;
import abd.web.service.impl.PosterServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class PosterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService=new CategoryServiceImpl();
	private IPosterService posterService=new PosterServiceImpl();
	
	private List<Category> categoryList;
	private List<Poster> posterList;
	
	private String title;
	private String content;
	private String author;
	private Long c_id;
	
	@Action(value="toAddPoster",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/addPoster.jsp")})
	public String toAddPoster(){
		categoryList=categoryService.list();
		return SUCCESS;
	}
	
	@Action(value="toPosterManager",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/posterManager.jsp")})
	public String toPosterManager(){
		posterList=posterService.list();
		return SUCCESS;
	}
	
	@Action("addPoster")
	public void addPoster(){
		Poster poster=new Poster();
		poster.setAuthor(author);
		poster.setC_id(c_id);
		poster.setContent(content);
		poster.setClickTimes(0);
		poster.setPublisurDate(new Date());
		poster.setTitle(title);
		posterService.add(poster);
	}

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public IPosterService getPosterService() {
		return posterService;
	}

	public void setPosterService(IPosterService posterService) {
		this.posterService = posterService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Poster> getPosterList() {
		return posterList;
	}

	public void setPosterList(List<Poster> posterList) {
		this.posterList = posterList;
	}
}
	
