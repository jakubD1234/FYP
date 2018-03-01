
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileS {

	public static void write(String text){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d = new Date();
				
		  try{
			  FileWriter fstream = new FileWriter("C://Users//Jakub//workspace//Chocolate expert system//src//Solutions",true);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(text+" "+dateFormat.format(d)+",>");
			  out.newLine();
			  out.close();
		  }catch (Exception e){
			 System.err.println("Error while writing to file: " +
		          e.getMessage());
		  }
	}	
	
	
	public static String read(boolean Excelformat){
		String text="";

		File test = new File("C://Users//Jakub//workspace//Chocolate expert system//src//Solutions");
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(test);
			while(input.hasNextLine() ){
				if(Excelformat){
					text+= input.nextLine();
				}else{
					text+= "<br>"+"<br>"+input.nextLine();
				}
				
			}
		} 
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}
		System.out.println(text);
	return(text);
	}
	

}
