//CS350, Project #1, your name, a description of the program at the beginning
//Project #1
// Blair Kiel
//This is a program to create 3 different shapes
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Shapes extends JPanel{

	private int choice;
	private int numAcross;
	private int numDown;
	private int size;
	int[] possibleRotations = {90, 180};

	public Shapes( int tileChoice, int tileSize)
	{
		//using the same variables
		choice = tileChoice;
		size = tileSize;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent( g );
   		  Random random = new Random();
	      g.setColor(Color.black);
	      numAcross = getWidth() / size;
	      numDown = getHeight() / size;
	      for ( int i = 0; i < (size*numDown) + 2; i += size )
	      {
	    	  for ( int j = 0; j < (size*numAcross) + 2; j += size)
	    	  {
	    		  int rotationStartNum1 = random.nextInt(possibleRotations.length);
	    		  int rotationStart1 = 0;
	    		  int rotationStart2 = 0;
	    		  int rotationEnd1 = 0;
	    		  int rotationEnd2 = 0;
	    		  int skew1x = 0;
	    		  int skew1y = 0;
	    		  int skew2x = 0;
	    		  int skew2y = 0;

	    		  int line1PX1 = 0;
	    		  int line1PY1 = 0;
	    		  int line1PX2 = 0;
	    		  int line1PY2 = 0;
	    		  int line2PX1 = 0;
	    		  int line2PY1 = 0;
	    		  int line2PX2 = 0;
	    		  int line2PY2 = 0;
	    		  int line3PX1 = 0;
	    		  int line3PY1 = 0;
	    		  int line3PX2 = 0;
	    		  int line3PY2 = 0;
	    		  int line4PX1 = 0;
	    		  int line4PY1 = 0;
	    		  int line4PX2 = 0;
	    		  int line4PY2 = 0;
	    		  int line5PX1 = 0;
	    		  int line5PY1 = 0;
	    		  int line5PX2 = 0;
	    		  int line5PY2 = 0;
	    		  
	    		  int line6X1 = 0;
	    		  int line6Y1 = 0;
	    		  int line6X2 = 0;
	    		  int line6Y2 = 0;
	    				  
	    		  
	    		  rotationStart1 = possibleRotations[rotationStartNum1];
	    		  if(rotationStart1 == 90){
	    			  rotationEnd1 = 90;
	    			  rotationStart2 = 270;
	    			  rotationEnd2 = 90;
	    			  skew1x = +(size/2);
	    			  skew1y = +(size/2);
	    			  skew2x = -(size/2);
	    			  skew2y = -(size/2);

	    			  line1PX1 = 0;
	    			  line1PY1 = 0;
	    			  line1PX2 = +(size/4);
	    			  line1PY2 = +(size/2);
	    			  line2PX1 = 0;
	    			  line2PY1 = +size;
	    			  line2PX2 = +(size/4);
	    			  line2PY2 = +(size/2);
	    			  line3PX1 = +(size/4);
	    			  line3PY1 = +(size/2);
	    			  line3PX2 = (9*size/12);
	    			  line3PY2 = (size/2);
	    			  line4PX1 = (9*size/12);
	    			  line4PY1 = (size/2);
	    			  line4PX2 = size;
	    			  line4PY2 = 0;
	    			  line5PX1 = (9*size/12);
	    			  line5PY1 = (size/2);
	    			  line5PX2 = size;
	    			  line5PY2 = size;
	    			  
	    			  line6X1 = 0;
	    			  line6Y1 = 0;
	    			  line6X2 = size;
	    			  line6Y2 = size;
	    		  }
	    		  else if(rotationStart1 == 180){
	    			  rotationEnd1 = 90;
	    			  rotationStart2 = 360;
	    			  rotationEnd2 = 90;
	    			  skew1x = +(size/2);
	    			  skew1y = -(size/2);
	    			  skew2x = -(size/2);
	    			  skew2y = +(size/2);
	    			  
	    			  line1PX1 = 0;
	    			  line1PY1 = 0;
	    			  line1PX2 = (size/2);
	    			  line1PY2 = (size/4);
	    			  line2PX1 = 0;
	    			  line2PY1 = size;
	    			  line2PX2 = (size/2);
	    			  line2PY2 = (9*size/12);
	    			  line3PX1 = (size/2);
	    			  line3PY1 = (size/4);
	    			  line3PX2 = (size/2);
	    			  line3PY2 = (9*size/12);
	    			  line4PX1 = (size/2);
	    			  line4PY1 = (size/4);
	    			  line4PX2 = (size);
	    			  line4PY2 = 0;
	    			  line5PX1 = (size/2);
	    			  line5PY1 = (size*9/12);
	    			  line5PX2 = size;
	    			  line5PY2 = size;
	    			  
	    			  line6X1 = size;
	    			  line6Y1 = 0;
	    			  line6X2 = 0;
	    			  line6Y2 = size;
	    		  };
	    		  
	    		  
	    		  
	         // pick the shape based on the user's choice
	    		  switch ( choice )
                  {
                  	case 1: //draw two 90 degree arcs
                  		g.drawArc(j + skew1x, i + skew1y, size, size, rotationStart1, rotationEnd1);
                  		g.drawArc(j + skew2x, i + skew2y, size, size, rotationStart2, rotationEnd2);
                  		break;
                  	case 2: //draw line figure
                  		g.drawLine (line1PX1 + j, line1PY1 + i, line1PX2 + j, line1PY2 + i);
                  		g.drawLine (line2PX1 + j, line2PY1 + i, line2PX2 + j, line2PY2 + i);
                  		g.drawLine (line3PX1 + j, line3PY1 + i, line3PX2 + j, line3PY2 + i);
                  		g.drawLine (line4PX1 + j, line4PY1 + i, line4PX2 + j, line4PY2 + i);
                  		g.drawLine (line5PX1 + j, line5PY1 + i, line5PX2 + j, line5PY2 + i);
                  	case 3:
                  		g.drawLine(line6X1 + j, line6Y1 + i, line6X2 + j, line6Y2 + i);
                        break;
                  }
	    	  } // end switch
	      } // end for
	      
	      // added by Zhang
	      // end of addition
	}
}
