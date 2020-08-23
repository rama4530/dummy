package net.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.application.corona.dao.ProductDaoJdbcImpl;
import net.application.model.Product;



/**
 * Servlet implementation class ProductController
 */
@WebServlet("/")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDaoJdbcImpl prod=null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		prod=new ProductDaoJdbcImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;

		case "/insert":
			insertProduct(request, response);
			break;

		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateProduct(request, response);
			break;
		default:
			listUser(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws  IOException, ServletException {
		List<Product> listProducts = prod.getAll();
		listProducts.forEach(z->{
			System.out.println(z.getProductName());
		});

		RequestDispatcher dispatcher = request.getRequestDispatcher("listProducts.jsp");
		request.setAttribute("listProducts", listProducts);
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("newproduct.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product existingProduct = prod.getById(id);
		request.setAttribute("product", existingProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editproduct.jsp");
		dispatcher.forward(request, response);
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws  IOException, ServletException {
		int productId=Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		Product newProduct = new Product(productId,productName, productDesc, productPrice);
		prod.add(newProduct);
		response.sendRedirect("list");
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws  IOException {
		System.out.println(request.getParameter("productId"));
		int id=Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String productDesc = request.getParameter("productDesc");
		String price = request.getParameter("productPrice");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		Product newProduct = new Product(id,productName, productDesc, productPrice);
		System.out.println(newProduct);
		prod.save(newProduct);
		response.sendRedirect("list");
	}

}




