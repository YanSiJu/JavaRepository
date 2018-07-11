<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/css/table.css" rel="stylesheet" />
<title>无标题文档</title>
<style>
a:active {
	border: 1px solid #000
}
</style>
</head>

<body>
	<br />
	<div class="main">
		<input type="text" /> <a href="#"><img
			src="<%=path%>/image/search.png" />查询</a> <a
			href="<%=path%>/QueryProCMS"><img src="<%=path%>/image/add.png" />添加</a>
	</div>
	<table class="table-integral main">
		<thead>
			<tr>
				<td>服装编号</td>
				<td>服装名称</td>
				<td>尺码</td>
				<td>颜色</td>
				<td>面料</td>
				<td>进货价</td>
				<td>售价</td>
				<td style="width: 200px">操作</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="pro">
				<tr>
					<td>${pro.pro_id}</td>
					<td>${pro.pro_name}</td>
					<td>${pro.size_name}</td>
					<td>${pro.color_name}</td>
					<td>${pro.outma_name}</td>
					<td>${pro.pro_facprice}</td>
					<td>${pro.pro_retprice}</td>
					<td><a><img src="<%=path%>/image/remove.png" />删除</a> <a><img
							src="<%=path%>/image/pencil.png" />修改</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="main">
		<div id="wrap" class="page_btn clear">
			<span class="page_box"> <a class="prev" id="prev"
				href="<%=path %>/ProductServlet?page=${page-1}&pageSize=5">上一页</a> <a
				class="next" id="next"
				href="<%=path %>/ProductServlet?page=${page+1}&pageSize=5">下一页</a>
				共${count}条记录 当前第${page}页
			</span>
		</div>

		var prev=document.getElementById("prev");//获取上一页的超链接对象 var
		next=document.getElementById("next");//获取下一页的超链接对象 var page=${page};
		var count=${count};//总记录数 var pageSize=5;//每页显示多少条数据 var
		n=count/pageSize;//总共多少页 if(page==1){ prev.href="#"; } if(page>=n){
		next.href="#"; }
		
	</div>
</body>
</html>
