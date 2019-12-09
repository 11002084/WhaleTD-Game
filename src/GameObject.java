import java.awt.Rectangle;

public class GameObject {

	// Locations
	double x;
	double y;
	
	double targetX;
	double targetY;

	// Dimensions
	int width;
	int height;
	
	boolean isAlive = true;
	Rectangle collisionBox;
	
	// Constructor :)
	GameObject(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle((int)x, (int)y, width, height);
	}
	
	void update() {
        collisionBox.setBounds((int)x, (int)y, width, height);
	}
}
