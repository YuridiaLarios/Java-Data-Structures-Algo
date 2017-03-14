/*
 * Title: GUIRecursion.java
 * Semester: Spring 2017
 * 
 * Author: Yuridia Larios 
 * 
 * This is a GUI stadnalone program that uses recursion to draw squares- one square on the corner of each square. 
 */
import java.awt.*;
import javax.swing.*;

public class GUIRecursion extends JPanel {
	static int initialSideSize = 250;
	static int minimumSideSize = 10 ;
	static int shrinkFactor = 2;
	
	int windowSize = 500;

	public GUIRecursion() {
		super();
		setBackground(Color.white);
		setPreferredSize(new Dimension(windowSize, windowSize));
	}

	public void paintComponent(Graphics pen) {
		int x = 250 - 200/shrinkFactor;			// x-coordinate
		int y = 250 - 200/shrinkFactor;			// y-coordinate
		int w = initialSideSize;							// width
		int h = initialSideSize;							// Height

		super.paintComponent(pen);
		{
			if(initialSideSize > 0){	
			drawRectangle(pen, x, y, w, h);		
			}
		}
	}
	
	private static void drawRectangle(Graphics pen, int x, int y, int w, int h) {
		
		// base case
		if(h <= minimumSideSize){
			if(h==minimumSideSize){
				pen.drawRect(x, y, w, h);
			}
			
		} else{    // recursive case
			drawRectangle(pen, x-(w/(shrinkFactor*2)), y - (h/(shrinkFactor*2)), w/shrinkFactor, h/shrinkFactor);
			drawRectangle(pen, x + w -(w/(shrinkFactor*2)), y - (h/(shrinkFactor*2)), w/shrinkFactor, h/shrinkFactor);
			drawRectangle(pen, x-(w/(shrinkFactor*2)), y+h - (h/(shrinkFactor*2)), w/shrinkFactor, h/shrinkFactor);
			drawRectangle(pen, x + w -(w/(shrinkFactor*2)), y +h - (h/(shrinkFactor*2)), w/shrinkFactor, h/shrinkFactor);

			pen.drawRect(x, y, w, h);
		}
	}
	
	public static void main(String[] args) {
		GUIRecursion panel = new GUIRecursion();

		JFrame frame = new JFrame("GUI Program");
		frame.getContentPane().add(panel);
		frame.setSize(570, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
