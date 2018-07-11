<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
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
			src="<%=path%>/image/search.png" />查询</a> <a href="#"><img
			src="<%=path%>/image/add.png" />添加</a>
	</div>
	<table class="table-integral main">
		<thead>
			<tr>
				<td>入库编号</td>
				<td>所入仓库</td>
				<td>操作用户</td>
				<td>入库时间</td>
				<td>备注</td>
				<td style="width: 200px">操作</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="stockin">
				<tr>
					<td>${stockin.stockin_id}</td>
					<td>${stockin.ware_name}</td>
					<td>${stockin.real_name}</td>
					<td>${stockin.stockin_date}</td>
					<td>${stockin.stockin_remark}</td>
					<td><a><img src="<%=path%>/image/remove.png" />删除</a> <a><img
							src="<%=path%>/image/pencil.png" />修改</a> <a
						href="<%=path %>/StockindetServlet?sid=${stockin.stockin_id}"><img
							src="<%=path%>/image/search.png" />显示入库明细</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="main">
		<div id="wrap" class="page_btn clear">
			<span class="page_box"> <a class="prev" id="prev"
				href="<%=path %>/StockinServlet?page=${page-1}&pageSize=5">上一页</a> <a
				class="next" id="next"
				href="<%=path %>/StockinServlet?page=${page+1}&pageSize=5">下一页</a>
				共${count}条记录 当前第${page}页
			</span>
		</div>
	</div>

	<script type="text/javascript">
		var prev = document.getElementById("prev");//获取上一页的超链接对象 var
		next = document.getElementById("next");//获取下一页的超链接对象 var page=${page};
		var count = $
		{
			count
		};//总记录数 var pageSize=5;//每页显示多少条数据 var
		n = count
		/pageSize;/ / 总共多少页
		if (page == 1) {
			prev.href = "#";
		}
		if (page >= n) {
			next.href = "#";
		}
	</script>
</body>
</html>
