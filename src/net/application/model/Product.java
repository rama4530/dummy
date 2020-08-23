package net.application.model;

public class Product {
	protected int id;
	protected String productName;
	protected String productDesc;
	protected int productPrice;
	
	
	public Product() {
		
	}
	
	public Product(String productName, String productDesc, int productPrice) {
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}
	
	
	public Product(int id, String productName, String productDesc, int productPrice) {
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice="
				+ productPrice + "]";
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
}
