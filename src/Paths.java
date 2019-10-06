import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

//The lone whale took the path less taken and got ambushed by erasers

public class Paths {

	// Path Locations
	int x;
	int y;

	// Path Dimensions
	int width;
	int height;

	// Arraylist of Path Objects
	ArrayList<Paths> pathList = new ArrayList<Paths>();

	// Constructor :)
	Paths(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	// Draw Enemy Paths
	public void drawPath(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}

//Drawing Enemy Paths
//g.setColor(Color.RED);
//g.fillRect(0, 160, 410, 100);
//g.fillRect(310, 160, 100, 400);
//g.fillRect(10, 460, 400, 100);
//g.fillRect(10, 460, 100, 400);
//g.fillRect(10, 760, 550, 100);
//g.fillRect(460, 610, 100, 200);
//g.fillRect(460, 610, 400, 100);
//g.fillRect(760, 610, 100, 250);
//g.fillRect(760, 760, 400, 100);
//g.fillRect(1060, 610, 100, 200);
//g.fillRect(1060, 610, 400, 100);
//g.fillRect(1360, 0, 100, 710);