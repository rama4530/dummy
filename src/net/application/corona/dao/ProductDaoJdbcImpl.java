package net.application.corona.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import net.application.model.Product;

public class ProductDaoJdbcImpl implements ProductDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/corona?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Rk4530451";
	
	
	public static final String INS_CONT_QRY = "INSERT INTO products(id,name,description,price) VALUES(?,?,?,?)";
	public static final String UPD_CONT_QRY = "UPDATE products set name=?,description=?price=? WHERE id=?";
	public static final String GET_CONT_BY_ID_QRY = "SELECT id,name,description,price FROM products WHERE id=?";
	public static final String GET_ALL_CONTS_QRY = "SELECT id,name,description,price FROM products";

	
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	@Override
	public Product add(Product prod) {

		if (prod != null) {
			try (Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(INS_CONT_QRY);) {

				pst.setInt(1, prod.getId());
				pst.setString(2, prod.getProductName());
				pst.setString(3, prod.getProductDesc());
				pst.setInt(4, prod.getProductPrice());

				pst.executeUpdate();
			} catch (SQLException exp) {
				exp.printStackTrace();
			}
		}

		return prod;
	}

	@Override
	public Product save(Product prod) {
		if (prod != null) {
			try (Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_CONT_QRY);) {

				pst.setString(1, prod.getProductName());
				pst.setString(2, prod.getProductDesc());
				pst.setInt(3, prod.getProductPrice());
				pst.setInt(4, prod.getId());
				pst.executeUpdate();
			} catch (SQLException exp) {

			}
		}

		return prod;
	}



	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();

		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_CONTS_QRY);) {

			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductDesc(rs.getString(3));
				product.setProductPrice(rs.getInt(4));

				products.add(product);
			}

			if(products.isEmpty()) {
				products=null;
			}

		} catch (SQLException exp) {
			exp.getMessage();
		}

		return products;
	}

	public static void main(String[] args) {
		ProductDaoJdbcImpl prod=new ProductDaoJdbcImpl();
		prod.add(new Product(1,"Tablet","asdasdasd",123));
		List<Product> products = prod.getAll();

		products.forEach(x->{
			System.out.println(x);
		});
		System.out.println(prod.getById(1));
	}
	
	@Override
	public Product getById(int id)  {
		Product product = null;

		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(GET_CONT_BY_ID_QRY);) {

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductDesc(rs.getString(3));
				product.setProductPrice(rs.getInt(4));
			}

		} catch (SQLException exp) {
			
		}

		return product;
	}




}