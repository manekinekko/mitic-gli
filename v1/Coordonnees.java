package editeurDessin.v1;

import java.awt.Point;

public class Coordonnees {
	

	private int x0, x, y0, y;

	public Coordonnees(int x, int y){
		this.x0 = x;
		this.y0 = y;
	}
	
	public Coordonnees(){
		this.x0 = 0;
		this.y0 = 0;
		this.x = 0;
		this.y = 0;
	}

	public void setLocation0(Point p){
		this.x0 = (int) p.getX();
		this.y0 = (int) p.getY();
	}

	public void setLocation(Point p){
		this.x = (int) p.getX();
		this.y = (int) p.getY();
	}
	
	public int getX0() {
		return x0;
	}
	public void setX0(int x) {
		this.x0 = x;
	}

	public int getY0() {
		return y0;
	}
	public void setY0(int y) {
		this.y0 = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth(){
		return Math.abs(x - x0);
	}

	public int getHeight(){
		return Math.abs(y - y0);
	}

	@Override
	public String toString() {
		return "Coordonnees [x0=" + x0 + ", x=" + x + ", y0=" + y0 + ", y=" + y
				+ "]";
	}
	
	
}
