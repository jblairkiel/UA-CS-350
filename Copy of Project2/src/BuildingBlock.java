import java.awt.Color;
import java.awt.Graphics;

public class BuildingBlock {
	public BuildingBlock(int type, int x, int y, int w, int h, Color c) {
		Type=type;
		X=x;
		Y=y;
		Width=w;
		Height=h;
		FillColor=c;
	}
	
	public BuildingBlock(BuildingBlock src) { //copy constructor
		Type=src.Type;
		X=src.X;
		Y=src.Y;
		Width=src.Width;
		Height=src.Height;
		FillColor=src.FillColor;
	}
	
	public int getX() { return X; }
	public void setX(int x) { X=x; }
	public int getY() { return Y; }
	public void setY(int y) { Y=y; }
	

	public void draw(Graphics g) {
		//Color
		g.setColor(FillColor);
			g.fillOval(X + (Width/3) , Y + (Height/5) , (2*Width)/3, (2*Height)/3);
			g.fillRect(X,  Y + (Height/2), Width, Height - (Height/2));
		//Block
		g.setColor(Color.black);
			g.fillOval(X, Y + (27*Height/32), (Width/3), (Height/3));
			g.fillOval(X + (43*Width/64), Y + (27*Height/32), (Width/3), (Height/3));
			

	}
	

	public boolean hitTest(int x, int y){
		switch (Type) {
		case 0:
		{
			double a=Width/2.0;
			double b=Height/2.0;
			double xc=X+a;
			double yc=Y+b;
			return ((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0);
		}
		case 1:
			return (x>=X && y>=Y && x<X+Width && y<Y+Height);
		}
		
		return false;
	}
	
	
	private int Type;
	private int X;
	private int Y;
	private int Width;
	private int Height;
	private Color FillColor;
}