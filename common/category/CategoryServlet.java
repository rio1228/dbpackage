package category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myclass.ProductCategory;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PRODUCT_INFO_TBL = "SHOU";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = null;//request.getSession(false);
		if(session == null){
	   	    session = request.getSession(true);
		}

		ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
		String sql = " SELECT * FROM "+ PRODUCT_INFO_TBL;
		ProductCategory pc = new ProductCategory();
		array = pc.strArray(sql);
		session.setAttribute("product_array", array);

		RequestDispatcher dis = request.getRequestDispatcher("category.jsp");
		dis.forward(request, response);

	}

}
