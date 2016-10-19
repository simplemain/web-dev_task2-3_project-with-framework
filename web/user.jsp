<!DOCTYPE html>
<%@ page trimDirectiveWhitespaces="true"%> <!-- jsp标签，用来清除多余的空格 -->
<%@ page contentType="text/html; charset=UTF-8" %> <!-- jsp标签，用来设置编码和内容格式 -->
<%@ taglib prefix="s" uri="/struts-tags" %> <!-- jsp标签，用来设置struts标签前缀 -->

<html>
	<head>
		<meta name="referrer" content="always" />
		<meta charset="utf-8" />
		<title>用户管理</title>
	</head>
	
	<body style="font-family:Courier New;text-align:center">
	
		<div style="padding:100px 0 30px 0;"><table width="100%"><tr><td align="center">

			<table border="1">
				<tr>
					<td align="left" colspan="2"><input type="text" style="width:300px"/></td>
					<td align="center"><button>查找</button></td>
				</tr>

				<tr><td colspan="3"><div style="height:30px"></div></td></tr>

				<tr>
					<td align="center">ID</td>
					<td align="center">姓名</td>
					<td align="center">操作</td>
				</tr>
				<tr>
					<form action="user.action" method="get">
					<input type="hidden" name="action" value="add"/>
					<td align="center"></td>
					<td align="center"><input type="text" name="name" style="width:200px"/></td>
					<td align="center"><input type="submit" value="添加"/></td>
					</form>
				</tr>

				<s:iterator value="users">
				<tr>
					<td align="center"><s:property value="id"/></td>
					<td align="center"><s:property value="name"/></td>
					<td align="center"><a href="">删除</a></td>
				</tr>
				</s:iterator>
		</td></tr></table></div>
		
	</body>
</html>
