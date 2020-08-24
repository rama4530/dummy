package net.application.corona.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.application.corona.exception.ProductException;
import net.application.model.Product;

public class ProductDaoJdbcImpl implements ProductDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/productdetails?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Rk4530451";
	
	
	public static final String INS_CONT_QRY = "INSERT INTO products(name,description,price) VALUES(?,?,?)";
	public static final String UPD_CONT_QRY = "UPDATE products set name=?,description=?,price=? WHERE id=?;";
	public static final String GET_CONT_BY_ID_QRY = "SELECT id,name,description,price FROM products WHERE id=?";
	public static final String GET_ALL_CONTS_QRY = "SELECT * FROM products";
	public static final String DELETE_USERS_SQL = "delete from products where id = ?;";
	
	
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
	public Product add(Product prod) throws ProductException {

		if (prod != null) {
			try (Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(INS_CONT_QRY);) {

				pst.setString(1, prod.getProductName());
				pst.setString(2, prod.getProductDesc());
				pst.setInt(3, prod.getProductPrice());
				
				pst.executeUpdate();
			} catch (SQLException exp) {
				throw new ProductException("Adding Product failed!");
			}
		}

		return prod;
	}

	@Override
	public Product save(Product prod) throws ProductException {
		if (prod != null) {
			try (Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_CONT_QRY);) {
				pst.setString(1, prod.getProductName());
				pst.setString(2, prod.getProductDesc());
				pst.setInt(3, prod.getProductPrice());
				pst.setInt(4, prod.getId());
				System.out.println(pst);
				pst.executeUpdate();
			} catch (SQLException exp) {
				throw new ProductException("Saving Product failed!");
			}
		}
//"UPDATE products set name=?,description=?price=? WHERE id=?;"
		return prod;
	}



	@Override
	public List<Product> getAll() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();

		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_CONTS_QRY);) {

			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("name"));
				product.setProductDesc(rs.getString("description"));
				product.setProductPrice(rs.getInt("price"));

				products.add(product);
			}

			if(products.isEmpty()) {
				products=null;
			}

		} catch (SQLException exp) {
			throw new ProductException("getting Products failed!");
		}

		return products;
	}


	
	@Override
	public Product getById(int id) throws ProductException   {
		Product product = null;

		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(GET_CONT_BY_ID_QRY);) {

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				product = new Product();
				String name = rs.getString("name");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				product = new Product(id, name, description, price);
			}

		} catch (SQLException exp) {
			throw new ProductException("Getting Product by id is failed!");
		}

		return product;
	}

	public boolean deleteUser(int id) throws ProductException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException exp) {
			throw new ProductException("Deleting Contact failed!");
		}
		return rowDeleted;
	}

public static void main(String[] args) {
	
	
}


}