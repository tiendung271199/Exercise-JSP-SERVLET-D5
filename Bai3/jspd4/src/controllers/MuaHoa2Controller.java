package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Hoa;

public class MuaHoa2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Hoa> listHoa = new ArrayList<Hoa>();

	public MuaHoa2Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Hoa> listHoaLoad = new ArrayList<Hoa>();
		if (request.getParameter("load") != null) {
			int chonHienThi = Integer.parseInt(request.getParameter("load"));
			String s = request.getParameter("ssearch");
			System.out.println(s);
			if (chonHienThi == 0) {
				listHoaLoad = listHoa;
			} else if (chonHienThi == 1) {
				for (Hoa hoa : listHoa) {
					if (hoa.getSoLuong() > 10) {
						listHoaLoad.add(hoa);
					}
				}
			} else {
				for (Hoa hoa : listHoa) {
					if (hoa.getGiaBan() < 10000) {
						listHoaLoad.add(hoa);
					}
				}
			}
		}
		request.setAttribute("listhoaload", listHoaLoad);
		RequestDispatcher rd = request.getRequestDispatcher("/basket2.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		boolean check = true;
		int idHoa = 0, soLuong = 0, giaBan = 0;
		if (request.getParameter("idhoa") != "") {
			idHoa = Integer.parseInt(request.getParameter("idhoa"));
		}
		String tenHoa = request.getParameter("tenhoa");
		if (request.getParameter("soluong") != "") {
			soLuong = Integer.parseInt(request.getParameter("soluong"));
		}
		if (request.getParameter("giaban") != "") {
			giaBan = Integer.parseInt(request.getParameter("giaban"));
		}
		Hoa objHoa = new Hoa(idHoa, tenHoa, soLuong, giaBan);
		if (listHoa.size() > 0) {
			for (Hoa hoa : listHoa) {
				if (hoa.getIdHoa() == idHoa) {
					hoa.setSoLuong(soLuong + hoa.getSoLuong());
					check = true;
					break;
				} else {
					check = false;
				}
			}
		}
		if (!check || listHoa.size() == 0) {
			listHoa.add(objHoa);
		}
		
		response.sendRedirect(request.getContextPath() + "/mua-hoa-2?msg=1");
	}

}
