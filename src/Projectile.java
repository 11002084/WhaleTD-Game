import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject{
	
	Rectangle projectile;
	double speedX;
	double speedY;
	double speed;
	
	// Constructor :)
	Projectile(double d, double e, int width, int height, double x, double y, double speed) {
		super(d, e, width, height);
		this.targetX = x;
		this.targetY = y;
		double diffX = x - d;
		double diffY = y - e;
		double mag = Math.sqrt((diffX * diffX) + (diffY*diffY));
		this.speed = speed;
		this.speedX = (diffX/mag)*speed;
		this.speedY = (diffY/mag)*speed;
	}
	
	// Draw Projectiles
	public void draw(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect((int)x, (int)y, width, height);		
	}
		
	public void update() {
		super.update();
		x+=speedX;
		y+=speedY;
		checkBounds();
	}
	
	public void checkBounds() {
		if(x <= 0 || x >= WhaleTD.WIDTH || y <= 0 || y >= WhaleTD.HEIGHT) {
			isAlive = false;
		}
	}
}
