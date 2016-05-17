package abd.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import abd.web.bean.Article;
import abd.web.bean.Category;
import abd.web.service.IArticleService;
import abd.web.service.ICategoryService;
import abd.web.service.impl.ArticleServiceImpl;
import abd.web.service.impl.CategoryServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService=new CategoryServiceImpl();
	private IArticleService articleService=new ArticleServiceImpl();
	
	private List<Category> categoryList;
	private List<Article> articleList;
	
	private String title;
	private String content;
	private String author;
	private Long c_id;
	
	@Action(value="toAddArticle",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/addArticle.jsp")})
	public String toAddAritle(){
		categoryList=categoryService.list();
		return "success";
	}
	
	@Action(value="toArticleManager",
			results={@Result(name="success",
			location="/WEB-INF/jsp/manager/articleManager.jsp")})
	public String toArticleManager(){
		articleList=articleService.list();
		return "success";
	}

	@Action("addArticle")
	public void addArticle(){
		Article article=new Article();
		article.setAuthor(author);
		article.setC_id(c_id);
		article.setClickTimes(0);
		article.setContent(content);
		article.setPublisurDate(new Date());
		article.setTitle(title);
		articleService.add(article);
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
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
}
