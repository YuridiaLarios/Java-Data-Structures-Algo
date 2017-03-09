/*
 * Title: DotsPanel.java
 * Files: Dots.java , DotsPanel.java , ColorDot.java
 * Semester: Fall 2016
 * 
 * Author: Yuridia Larios-Aispuro
 * Professor: Jessica Masters
 * class 111B
 * 
 * This class contains the instructions to draw in different colors by using an arraylist
 * of ColorDot object which stores x, y, color, and radius size; it also uses both mouseListener
 * to detect when the users clicks, and mouseMotionListener to detect when the mouse is moving. and
 * uses the paint component to draw each oval.*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.ArrayList;

public class DotsPanel extends JPanel implements MouseListener {

	private boolean redPenColor = true,  paintOn;
	private Color backgroundColor = (Color.WHITE);			// predetermined color for background
	private Color penColor;
	private ArrayList<ColorDot> dotList;
	private int radiusSize = 30;


	public DotsPanel() {

		// set the background of this panel color white
		setBackground(backgroundColor);

		// made of ColorDot objects that hold x, y, and color.
		dotList = new ArrayList<ColorDot>();

		// calls on the class to listen to when the user clicks
		addMouseListener(new clickListener());

		// calls on the class to listen to the movement of the cursor.
		addMouseMotionListener(new dotsListener());

	}
	
	// draws all of the dots stored in the list after checking if 
	// the user has click once, it also checks if the initial color is
	// red.
	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		if (paintOn){
			
			if (redPenColor) {
				page.setColor(Color.RED);
			}

			for (ColorDot spot : dotList) {
				page.setColor(spot.getdotColor());
				page.fillOval(spot.x, spot.y, radiusSize, radiusSize);			

			}

		}
	
	
	}

	// methods to determine which color to set from the radio buttons
	public void setDrawInRed(boolean drawInColorRed) {
		penColor = Color.RED;

	}

	public void setDrawInBlue(boolean drawInColorBlue) {
		penColor = Color.BLUE;
	}

	public void setDrawInYellow(boolean drawInColorYellow) {
		penColor = Color.YELLOW;
	}

	public void setErase(boolean erase) {
		penColor = Color.WHITE;

	}
	
	
	
	
	// method to empty the array and erase all
	public void erase() {
		dotList.clear();
		repaint();

	}

	
	
	
	// when the user clicks one, it allows him to paint 
	// if he clicks again it stops painting.
	class clickListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			
			if (!paintOn) {
				paintOn = true;
			} else
				paintOn = false;

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	// first it checks if the user has click once to start painting
	// then as the user moves the mouse, each x and y gets recorded to 
	// create a new ColorDot object, including the selected color and
	// radius size.
	class dotsListener implements MouseMotionListener {
		public void mouseMoved(MouseEvent event) {

			if (paintOn) {
				
				repaint();
				
				Point point = event.getPoint();
				ColorDot dot = new ColorDot(point.x,point.y, penColor, radiusSize);
				dotList.add(dot);
				
				
			}

		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
