import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class EditGUI extends JFrame implements ActionListener{

	CDriver editingCust;
	Integer index;
	String custNo;
	String custName;
	String custYearsDriving;
	String custOwnsJeep;
	String custModel;
	String custTrans;

	//Labels
	JLabel custNoLabel;
	JLabel custNameLabel;
	JLabel custDriveYearsLabel;
	JLabel custOwnsJeepLabel;
	JLabel custModelLabel;
	JLabel custTransmissionLabel;

	//Controls
	JLabel customerNumControl;
	JTextField customerNameControl;
	JTextField customerDrivingYearsControl;
	JRadioButton cbYes;
	JRadioButton cbNo;
	JRadioButton compassBut;
	JRadioButton gCherokeeBut;
	JRadioButton patriotBut;
	JRadioButton renegadeBut;
	JRadioButton othersBut;
	JRadioButton fiveSpeedManBut;
	JRadioButton sixSpeedManBut;
	JRadioButton eightSpeedAutoBut;
	JRadioButton dontCareBut;
	JButton submitButton;
	JButton cancelButton;

	public EditGUI(CDriver editingCustomer){

		super();

		editingCust = editingCustomer;
		JFrame f = new JFrame("Edit Driver Information");
		f.setSize(700, 600);
		f.setVisible(true);

		Container c = f.getContentPane();
		c.setLayout(null);

		//Labels
		custNoLabel = new JLabel("Customer No.");
		custNoLabel.setSize(100, 50);
		custNoLabel.setLocation(20, 20);
		c.add(custNoLabel);

		custNameLabel = new JLabel("Customer Name");
		custNameLabel.setSize(200, 50);
		custNameLabel.setLocation(20, 80);
		c.add(custNameLabel);

		custDriveYearsLabel = new JLabel("How many years have you been driving?");
		custDriveYearsLabel.setSize(250, 50);
		custDriveYearsLabel.setLocation(20, 140);
		c.add(custDriveYearsLabel);

		custOwnsJeepLabel = new JLabel("Do you have a Jeep?");
		custOwnsJeepLabel.setSize(150, 50);
		custOwnsJeepLabel.setLocation(20, 200);
		c.add(custOwnsJeepLabel);

		custModelLabel = new JLabel("Which models are you interested in?");
		custModelLabel.setSize(250,50);
		custModelLabel.setLocation(20, 275);
		c.add(custModelLabel);

		custTransmissionLabel = new JLabel("Transmission: ");
		custTransmissionLabel.setSize(150, 50);
		custTransmissionLabel.setLocation(20, 350);
		c.add(custTransmissionLabel);

		//Controls
		custNo= editingCust.getCustomerNum();
		customerNumControl = new JLabel(custNo);
		customerNumControl.setSize(250, 50);
		customerNumControl.setLocation(150, 20);
		c.add(customerNumControl);

		customerNameControl = new JTextField();
		customerNameControl.setSize(250, 50);
		customerNameControl.setLocation(150, 80);
		c.add(customerNameControl);

		customerDrivingYearsControl = new JTextField();
		customerDrivingYearsControl.setSize(50, 50);
		customerDrivingYearsControl.setLocation(300, 140);
		c.add(customerDrivingYearsControl);

		cbYes = new JRadioButton("Yes");
		cbNo = new JRadioButton("No");
		cbYes.setSize(75, 25);
		cbYes.setLocation(40, 250);
		cbNo.setSize(50, 25);
		cbNo.setLocation(140, 250);
		ButtonGroup customerOwnsJeep = new ButtonGroup();
		customerOwnsJeep.add(cbYes);
		customerOwnsJeep.add(cbNo);
		c.add(cbYes);
		c.add(cbNo);

		compassBut = new JRadioButton("Compass");
		compassBut.setSize(100, 50);
		compassBut.setLocation(40, 315);
		c.add(compassBut);

		gCherokeeBut = new JRadioButton("Grand Cherokee");
		gCherokeeBut.setSize(150, 50);
		gCherokeeBut.setLocation(150, 315);
		c.add(gCherokeeBut);

		patriotBut = new JRadioButton("Patriot");
		patriotBut.setSize(100, 50);
		patriotBut.setLocation(300, 315);
		c.add(patriotBut);

		renegadeBut = new JRadioButton("Renegade");
		renegadeBut.setSize(100, 50);
		renegadeBut.setLocation(400, 315);
		c.add(renegadeBut);

		othersBut = new JRadioButton("Others");
		othersBut.setSize(100, 50);
		othersBut.setLocation(500, 315);
		c.add(othersBut);


		fiveSpeedManBut = new JRadioButton("5-Speed Manual");
		fiveSpeedManBut.setSize(135, 50);
		fiveSpeedManBut.setLocation(40, 400);
		c.add(fiveSpeedManBut);

		sixSpeedManBut = new JRadioButton("6-Speed Manual");
		sixSpeedManBut.setSize(150, 50);
		sixSpeedManBut.setLocation(175, 400);
		c.add(sixSpeedManBut);

		eightSpeedAutoBut = new JRadioButton("8-Speed Paddle-Shift Automatic");
		eightSpeedAutoBut.setSize(250, 50);
		eightSpeedAutoBut.setLocation(325, 400);
		c.add(eightSpeedAutoBut);

		dontCareBut = new JRadioButton("Don't Care");
		dontCareBut.setSize(150, 50);
		dontCareBut.setLocation(575, 400);
		c.add(dontCareBut);

		ButtonGroup customerTransmission = new ButtonGroup();
		customerTransmission.add(fiveSpeedManBut);
		customerTransmission.add(sixSpeedManBut);
		customerTransmission.add(eightSpeedAutoBut);
		customerTransmission.add(dontCareBut);


		submitButton = new JButton("Submit");
		submitButton.setSize(250, 50);
		submitButton.setLocation(50, 500);
		submitButton.addActionListener(this);
		c.add(submitButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setSize(250, 50);
		cancelButton.setLocation(350, 500);
		cancelButton.addActionListener(this);
		c.add(cancelButton);

		customerNameControl.setText(editingCustomer.customerName);
		customerDrivingYearsControl.setText(editingCustomer.drivingYears);
		if(editingCustomer.jeepOwner == "Yes"){
			cbYes.setSelected(true);
		}
		else{
			cbNo.setSelected(true);
		}

		if(Arrays.asList(editingCustomer.modelsArray).contains("C")){
			compassBut.setSelected(true);
		}
		else{
			compassBut.setSelected(false);
		}
		if(Arrays.asList(editingCustomer.modelsArray).contains("G")){
			gCherokeeBut.setSelected(true);
		}
		else{
			gCherokeeBut.setSelected(false);
		}
		if(Arrays.asList(editingCustomer.modelsArray).contains("P")){
			patriotBut.setSelected(true);
		}
		else{
			patriotBut.setSelected(false);
		}
		if(Arrays.asList(editingCustomer.modelsArray).contains("R")){
			renegadeBut.setSelected(true);
		}
		else{
			renegadeBut.setSelected(false);
		}
		if(Arrays.asList(editingCustomer.modelsArray).contains("O")){
			othersBut.setSelected(true);
		}
		else{
			othersBut.setSelected(false);
		}

		if(editingCustomer.transmission == "5-Man"){
			fiveSpeedManBut.setSelected(true);
		}
		else if(editingCustomer.transmission == "6-Man"){
			sixSpeedManBut.setSelected(true);
		}
		else if(editingCustomer.transmission == "8-Auto"){
			eightSpeedAutoBut.setSelected(true);
		}
		else if(editingCustomer.transmission == "Don't Care"){
			dontCareBut.setSelected(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitButton){
			custNo = customerNumControl.getText();
			custName = customerNameControl.getText();
			custYearsDriving = customerDrivingYearsControl.getText();

			if(cbYes.isSelected()){
				custOwnsJeep = "Yes";
			}
			else{
				custOwnsJeep = "No";
			}

			String custModel = "";
			if(compassBut.isSelected()){
				custModel += "C";
			}
			else{
				custModel += "-";
			}
			if(gCherokeeBut.isSelected()){
				custModel += "G";
			}
			else{
				custModel += "-";
			}
			if(patriotBut.isSelected()){
				custModel += "P";
			}
			else{
				custModel += "-";
			}
			if(renegadeBut.isSelected()){
				custModel += "R";
			}
			else{
				custModel += "-";
			}
			if(othersBut.isSelected()){
				custModel += "O";
			}
			else{
				custModel += "-";
			}


			String custTrans = "";
			if(fiveSpeedManBut.isSelected()){
				custTrans = "5-Man";
			}
			else if(sixSpeedManBut.isSelected()){
				custTrans = "6-Man";
			}
			else if(eightSpeedAutoBut.isSelected()){
				custTrans = "8-Auto";
			}
			else{
				custTrans = "Don't Care";
			}

			CDriver appendedCust = new CDriver(custNo, custName, custYearsDriving, custOwnsJeep, custModel, custTrans);
			index = JeepGUI.customerList.indexOf(editingCust);
			JeepGUI.customerList.remove(editingCust);
			JeepGUI.customerList.add(index, appendedCust);
			JeepGUI.model.setElementAt(appendedCust.getCustomerData(), index);
			JeepGUI.list.setModel(JeepGUI.model);
			Frame f;
			f = getActiveFrame();
			f.setVisible(false);
			f.dispose();
		}
		else if(e.getSource()==cancelButton){
			Frame f;
			f = getActiveFrame();
			f.setVisible(false);
			f.dispose();

		}

	}
	public Frame getActiveFrame(){
		Frame[] f = Frame.getFrames();
		Frame active = null;
		for (int i = 0; i < f.length; i++) {
			if (f[i].isActive()) {
				active = f[i]; 
			}
		}
		return active;
	}
}
