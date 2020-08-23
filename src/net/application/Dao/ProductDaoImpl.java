package net.application.Dao;

import java.util.ArrayList;
import java.util.List;

import net.application.model.Product;

public class ProductDaoImpl implements ProductDao {

	private static List<Product> productList=new ArrayList<>();

	@Override
	public void addProduct(Product product) {
		productList.add(product);
	}

	@Override
	public void editProduct(String productName,String updateName,int updatePrice,String updateDesc) {
		// TODO Auto-generated method stub
		if(productList.size()!=0) {
			productList.forEach(prod->{
				if(prod.getProductName().equals(productName)) {
					prod.setProductDesc(updateDesc);
					prod.setProductName(updateName);
					prod.setProductPrice(updatePrice);
				}
			});
		}
	}

	@Override
	public List<Product> listAllProducts() {
		return productList;
	}
	
	public static void main(String[] args) {
		ProductDaoImpl pr = new ProductDaoImpl();
		pr.addProduct(new Product("tab", "fever", 25));
		pr.addProduct(new Product("tab1", "cold", 10));
		pr.addProduct(new Product("tab2", "cough", 15));
		pr.editProduct("tab1", "tab11", 50, "severre cold");
		System.out.println(pr.listAllProducts());
		
	}

	public Product selectUser(String name) {
		// TODO Auto-generated method stub
		Product existingProd=null;
		
		for(Product product:productList) {
			if(product.getProductName().equals(name)) {
				existingProd=product;
				break;
			}
		}	
		return existingProd;
	}

}
