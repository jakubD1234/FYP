
import java.util.Random;

public class InferenceEng {	

	static double quantity=0;
	static String answer;
	public static double calcQuantity(char ID){		

		int productnum=Character.getNumericValue(UserInterface.finalinput.charAt(1));
		//int quantitynum=Character.getNumericValue(UserInterface.finalinput.charAt(2));
		int seasonnum=Character.getNumericValue(UserInterface.finalinput.charAt(3));
		
		if(ID=='1'){
			CalcQua(productnum,seasonnum,'1',5);
			CalcQua(productnum,seasonnum,'2',5.5);
			CalcQua(productnum,seasonnum,'3',6);
			CalcQua(productnum,seasonnum,'4',6.5);
		}else if(ID=='2'){
			CalcQua(productnum,seasonnum,'1',4);
			CalcQua(productnum,seasonnum,'2',3.5);
			CalcQua(productnum,seasonnum,'3',3);
			CalcQua(productnum,seasonnum,'4',2.5);	
		}
	return(quantity);
	}
	
	public static void CalcQua(int pnum,int snum,char val,double multi) {
		if(UserInterface.finalinput.charAt(2)==val){
			quantity= Knowledgebase.productarray[pnum].GetAverageOrder()*multi*Knowledgebase.seasonarray[snum].GetPopMultiplier();
		}
	}
	
	public static String findcussup(int ID) {
		String supcus="";
		int productnum=Character.getNumericValue(UserInterface.finalinput.charAt(1)), ran;
		Random n = new Random();
		
		if(ID==1) {
			for(int y=1;y<5;y++) {
				if(Knowledgebase.productarray[productnum].GetID()==Knowledgebase.supplierarray[y].GetPopProduct()) {
					supcus=Knowledgebase.supplierarray[y].GetName();
					System.out.println("wat");
				}else {
					ran=n.nextInt(3);
					supcus=Knowledgebase.supplierarray[ran+1].GetName();
				}
			}
		}else if(ID==2){
		
			for(int y=1;y<5;y++) {
				if(Knowledgebase.productarray[productnum].GetID()==Knowledgebase.customerarray[y].GetOrderProduct()) {
					supcus=Knowledgebase.customerarray[y].GetName();
					System.out.println("wat");
				}else {
					ran=n.nextInt(3);
					supcus=Knowledgebase.customerarray[ran+1].GetName();
				}
			}
		}
		return(supcus);
	}
	
	public static String solution(){

		int productnum=Character.getNumericValue(UserInterface.finalinput.charAt(1));
		int QuantityBuy=(int) calcQuantity('1');
		int QuantitySell=(int) calcQuantity('2');
		
		if(UserInterface.finalinput.charAt(0)=='1'){
			answer="Buy, "+QuantityBuy+", boxes of ,"+Knowledgebase.productarray[productnum].GetName()+", from ,"+findcussup(1)+",";
		}else{
			answer="Sell, "+QuantitySell+", boxes of ,"+Knowledgebase.productarray[productnum].GetName()+", to ,"+findcussup(2)+",";
		}
	return(answer);	
	}


}
