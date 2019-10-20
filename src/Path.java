import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

//The lone whale took the path less taken and got ambushed by erasers

public class Path extends GameObject{

	// Rectangle variable
	Rectangle path;

	// Constructor :)
	Path(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	// Draw Enemy Paths
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		
	}
}