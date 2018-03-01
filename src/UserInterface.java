import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jxl.write.WriteException;



public class UserInterface {

	static JFrame startscr = new JFrame();
	static JPanel startpanel = new JPanel();;
	static JButton[] buttons = new JButton[64];
	static JLabel label = new JLabel();
	static int buttoncount=0, qnum=1, buysellchoice;
	static String finalinput="";
	

	public static void main(String[] args) {
		Knowledgebase.savedata();
		initializebuttonarray();
		initializeframe();
		startpanel();
	}
	
	
	public static void initializeframe(){
		startscr.setSize(800,640);
		startscr.setTitle("Chocolate Expert System");
		startscr.setResizable(false);
		startpanel.setLayout(null);
		startscr.add(startpanel);
		startscr.setVisible(true);
	}


	public static void startpanel(){
		addbutton(startpanel,200,50,150,(startscr.getWidth()/2)-100,"start",0);
		addbutton(startpanel,200,50,250,(startscr.getWidth()/2)-100,"Solutions",6);
		addbutton(startpanel,200,50,350,(startscr.getWidth()/2)-100,"exit",5);  
	}

	

	public static void Questions(){
		startpanel.add(label);
		label.setFont (label.getFont ().deriveFont (25.0f));
		label.setText("What action do you want to perform?");
		label.setBounds(0, 10, 1000, 100);
		addbutton(startpanel,200,70,100,0,"Buy",1);
		addbutton(startpanel,200,70,100,200,"Sell",2);  
	}

	

	public static void textchange(int num, int ID){

		if(num==2){
			buttonlocationchange();
			label.setText("Whats is the product name?");
			buttons[4].setText(Knowledgebase.productarray[1].GetName());
			buttons[5].setText(Knowledgebase.productarray[2].GetName());
			buttons[6].setText(Knowledgebase.productarray[3].GetName());
			buttons[7].setText(Knowledgebase.productarray[4].GetName());

		}else if(num==3){
			label.setText("What is the stock level of this product?");
			buttons[4].setText("<html><b> Low</b><br>0-1000</html>\");\r\n" + "");
			buttons[5].setText("<html><b> Medium</b><br>1000-5000</html>\");\r\n" + "");
			buttons[6].setText("<html><b> High</b><br>5000-10000</html>\");\r\n" + "");
			buttons[7].setText("<html><b> Very high/full</b><br>10000-14000</html>\");\r\n" + "");
			

		}else if(num==4){
			label.setText("What is the season?");
			buttons[4].setText(Knowledgebase.seasonarray[1].GetName());
			buttons[5].setText(Knowledgebase.seasonarray[2].GetName());
			buttons[6].setText(Knowledgebase.seasonarray[3].GetName());
			buttons[7].setText(Knowledgebase.seasonarray[4].GetName());


		}else if(num==5){
			for(int x=5;x<8;x++){
				buttons[x].setVisible(false);
			}
			buttons[4].setText("Return");
			label.setText(InferenceEng.solution());	
			FileS.write(InferenceEng.solution());
		}else
		{
			startpanel.removeAll();
			startpanel.repaint();
		}
	}
	

	public static void addbutton(JPanel Panell, int Width, int Height,int y,int x, String text, int ID){
		buttoncount++;
		Panell.add(buttons[buttoncount]);
		Panell.add(buttons[buttoncount], BorderLayout.SOUTH);
		buttons[buttoncount].setBounds(x, y, Width, Height);
		buttons[buttoncount].setText(text);
		buttons[buttoncount].setFont (label.getFont ().deriveFont (20.0f));
		action(Panell,buttons[buttoncount],ID); 
	}

	

	public static void buttonlocationchange(){
		buttons[4].setBounds(0,100,200,70);
		buttons[5].setBounds(200,100,200,70);
		addbutton(startpanel,200,70,100,400,"",3);
		addbutton(startpanel,200,70,100,600,"",4); 
	}

	

	public static void initializebuttonarray(){
		for(int x=0;x<50;x++){
			buttons[x]=new JButton();
		}
	}
	
	public static void CreateExc(int choice) throws WriteException, IOException{
		if(choice==0){
			String path=JOptionPane.showInputDialog(null, "Enter path of the save location")+".XSL";
			CreateExcel.start(path);
			JOptionPane.showMessageDialog(null, "Excel document with solutions was saved to "+path);
		}
	}
	

	public static void action(JPanel panel,JButton name, int ID){
		name.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(ID);
				if(ID==0 ){
					startpanel.removeAll();
					startpanel.repaint();
					Questions();
				}else if(ID==5){
					System.exit(0);
				}
				else if(ID==6){
					String solutions = FileS.read(false).replace(',', ' ');
					JOptionPane.showMessageDialog(null, "<html>"+solutions);
					try {
						CreateExc(JOptionPane.showConfirmDialog(null, "Would you like to create a Excel file?"));
					} catch (HeadlessException | WriteException | IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Error- File couldn't be saved");
						e1.printStackTrace();
					}
				}
				else if (qnum==5){
					initializebuttonarray();
					buttoncount=0;
					finalinput="";
					qnum=1;
					startpanel.removeAll();
					startpanel.repaint();
					startpanel();
				}
				else{
					qnum++;
					finalinput+=ID;
					textchange(qnum,ID);
				}		
			} 		
	});
	}
}


