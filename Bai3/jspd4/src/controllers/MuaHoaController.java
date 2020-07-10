package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Hoa;

public class MuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Hoa> listHoa = new ArrayList<Hoa>();

	public MuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		boolean check = true;
		int idHoa = Integer.parseInt(request.getParameter("idhoa"));
		String tenHoa = request.getParameter("tenhoa");
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		int giaBan = Integer.parseInt(request.getParameter("giaban"));
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
		session.setAttribute("listhoa", listHoa);
		response.sendRedirect(request.getContextPath() + "/basket.jsp");
	}

}
