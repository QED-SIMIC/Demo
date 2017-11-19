package demo.bo;

public class Product {
		
	
	public enum ProductType {
		LAPTOP
	};
	
	private ProductType productType;
	private String manufacturer;
	private String model;
	
	//-------------------------------------------------------------------------
	public Product(ProductType productType, String manufacturer, String model) {
		this.productType = productType;
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	//-------------------------------------------------------------------------
	public ProductType getProductType() {
		return productType;
	}
	
	//-------------------------------------------------------------------------
	public String getManufacturer() {
		return manufacturer;
	}
	
	//-------------------------------------------------------------------------
	public String getModel() {
		return model;
	}

}
