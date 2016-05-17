<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	th{
		background: lightblue;
		font-family:微软雅黑;
		font-size:14px;
	}
	td{
		text-align:center;
		font-family:微软雅黑;
		font-size:14px;
	}
</style>
<h1>栏目管理</h1>
<hr>
<table border="1" style="width:100%;border-collapse: collapse;margin-top:10px;">
	<tr>
		<th>编号</th>
		<th>栏目名称</th>
		<th>栏目编号</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${categoryList }" var="c">
	<tr>
		<td><input type="checkbox" value="${c.id }"/></td>
		<td>${c.name }</td>
		<td>${c.code }</td>
		<td>
			<a href="javascript:void(0);" val="${c.id }" class="upd">修改</a>
			<a href="javascript:void(0);" val="${c.id }" class="del">删除</a>
		</td>
	</tr>
	</c:forEach>
</table>
<script>
	$(function(){
		$(".upd").off();
		$(".upd").on("click",function(){
			alert("功能未完善！");
		});
		
		$(".del").off();
		$(".del").on("click",function(){
			var flag=confirm("确定删除？");
			if(flag){
				var id=$(this).attr("val");
				$.post("delCategory.action",{id:id},function(){
					$(".baseUI li :contains('栏目管理')").trigger("click");
				});
			}
			
		});
	});
</script>