/*
 * Title: ColorDot.java
 * Files: Dots.java , DotsPanel.java
 * Semester: Fall 2016
 * 
 * Author: Yuridia Larios-Aispuro
 * Professor: Jessica Masters
 * class 111B
 * 
 * this is a designed class to storage x, y, color, and radius size.
*/

import java.awt.Color;
import java.awt.Point;

public class ColorDot extends Point{
	
	private Color dotColor;
	private int dotRadiusSize;
	

	public ColorDot(int posX, int posY, Color color, int radiusSize){
		super(posX, posY);
		
		this.dotColor = color;
		this.dotRadiusSize = radiusSize;
	}

	public Color getdotColor(){
		return dotColor;
	}
	
	public int getDotRadiusSize(){
		return dotRadiusSize;
	}
	
	public void setDotColor(Color dotColor){
		this.dotColor = dotColor;
	}
	

	public void setDotRadiusSize(int dotRadiusSize){
		if(dotRadiusSize > 0){
			this.dotRadiusSize = dotRadiusSize;
		}
		
	}
	
	
	
	

}
