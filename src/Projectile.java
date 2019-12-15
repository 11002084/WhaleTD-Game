import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject{
	
	Rectangle projectile;
	double speedX;
	double speedY;
	double speed;
	double maxRange;
	double originX;
	double originY;
	
	// Constructor :)
	Projectile(double originX, double originY, int width, int height, double targetX, double targetY, double speed, double maxRange) {
		super(originX, originY, width, height);
		this.targetX = targetX;
		this.targetY = targetY;
		this.originX = originX;
		this.originY = originY;
		double diffX = targetX - originX;
		double diffY = targetY - originY;
		double mag = Math.sqrt((diffX * diffX) + (diffY*diffY));
		this.speed = speed;
		this.speedX = (diffX/mag)*speed;
		this.speedY = (diffY/mag)*speed;
		this.maxRange = maxRange;
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
		if(ObjectManager.calcDist(originX, x, originY, y) > maxRange) {
			isAlive = false;
		}
	}
	
	public void checkBounds() {
		if(x <= 0 || x >= WhaleTD.WIDTH || y <= 0 || y >= WhaleTD.HEIGHT) {
			isAlive = false;
		}
	}
}
