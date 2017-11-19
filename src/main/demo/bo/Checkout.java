package demo.bo;

public class Checkout {

	
	public enum CheckoutMethod {
		GUEST, MEMBER
	};

	private CheckoutMethod checkoutMethod;
	private String email;
	private String password;
	
	//------------------------------------------------------------------------
	public Checkout (CheckoutMethod checkoutMethod){
		this.checkoutMethod = checkoutMethod;
		this.email = null;
		this.password = null;
	}
	
	//------------------------------------------------------------------------
	public Checkout (CheckoutMethod checkoutMethod, String email, String password){
		this.checkoutMethod = checkoutMethod;
		this.email = email;
		this.password = password;
	}

	//------------------------------------------------------------------------
	public CheckoutMethod getCheckoutMethod() {
		return checkoutMethod;
	}

	public void setCheckoutMethod(CheckoutMethod checkoutMethod) {
		this.checkoutMethod = checkoutMethod;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
