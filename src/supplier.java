


public class supplier {

	private String supplierName;
	private String address;
	private int popproductID;


	public supplier(String SupplierName, String Address, int PopproductID){
		supplierName=SupplierName;
		address=Address;
		popproductID=PopproductID;
	}


	public String GetName(){
		return(supplierName);
	}
	
	public int GetPopProduct(){
		return(popproductID);
	}
}