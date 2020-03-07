
public class SavingAccount extends Account{
	
	private int num;
	private Address adress;
	private String userData[];
	
	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Address getAdress() {
		return adress;
	}

	public SavingAccount()
	{
		//System.out.println("Account.Account()");
		adress = null;
		userData = null;
	}

	public SavingAccount(int numValue)
	{
		num = numValue;		 
		userData = new String[100];
		
		//System.out.println("Account.Account(int num) invoked..");
	}

	 
	protected void finalize() throws Throwable {
		   System.out.println("The saving account finalize...");
		   System.out.println("Clearing the userData in saving account");
		   userData = null;
		
	}

	 
	public String toString() {
		 
		return "Account instance live with num  =  "+num +"  and address = "+adress.getCityName();
	}

}
