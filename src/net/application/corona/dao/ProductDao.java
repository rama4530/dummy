package net.application.corona.dao;

import java.util.List;
import net.application.corona.exception.ProductException;
import net.application.model.Product;



public interface ProductDao {

	Product add(Product contact) throws ProductException;

	Product save(Product contact) throws ProductException;

	Product getById(int contactId) throws ProductException;

	List<Product> getAll() throws ProductException;
}
