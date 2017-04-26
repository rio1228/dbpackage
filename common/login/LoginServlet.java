package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myclass.LoginCheck;

/**
 * Servlet implementation class login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession(false);
		if(session == null){
	   	    session = request.getSession(true);
		}
	   	/* 認証に成功したら、statusをnullにする */
//		session.setAttribute("status", "Not Auth");
		String index = (String)session.getAttribute("login_uri");

		Object user_id = request.getParameter("user");
		Object pass = request.getParameter("pass");

		String user = (String) user_id;
		String password = (String) pass;
		String user_name = null;
		LoginCheck	lc = new LoginCheck();

		user_name = lc.userName(user, password);

		/* 認証済みにセット */
		session.setAttribute("user_name", user_name);
		session.setAttribute("name", "OK");
		response.sendRedirect(index);
	}
}
