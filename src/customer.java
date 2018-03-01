public class customer {

	

	private String customerName;
	private String address;
	private int orderproductID;

	public customer(String CustomerName, String Address, int OrderproductID){

		customerName=CustomerName;
     	address=Address;
		orderproductID=OrderproductID;
	}

	public String GetName(){
		return(customerName);
	}	
	
	public int GetOrderProduct(){
		return(orderproductID);
	}	

}
