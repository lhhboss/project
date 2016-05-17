<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#title{
		padding:1px;
		background-color:blue;
		font-size:20px;
		font-weight:bold;
		margin:0px;
	}
	#addPosterForm{
		margin:0 auto auto;
		padding-top:30px;
		padding-left:35px;
		font-size:16px;
	}
	#box{
		background-image:url("theme/1/images/front/2457331_041915083318_2.jpg");
		width:40%;
		height:385px;
		margin-top:30px;	
		margin-left:340px;
		padding:0px;
		border:1px solid red;
	}
</style>

<script>
$(function(){
	var form=$("#addPosterForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			form[0].reset();
			alter("添加成功！");
		})
		return false;
	})
})
</script>

<div id="title"><h1 align="center">海报发布</h1></div>
<hr>
<div id="box">
<form action="addPoster.action" method="post" id="addPosterForm">
	海报标题:<input type="text" name="title" style="font-size:15px"/><br/>
	发布作者:<input type="text" name="author" style="font-size:15px"/><br/>
	所属栏目: <select name="c_id">
				<option value="">请选中</option>
				<c:forEach items="${categoryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	文章内容:
			<textarea name="content" rows="10" cols="30"></textarea>
	<br/>
	<input type="submit" value="提交" style="font-size:15px;font-weight:bold"/><br/>
</form>
</div>