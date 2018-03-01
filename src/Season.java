public class Season {
	
	private String seasonName;
	
	private double quantitymulti;
	

	public Season(String SupplierName, double qualityMulti){
		seasonName=SupplierName;
		quantitymulti=qualityMulti;
	}
	
	public String GetName(){
		return(seasonName);
	}
	
	public double GetPopMultiplier(){
		return(quantitymulti);
	}
	
	
}
