package demo.bo;

public class Phone {

	
		public Phone (String phoneAreaDashExchageDashNumber){
			this.phoneNumber = phoneAreaDashExchageDashNumber;
		}
	private String phoneNumber;
	
	//-----------------------------------------------------------------------
	public String  getAreaCode(){
		String areaCode = null;
		int firstDashIx = 0;
		
		firstDashIx = this.phoneNumber.indexOf("-");
		
		areaCode = this.phoneNumber.substring(0, firstDashIx);
		
		return areaCode;
	}

	//-----------------------------------------------------------------------
	public String  getLocalExchangeCode(){
		String localExchangeCode = null;
		int firstDashIx = -1, secondDashIx = - 1;
		
		firstDashIx = this.phoneNumber.indexOf('-');
		secondDashIx = this.phoneNumber.indexOf('-', firstDashIx + 1);
		
		localExchangeCode = this.phoneNumber.substring(firstDashIx + 1, secondDashIx);
		
		return localExchangeCode;
	}

	//-----------------------------------------------------------------------
	public String  getNumber(){
		String number = null;
		int ixFirst = 0, ixLast = 0;
		
		ixFirst = this.phoneNumber.indexOf('-', 0);
		ixFirst = this.phoneNumber.indexOf('-', (ixFirst + 1)) + 1;
		ixLast = this.phoneNumber.length();
		number = this.phoneNumber.substring(ixFirst, ixLast);
		
		return number;
	}
	
	//-----------------------------------------------------------------------
	public String  getCompleteNumber(){
		return this.phoneNumber;
	}


}
