/*
 * Title: Dots.java
 * Files: Dots.java , DotsPanel.java , ColorDot.java
 * Semester: Fall 2016
 * 
 * Author: Yuridia Larios-Aispuro
 * Professor: Jessica Masters
 * class 111B
 * 
 * This class contains the Gui components for a simple drawing program where the
 * user can select pens from colors red, blue, yellow, white(to act as an eraser) 
 * and also from a clear all button. */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dots extends JPanel {

	private JButton redrawButton;
	private JRadioButton redPen, bluePen, yellowPen, eraser;
	private DotsPanel drawingPanel;



	public Dots(DotsPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		

		// set the background color to predetermined color
		setBackground(Color.BLACK);	


		// red pen properties:
		redPen = new JRadioButton("Red Pen",true);
		redPen.setBackground(Color.BLACK);
		redPen.setForeground(Color.WHITE);
		this.add(redPen);
		redPen.addActionListener(new OptionListener());

		// blue pen properties:
		bluePen = new JRadioButton("Blue Pen");
		bluePen.setBackground(Color.BLACK);
		bluePen.setForeground(Color.WHITE);
		this.add(bluePen);
		bluePen.addActionListener(new OptionListener());

		// yellow pen properties:
		yellowPen = new JRadioButton("Yellow Pen");
		yellowPen.setBackground(Color.BLACK);
		yellowPen.setForeground(Color.WHITE);
		this.add(yellowPen);
		yellowPen.addActionListener(new OptionListener());

		// eraser(really a white pen) properties:
		eraser = new JRadioButton("Eraser");
		eraser.setBackground(Color.BLACK);
		eraser.setForeground(Color.WHITE);
		this.add(eraser);
		eraser.addActionListener(new OptionListener());

		// add all radio buttons to the same group
		ButtonGroup group = new ButtonGroup();
		group.add(redPen);
		group.add(bluePen);
		group.add(yellowPen);
		group.add(eraser);
		

		// button to Erase all properties:
		redrawButton = new JButton("Erase All");
		this.add(redrawButton);
		redrawButton.addActionListener(new ButtonListener());

	}
	
	

	
	// listener to see which radio button is selected and so set 
	// its corresponding variable to be true on DotsPanel drawingPanel object
	private class OptionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			if (redPen.isSelected()) {
				drawingPanel.setDrawInRed(true);
				
			} else if (bluePen.isSelected()) {
				drawingPanel.setDrawInBlue(true);
				
			} else if (yellowPen.isSelected()) {
				drawingPanel.setDrawInYellow(true);
				
			} else if (eraser.isSelected()) {
				drawingPanel.setErase(true);

			}

		}
	}
	
	
	
	
	
	
	// calls upon the erase() method on the DotsPanel drawingPanel object 
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			drawingPanel.erase();
		}
	}

	
	
	
	
	
	// main method
	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Draw Now!");
				frame.setSize(1200, 700);
				
				// create an object of your class and another panel
				// from the Dots class
				DotsPanel dPanel = new DotsPanel();
				Dots cPanel = new Dots(dPanel);

				// creates the layout for both panels
				frame.getContentPane().add(dPanel, BorderLayout.CENTER);
				frame.getContentPane().add(cPanel, BorderLayout.SOUTH);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame.setVisible(true);
			}
		});
	}
}
