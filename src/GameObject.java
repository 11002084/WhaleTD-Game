
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
	
	// Constructor :)
	GameObject(double d, double e, int width, int height) {
		this.x = d;
		this.y = e;
		this.width = width;
		this.height = height;
	}
}
