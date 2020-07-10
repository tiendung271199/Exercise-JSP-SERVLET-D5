<%@page import="beans.Hoa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>In danh sách hoa</title>
	<link href="<%=request.getContextPath() %>/css/reset.css" type="text/css" rel="stylesheet" />
	<link href="<%=request.getContextPath() %>/css/style2.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<%
			ArrayList<Hoa> listHoaLoad = (ArrayList<Hoa>) request.getAttribute("listhoaload");
			if (listHoaLoad.size() > 0) {
		%>
		<div class="title">
			<h1>Danh sách hoa</h1>
		</div>
		<div class="main">
			<table border="1" id="table">
				<tr>
					<th>ID Hoa</th>
					<th>Tên hoa</th>
					<th>Số lượng</th>
					<th>Giá bán</th>
					<th>Thành tiền</th>
				</tr>
				<%
					int tongTien = 0;
					for (Hoa hoa : listHoaLoad) {
						tongTien += hoa.getSoLuong() * hoa.getGiaBan();
				%>
				<tr>
					<td><%=hoa.getIdHoa() %></td>
					<td><%=hoa.getTenHoa() %></td>
					<td><%=hoa.getSoLuong() %></td>
					<td><%=hoa.getGiaBan() %></td>
					<td><%=hoa.getSoLuong() * hoa.getGiaBan() %></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="4">Tổng tiền:</td>
					<td><%=tongTien %></td>
				</tr>
			</table>
		</div>
		<%
			} else {
		%>
		<p style="color: red; font-style: italic">Không có danh sách hoa</p>
		<%
			}
		%>
	</div>
</body>
</html>