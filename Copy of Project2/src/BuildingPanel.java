import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import java.util.*;

public class BuildingPanel extends JPanel
	implements MouseListener, MouseMotionListener{
		
	//state representations
	private ArrayList<BuildingBlock> originals;
	private ArrayList<BuildingBlock> duplicates;
	
	private BuildingBlock BlockToBeMoved;
	private int m_nOffsetX;
	private int m_nOffsetY;
	
	//double buffering
	private Image backBuffer;
	private Graphics gBackBuffer;
	
	private int curDuplicate;
	private int curOriginal;
	
	boolean isInitialized;
	
	//init and register mouse event handler
	public BuildingPanel()
	{
		isInitialized=false;
		//handle mouse and mouse motion events
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	void init()
	{
		//Initial state
		duplicates = new ArrayList<BuildingBlock>();
		originals = new ArrayList<BuildingBlock>();
		Color[] colors = {Color.red, Color.green, Color.blue, Color.magenta, Color.cyan, Color.yellow};
		int count=colors.length;
		int dx=10;
		int dy=10;
		int gap=20;
		int length=(getSize().width-2*dx-(count-1)*gap)/count;
		for (int i = 0; i<count; i++){
			originals.add(new BuildingBlock((i<count/2)?0:1, dx+i*(length+gap), dy, length, length, colors[i]));
		}
		BlockToBeMoved=null;//no shape
		
		// create the back buff
		backBuffer = createImage(getSize().width, getSize().height);
		gBackBuffer = backBuffer.getGraphics();
	}
	

	//State Presentation
	public void paintComponent(Graphics g)
	{
		if (!isInitialized) {
			isInitialized=true;
			init();
		}
		//State presentation using double buffer
		//First, clear the back buffer
		gBackBuffer.setColor(Color.white);
		gBackBuffer.clearRect(0, 0, getSize().width, getSize().height);
		
		//draw the originals to back buffers
		for (int i=0; i<originals.size(); i++) {
			originals.get(i).draw(gBackBuffer);
		}
		// draw the duplicates to back buffer
		for (int i=0; i<duplicates.size(); i++) {
			duplicates.get(i).draw(gBackBuffer);
		}
		
		g.drawImage(backBuffer, 0, 0, null);
	}

	public void mouseClicked(MouseEvent e)
	{
		if (e.isMetaDown()) {
			for (int i=duplicates.size()-1; i>=0;i--){
				BuildingBlock p=duplicates.get(i);
				if (p.hitTest(e.getX(),e.getY())){
					duplicates.remove(i);
					repaint();
					break;
				}
			}
		}
	}
		
	public void mousePressed( MouseEvent e )
    {
    	if (e.isMetaDown()) return;	// ignore right button
        
		// First, check the originals, from top down (i.e. back to front)
	
		for (int i=duplicates.size()-1; i>=0; i--){
			BuildingBlock p=duplicates.get(i);
			if (p.hitTest(e.getX(),e.getY())) {
				duplicates.remove(i);
				duplicates.add(p);	// move to the end, i.e. the top
				BlockToBeMoved=p;
				m_nOffsetX=e.getX()-BlockToBeMoved.getX();
				m_nOffsetY=e.getY()-BlockToBeMoved.getY();
				repaint();
				return;
			}
		}
		// Second, check the orignals 
        for (int j=originals.size()-1; j>=0; j--){
            BuildingBlock p=originals.get(j);
			if (p.hitTest(e.getX(), e.getY())) {
				BuildingBlock p2=new BuildingBlock(p); // make a copy of p
				duplicates.add(p2);	// add to the end
				BlockToBeMoved=p2;	// p2 is selected, to be moved
				m_nOffsetX=e.getX()-BlockToBeMoved.getX();
				m_nOffsetY=e.getY()-BlockToBeMoved.getY();
				repaint();
				return;
			}
        }
	}
	

	public void move(int dx, int dy){ 
		BlockToBeMoved.setX(dx);
		BlockToBeMoved.setY(dy);
		repaint();
	}

	public void mouseReleased( MouseEvent e )
    {
		BlockToBeMoved=null; // no shape selected
   }

    public void mouseEntered( MouseEvent e )
    {
    }

    public void mouseExited( MouseEvent e )
    {
    }

    public void mouseMoved( MouseEvent e )
    {
    }
    
    public void mouseDragged( MouseEvent e )
    {
        if (e.isMetaDown()) return;	// ignore right button
    	
		if (BlockToBeMoved!=null) {
        	int dx = e.getX() - m_nOffsetX;
        	int dy = e.getY() - m_nOffsetY;
			//int dx = (e.getX()-m_nOffsetX)-BlockToBeMoved.getX();
			//int dy = (e.getY()-m_nOffsetY)-BlockToBeMoved.getY();
			move(dx, dy);
		}

    } // end method mouseDragged
} // end class BuildingBlockPanel

