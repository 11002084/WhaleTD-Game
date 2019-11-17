import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tower extends GameObject {
	
	boolean isActive;

	// Rectangle variable
	Rectangle tower;

	// Constructor :)
	Tower(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isActive = false;
	}
	
	// Paint Component Method
	public void draw(Graphics g) {
		// Drawing Tower Spaces
		if(isActive == false){
			g.setColor(Color.DARK_GRAY);
			g.fillRect(x, y, width, height);
		} else {
			g.setColor(Color.GREEN);
			g.fillRect(x, y, width, height);
		}
	}
	
	boolean isClicked(int mouseX, int mouseY) {
		if(mouseX > x && mouseX<x+width && mouseY > y && mouseY< y+height) {
			return true;
		} else {
			return false;
		}
	}
	
	void buyTower(){
		isActive = true;
	}
}
