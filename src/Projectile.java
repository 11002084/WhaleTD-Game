import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject{
	
	Rectangle projectile;
	int targetX;
	int targetY;
	int speedX;
	int speedY;
	
	// Constructor :)
	Projectile(int x, int y, int width, int height, int targetX, int targetY) {
		super(x, y, width, height);
		this.targetX = targetX;
		this.targetY = targetY;
		this.speedX = 5;
		this.speedY = 5;
	}
	
	// Draw Projectiles
	public void draw(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);		
	}
		
	public void update() {
		x+=speedX;
		y+=speedY;
	}
}
