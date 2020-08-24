package net.application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.application.Dao.ProductDao;
import net.application.corona.dao.ProductDaoJdbcImpl;
import net.application.corona.exception.ProductException;
import net.application.model.Item;
import net.application.model.Product;

/**
 * Servlet implementation class ShoppingCartController
 */
@WebServlet("/ShoppingCartController")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		ProductDaoJdbcImpl product=new ProductDaoJdbcImpl();
		HttpSession session= request.getSession();
		if(action.equals("orderNow")) {
			if(session.getAttribute("cart")==null) {
				List<Item> cart=new ArrayList<>();
				try {
					cart.add(new Item(product.getById(Integer.parseInt(request.getParameter("id"))),1));
					session.setAttribute("cart",cart);
				} catch (NumberFormatException | ProductException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				List<Item> cart=new ArrayList<>();
				try {
					cart.add(new Item(product.getById(Integer.parseInt(request.getParameter("id"))),1));
					session.setAttribute("cart",cart); 
				} catch (NumberFormatException | ProductException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
