package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class MainView implements ActionListener {
	
	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private JButton indstillingsKnap = null;
	private JButton foresp¿rgelsesKnap = null;
	private JPanel topPane = null;
	private Panel hovedPane = null;
	
	private CardLayout typeLayout;
	
	private Panel indramning, opsp¾nding = null;
	private Panel buttonP = null;
	private Panel orderPane = null;
	private JButton indramningsKnap, opsp¾ndingsKnap = null;
	private Panel dummyPanel = null;
	
	private Panel opsumering = null;
	
	private JLabel opsumeringsTekst = null;
	private JLabel indramningsTekst = null;
	private JLabel opsp¾ndingsTekst = null;
	
	private Dimension knap;
	private Dimension minimumWindow;
	
	private int numOrders;
	
	private HashMap<Integer, JButton> buttons;
	private HashMap<JButton, test> models;
	
	private test currentModel;
	
	public MainView(){
		numOrders = 1;
		knap = new Dimension(175,25);
		minimumWindow = new Dimension(400,300);
		buttons = new HashMap<Integer, JButton>();
		models = new HashMap<JButton, test>();
		createNewOrder();
	}

	
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setSize(900, 600);
			jFrame.setMinimumSize(minimumWindow);
			jFrame.setResizable(true);
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
	}
	
	private JPanel getTopPane() {
		if (topPane == null) {
			topPane = new JPanel();
			topPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			topPane.setPreferredSize(new Dimension(0,100));
			topPane.add(getForesp¿rgelsesKnap());
			topPane.add(getIndstillingsKnap());
			topPane.setBackground(Color.WHITE);
		}
		return topPane;
	}
	
	private Panel getHovedPane() {
		if (hovedPane == null) {
			hovedPane = new Panel();
			typeLayout = new CardLayout();
			hovedPane.setLayout(typeLayout);
			hovedPane.add(getIndramning(), getIndramningsKnap().getName());
			hovedPane.add(getOpsp¾nding(), getOpsp¾ndningsKnap().getName());
		}
		return hovedPane;
	}
	
	private Panel getDummyPanel() {
		if (dummyPanel == null) {
			dummyPanel = new Panel();
			dummyPanel.setLayout(new BorderLayout());
			dummyPanel.add(getHovedPane(), BorderLayout.CENTER);
		    dummyPanel.add(getButtonP(), BorderLayout.SOUTH);
		    dummyPanel.add(getOrderPane(), BorderLayout.NORTH);
		    dummyPanel.add(getOpsumering(), BorderLayout.AFTER_LINE_ENDS);
		}
		return dummyPanel;
	}
	
	private JLabel getOpsumeringsTekst(){
		if (opsumeringsTekst == null) {
			opsumeringsTekst = new JLabel();
		}
		return opsumeringsTekst;
	}
	
	private JLabel getIndramningsTekst(){
		if (indramningsTekst == null) {
			indramningsTekst = new JLabel("Indramnings Panel");
		}
		return indramningsTekst;
	}
	
	private JLabel getOpsp¾ndingsTekst(){
		if (opsp¾ndingsTekst == null) {
			opsp¾ndingsTekst = new JLabel("Opsp¾ndings Panel");
		}
		return opsp¾ndingsTekst;
	}
	
	private Panel getIndramning() {
		if (indramning == null) {
			indramning = new Panel();
			indramning.setBackground(Color.WHITE);
			indramning.add(getIndramningsTekst());
		}
		return indramning;
	}
	
	private Panel getOpsp¾nding() {
		if (opsp¾nding == null) {
			opsp¾nding = new Panel();
			opsp¾nding.setBackground(Color.WHITE);	
			opsp¾nding.add(getOpsp¾ndingsTekst());
		}
		return opsp¾nding;
	}
	
	private Panel getButtonP() {
		if (buttonP == null) {
			buttonP = new Panel();
			buttonP.add(getOpsp¾ndningsKnap());
			buttonP.add(getIndramningsKnap());
		}
		return buttonP;
	}
	
	private Panel getOpsumering() {
		if (opsumering == null) {
			opsumering = new Panel();
			opsumering.setBackground(Color.BLUE);
			opsumering.add(getOpsumeringsTekst());
			opsumering.setPreferredSize(new Dimension(200,100));
		}
		return opsumering;
	}
	
	private Panel getOrderPane() {
		if (orderPane == null) {
			orderPane = new Panel();
		}
		return orderPane;
	}
	
	private JButton getIndramningsKnap(){
		if(indramningsKnap == null){
			indramningsKnap = new JButton("indramning");
			indramningsKnap.setName("indramning");
			indramningsKnap.addActionListener(this);
		}
		
		return indramningsKnap;
	}
	
	private JButton getOpsp¾ndningsKnap(){
		if(opsp¾ndingsKnap == null){
			opsp¾ndingsKnap = new JButton("opsp¾nding");
			opsp¾ndingsKnap.setName("opsp¾nding");
			opsp¾ndingsKnap.addActionListener(this);
		}
		
		return opsp¾ndingsKnap;
	}
	

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getTopPane(), BorderLayout.NORTH);
			jContentPane.add(getDummyPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	private JButton getIndstillingsKnap(){
		if(indstillingsKnap == null){
			indstillingsKnap = new JButton();
			indstillingsKnap.setText("Indstillinger");
			indstillingsKnap.setPreferredSize(knap);
		}
		
		return indstillingsKnap;
	}
	
	private JButton getForesp¿rgelsesKnap(){
		if(foresp¿rgelsesKnap == null){
			foresp¿rgelsesKnap = new JButton();
			foresp¿rgelsesKnap.setText("Ny Foresp¿rgelse");
			foresp¿rgelsesKnap.setPreferredSize(knap);
			foresp¿rgelsesKnap.addActionListener(this);
		}
		
		return foresp¿rgelsesKnap;
	}
	
	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainView application = new MainView();
				application.getJFrame().setVisible(true);
			}
		});
	}
	
	public void createNewOrder(){
		JButton tempButton = new JButton("Order " + Integer.toString(numOrders));
		tempButton.setName(Integer.toString(numOrders));
		tempButton.addActionListener(this);
		buttons.put(numOrders, tempButton);
		tempButton.setMaximumSize(knap);
		getOrderPane().add(tempButton);
		
		currentModel = new test(Integer.toString(numOrders));
		models.put(tempButton, currentModel);
		
		tempButton = null;
		
		nyOrderValgt();
		numOrders++;
	}
	
	public test getModel(int buttonNum){
		return models.get(buttons.get(buttonNum));
	}
	
	public void nyOrderValgt(){
		getOpsumeringsTekst().setText(currentModel.getName());
		getJFrame().validate();
	}
	
	public Boolean isInteger(String s){
		try
		{
		Integer.parseInt(s);
		return true;
		}
		catch(NumberFormatException nfe)
		{
		return false;
		}
	}
	
	 public void actionPerformed(ActionEvent e)
	  {	
		 String eName = ((JButton) e.getSource()).getName();
		 if(e.getSource() == foresp¿rgelsesKnap){
			 createNewOrder();
		 }
		 
		 if (isInteger(eName)){
			 int buttonNum = Integer.parseInt(eName);
			 currentModel = getModel(buttonNum);
			 nyOrderValgt();
		 }
			
		 else{
			 typeLayout.show(hovedPane, eName);
			 }
		 
	  }
}
