<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mua Hoa</title>
	<link href="<%=request.getContextPath() %>/css/reset.css" type="text/css" rel="stylesheet" />
	<link href="<%=request.getContextPath() %>/css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<div class="title">
			<h1>Form mua hoa</h1>
		</div>
		<div class="main">
			<form action="<%=request.getContextPath() %>/xu-ly-mua-hoa-2" method="post" id="form">
				<%
					if (request.getParameter("msg") != null) {
						int msg = Integer.parseInt(request.getParameter("msg"));
						if (msg == 1) {
							out.print("<p style='color: red; font-style: italic'>Mua hoa thành công!</p>");
						}
					}
				%>
				<p>
					<label class="name">ID Hoa</label> <input type="text" name="idhoa" value="" />
				</p>
				<p>
					<label class="name">Tên hoa</label> <input type="text" name="tenhoa" value="" />
				</p>
				<p>
					<label class="name">Số lượng</label> <input type="text" name="soluong" value="" />
				</p>
				<p>
					<label class="name">Giá bán</label> <input type="text" name="giaban" value="" />
				</p>
				<p id="input">
					<input type="submit" name="submit" value="Mua" id="submit"/>
				</p>
			</form>
			<p>
				<a href="<%=request.getContextPath() %>/xu-ly-mua-hoa-2?load=0" title="">In danh sách hoa</a>
			</p>
			<p>	
				<a href="<%=request.getContextPath() %>/xu-ly-mua-hoa-2?load=1" title="">In danh sách hoa có số lượng > 10</a>
			</p>
			<p>
				<a href="<%=request.getContextPath() %>/xu-ly-mua-hoa-2?load=2" title="">In danh sách hoa có giá bán < 10000</a>
			</p>
		</div>
	</div>
</body>
</html>