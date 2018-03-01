public class product {

	private int ProductID;
	private String Pname;
	private int Averagequa;
	private String Season;
	private String ExpDate;
	private int quantity;
	

	public product(int PRoductID, String ProductName,int  AverageQua, String season){
		ProductID= PRoductID;
		Pname=ProductName;
		Averagequa= AverageQua;
		Season=season;
	}


	public String GetName(){
		return(Pname);
	}

	public int GetAverageOrder(){
		return(Averagequa);
	}	
	
	public int GetID(){
		return(ProductID);
	}	

}
