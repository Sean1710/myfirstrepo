import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class myfirstgui implements ActionListener{

//Properties
//Make window frame then make the glass that goes into the frame
//Then add stuff on top of the glass

	public JFrame theframe;
	public JPanel thepanel;
	public JButton thebutton;
	public JLabel thelabel;
	public Timer thetimer;
	public Reset resetBut;
	
//Method
//Implementing actionlistener will force you to override the abstract method actionperformed

	//Say the button was pressed
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == this.thebutton){
			System.out.println("the button was pressed");
			String strNumber = this.thelabel.getText();
			int intNumber = Integer.parseInt(strNumber);
			intNumber++;
			strNumber = intNumber + "";
			this.thelabel.setText(strNumber);
		}else if(evt.getSource() == this.thetimer){
			this.thebutton.setEnabled(false);	
		}else if(evt.getSource() == this.resetBut){
		this.thetimer.restart();
		this.thetimer.stop();
		this.thelabel.setText("0");
		this.resetBut.setEnabled(flase);
		this.thebutton.setEnabled(true);
	
}


//Constructor

	public myfirstgui(){
			
		//Make Frame
		this.thetimer = new Timer(60000, this);
		this.thetimer.start();

		this.theframe = new JFrame();
		this.theframe.setTitle("thats it");
		this.theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Make panel/glass size
		this.thepanel = new JPanel();	
		this.thepanel.setPreferredSize(new Dimension(400, 400));
		this.theframe.setContentPane(this.thepanel);
		this.theframe.pack();
		this.theframe.setVisible(true);		
			
		//Make button
		this.thebutton = new JButton("Click here to Subscribe");
		
		//By default Jcomponenets are not listened to, use method actionlistener to listen
		this.thebutton.addActionListener(this);	

		this.thepanel.add(this.thebutton);
		this.thelabel = new JLabel("0");
		this.thepanel.add(this.thelabel);

		this.theframe.setContentPane(this.thepanel);

	}
//Main method

	public static void main(String[] args){
		new myfirstgui();
	}


}


































