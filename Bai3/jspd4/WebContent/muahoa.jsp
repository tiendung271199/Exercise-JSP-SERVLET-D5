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
			<form action="<%=request.getContextPath() %>/xu-ly-mua-hoa" method="post" id="form">
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
		</div>
	</div>
</body>
</html>