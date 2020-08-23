package net.application.corona.dao;

import java.util.List;

import net.application.model.Product;



public interface ProductDao {

	Product add(Product contact);

	Product save(Product contact);

	Product getById(int contactId);

	List<Product> getAll();
}
