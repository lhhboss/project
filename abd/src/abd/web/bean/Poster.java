package abd.web.bean;

import java.util.Date;

public class Poster {
	private Long id;
	private String title;
	private String author;
	private String content;
	private Date publisurDate; 
	private Integer clickTimes;
	private Long c_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getPublisurDate() {
		return publisurDate;
	}
	public void setPublisurDate(Date publisurDate) {
		this.publisurDate = publisurDate;
	}
	public Integer getClickTimes() {
		return clickTimes;
	}
	public void setClickTimes(Integer clickTime) {
		this.clickTimes = clickTime;
	}
	public Long getC_id() {
		return c_id;
	}
	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
