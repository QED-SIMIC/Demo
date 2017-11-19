package demo.bo;

public class Customer {

	public Customer() {
		this.FirstName = null;
		this.LastName = null;
		this.address = null;
		this.city = null;
		this.postalCode = null;
		this.phone = null;
	}

	private String FirstName;
	private String LastName;
	private String address;
	private String city;
	private String province;
	private String postalCode;
	private String country;
	private Phone phone;

	// ------------------------------------------------------------------------
	public String getFirstName() {
		return FirstName;
	}

	// ------------------------------------------------------------------------
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	// ------------------------------------------------------------------------
	public String getAddress() {
		return address;
	}

	// ------------------------------------------------------------------------
	public void setAddress(String address) {
		this.address = address;
	}

	// ------------------------------------------------------------------------
	public String getCity() {
		return city;
	}

	// ------------------------------------------------------------------------
	public void setCity(String city) {
		this.city = city;
	}

	// ------------------------------------------------------------------------
	public String getProvince() {
		return province;
	}

	// ------------------------------------------------------------------------
	public void setProvince(String province) {
		this.province = province;
	}

	// ------------------------------------------------------------------------
	public String getPostalCode() {
		return postalCode;
	}

	// ------------------------------------------------------------------------
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	// ------------------------------------------------------------------------
	public String getCountry() {
		return country;
	}

	// ------------------------------------------------------------------------
	public void setCountry(String country) {
		this.country = country;
	}

	// ------------------------------------------------------------------------
	public Phone getPhoneNumber() {
		return phone;
	}

	// ------------------------------------------------------------------------
	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	// ------------------------------------------------------------------------
	public String getLastName() {
		return LastName;
	}

	// ------------------------------------------------------------------------
	public void setLastName(String lastName) {
		LastName = lastName;
	}

}
