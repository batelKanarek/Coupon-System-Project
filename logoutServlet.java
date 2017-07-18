package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutServlet
 */
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				// System.out.println(cookies[i].getName());
				if (cookies[i].getName().equalsIgnoreCase("userID") || cookies[i].getName().equalsIgnoreCase("password")
						|| cookies[i].getName().equalsIgnoreCase("clientType")) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		// System.out.println("thank you for logging out");

		response.sendRedirect(
				response.encodeRedirectURL("http://localhost:8080/CouponSystemPart2/General/Html/login.html"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
