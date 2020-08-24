package net.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.application.corona.dao.ProductDaoJdbcImpl;
import net.application.corona.exception.ProductException;
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

		case "/delete":
			deleteUser(request,response);
			break;
		default:
			listProduct(request, response);
			break;
		}

	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Product existingProduct = prod.getById(id);
			request.setAttribute("product", existingProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddProductsToCart.jsp");
			dispatcher.forward(request, response);
		}catch(ProductException e) {
			request.setAttribute("errMsg", e.getMessage());	
		}

	}

	protected void showAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Product> listProducts = prod.getAll();
			RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
			request.setAttribute("listProducts", listProducts);
			dispatcher.forward(request, response);
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);

	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		try {
			List<Product> listProducts = prod.getAll();
			RequestDispatcher dispatcher = request.getRequestDispatcher("listProducts.jsp");
			request.setAttribute("listProducts", listProducts);
			dispatcher.forward(request, response);
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());

		}
	}


	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Product existingProduct = prod.getById(id);
			request.setAttribute("product", existingProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
			dispatcher.forward(request, response);
		}catch(ProductException e) {
			request.setAttribute("errMsg", e.getMessage());	
		}
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws  IOException, ServletException {
		String view = "";
		String productName = request.getParameter("name");
		String productDesc = request.getParameter("desc");
		int productPrice = Integer.parseInt(request.getParameter("price"));
		Product newProduct = new Product(productName, productDesc, productPrice);
		try {
			prod.add(newProduct);
			response.sendRedirect("list");
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
		}
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws  IOException {

		System.out.println(request.getParameter("id"));
		int id=Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("name");
		String productDesc = request.getParameter("desc");
		int productPrice = Integer.parseInt(request.getParameter("price"));
		Product newProduct = new Product(id,productName, productDesc, productPrice);
		System.out.println(newProduct);

		try {
			prod.save(newProduct);
			response.sendRedirect("list");
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws  IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			prod.deleteUser(id);
			response.sendRedirect("list");
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
		}

	}

}




