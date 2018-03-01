

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class CreateExcel {

    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;

public void setOutputFile(String inputFile) {
    this.inputFile = inputFile;
    }

	public String GetPath(){
		return(inputFile);
	}

    public void write() throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet);
        createContent(excelSheet);

        workbook.write();
        workbook.close();
    }

    private void createLabel(WritableSheet sheet)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        times.setWrap(true);

        // create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(
                WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);
        cv.setAutosize(true);

        // Write a few headers
        addCaption(sheet, 0, 0, "Buy/Sell");
        addCaption(sheet, 1, 0, "Quantity");
        addCaption(sheet, 2, 0, "Product");
        addCaption(sheet, 3, 0, "Sup/Cus");
        addCaption(sheet, 4, 0, "Date");

    }

    private void createContent(WritableSheet sheet) throws WriteException,
            RowsExceededException {
    	int change=0, nextrow=1;
    	String temp="";
    	
    	   for(int x=0;x<FileS.read(true).length();x++){
    		   if(FileS.read(true).charAt(x)!=',' && FileS.read(true).charAt(x)!='>'){
    			   System.out.println(FileS.read(true).charAt(x));
    			   temp+=FileS.read(true).charAt(x);
    			   System.out.println(temp);
    		   }else if(FileS.read(true).charAt(x)=='>'){
    			   change=0;
    			   temp="";
    			   nextrow++;
    		   }
    		   
    		   else{
    			   if(!temp.equals(" boxes of ") && !temp.equals(" to ") && !temp.equals(" from ")){
    				   System.out.println("add");
    		   		   addLabel(sheet, change, nextrow, temp);
    		   	       if(change==5){
    		   	    	   change=0;
    		   	       }else{
    		   	    	   change++;
    		   	       }
        		  
    			   }
    		   temp="";
    		   System.out.println("boxes of detected");
    		   }
    	   }
       
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }

    private void addNumber(WritableSheet sheet, int column, int row,
            Integer integer) throws WriteException, RowsExceededException {
        Number number;
        number = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
    }
    
    public static void start(String path) throws WriteException, IOException{
        CreateExcel test = new CreateExcel();
        test.setOutputFile(path);
        test.write();  	
    }
}