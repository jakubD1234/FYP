public class Knowledgebase {

	
	static product productarray[] = new product[64];
	static customer customerarray[] = new customer[64];
	static supplier supplierarray[] = new supplier[64];
	static Season seasonarray[] = new Season[64];
	static String answer;


	public static void products(){
		productarray[1]= new product(300,"Mini eggs",230,"winter");
		productarray[2]= new product(301,"Freddo",303,"summer");
		productarray[3]= new product(302,"Dairy Milk",234,"winter");
		productarray[4]= new product(303,"Fudge",504,"spring");
	}

	
	public static void customers(){
		customerarray[1]= new customer("Tesco","Oldbrook Milton Keynes",300);
		customerarray[2]= new customer("Morrisons","Westcroft Milton Keynes",302);
		customerarray[3]= new customer("Premier","Oldbrook Milton Keynes",302);
		customerarray[4]= new customer("Asda","Bletchey Milton Keynes",301);	 
	}


	public static void suppliers(){
		supplierarray[1]= new supplier("Mondelez.E","England,birmingham",303);
		supplierarray[2]= new supplier("Mondelez.I","Irland",301);
		supplierarray[3]= new supplier("Mondelez.P","Poland",303);
		supplierarray[4]= new supplier("Barry Callebaut","Belgium",302);	 
	}

	
	public static void seasons(){
		seasonarray[1]= new Season("First Term",1.4);
		seasonarray[2]= new Season("Second Term",1.2);
		seasonarray[3]= new Season("Third Term",3.1);
		seasonarray[4]= new Season("Fourth Term",5.2);	 
	}
	

	public static void savedata(){
		products();
		customers();
		suppliers();
		seasons();
	}

}
