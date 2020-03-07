
public class Account {
	
	private int num;
	private Address adress;
	
	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Address getAdress() {
		return adress;
	}

	public Account()
	{
		//System.out.println("Account.Account()");
		adress = new Address("Hyderabad");
	}

	public Account(int numValue)
	{
		num = numValue;
		adress = new Address("Mumbai");
		//System.out.println("Account.Account(int num) invoked..");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		
		System.out.println("\nFinalize() invoked for Account with   "+num);
		
		if(num==200)//check for weak type
		{
			System.out.println("\nAccount.finalize() invoked for  weakType with  "+num);
			System.out.println("\n***Reinitilaizing the Account address for weakType  ");
			adress = new Address("Pune");
		}
		
		if(num==300)//check for phantom type
		{
			System.out.println("\nAccount.finalize() invoked for  phantomType with  "+num);
			System.out.println("\n***Reinitilaizing the Account address for phantomType  ");
			//adress = new Address("Virtual");
			adress.setCityName("Pune");
		}
		
	}

	@Override
	public String toString() {
		 
		return "Account instance live with num  =  "+num +"  and address = "+adress.getCityName();
	}

}
