package hello.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Product {

	@Id
	private String id;

	@DBRef
	private List<Business> businessesList;

	@DBRef
	private Employee productOwner;

	@DBRef
	private List<ProductVersion> productVersions;

	private String productName;
	private String productType;

	public List<Business> getBusinessesList() {
		return businessesList;
	}

	public void setBusinessesList(List<Business> businessesList) {
		this.businessesList = businessesList;
	}

	public Employee getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(Employee productOwner) {
		this.productOwner = productOwner;
	}

	public List<ProductVersion> getProductVersions() {
		return productVersions;
	}

	public void setProductVersions(List<ProductVersion> productVersions) {
		this.productVersions = productVersions;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
}
