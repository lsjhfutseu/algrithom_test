<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
	<head>
		<meta charset="utf-8">
		<title>菜鸟教程(runoob.com)</title>
		<style>
			.red_color{

				color:red;
				}
		</style>
	</head>
	<body>
		<jsp:element name="h1">
			<jsp:attribute name="class">
				red_color
			</jsp:attribute>
			<jsp:body>
			   XML 元素的主体
			</jsp:body>
		</jsp:element>
	</body>
</html>