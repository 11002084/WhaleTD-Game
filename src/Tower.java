import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tower extends GameObject {

	// Rectangle variable
	Rectangle path;

	// Constructor :)
	Tower(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	// Paint Component Method
	public void draw(Graphics g) {
		// Drawing Tower Spaces
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
	}
}
