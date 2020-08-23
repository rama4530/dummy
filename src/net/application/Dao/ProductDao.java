package net.application.Dao;

import java.util.List;

import net.application.model.Product;

public interface ProductDao {

	public void addProduct(Product product);
	public void editProduct(String productName,String updateName,int updatePrice,String updateDesc);
	public List<Product> listAllProducts();
}
