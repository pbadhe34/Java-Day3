
public class Account {
	
	private int num;
	private Address adress;
	 
	 
	public void deposit() throws Exception
	{
		System.out.println("Account.deposit()");
		if(num < 0)
			throw new Exception("Cannot be negative");;
	}
	 
	protected void finalize() throws Throwable {
		   System.out.println("The account finalizer...");	
		   adress = new Address();
		   adress.setCityName("Pune");
	}

	 
	public String toString() {
		 
		return "The base class Account instance live with num  =  "+num +"  and address = "+adress.getCityName();
		}
	
	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Address getAdress() {
		return adress;
	}

	public  Account()
	{
		//System.out.println("Account.Account()");
		adress = null;
	}

	public  Account(int numValue)
	{
		num = numValue;
		adress = null;	 
		
		//System.out.println("Account.Account(int num) invoked..");
	}

	

}
