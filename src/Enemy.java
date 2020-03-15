import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Enemy extends GameObject {

	//Main Enemy Variables
	Rectangle enemy;
	int targetIndex = 0;
	int health;
	int speed;
	int moveDirection;
	String type;

	//Tower Damage
	int arrowDamageMultiplier = 5;
	int rifleDamageMultiplier = 15;
	int cannonDamageMultiplier = 30;
	
	//Enemy Constructor
	Enemy(int x, int y, int width, int height, String type, int health, int speed) {
		super(x, y, width, height);
		this.type = type;
		this.health = health;
		this.speed = speed;
		targetNext();
	}

	//Reduce Enemy Health based on Tower Level
	public void reduceHealth(String projectileType, int projectileTowerLevel) {
		if (projectileType.equals("arrow")) {
			health -= projectileTowerLevel * arrowDamageMultiplier;
		} else if (projectileType.equals("rifle")) {
			health -= 10 + (projectileTowerLevel * rifleDamageMultiplier);
		} else if (projectileType.equals("cannon")) {
			health -= 20 + (projectileTowerLevel * cannonDamageMultiplier);
		}
	}

	//Return Enemy Direction
	int getDirection() {
		return moveDirection;
	}
	
	//Return Enemy Speed
	int getSpeed() {
		return speed;
	}

	public void draw(Graphics g) {
		// Drawing Tower Spaces

		if (type.equals("towel")) {
			g.setColor(Color.YELLOW);
			g.fillRect((int) x, (int) y, width, height);
			g.fillRect((int) x, (int) y - 20, 50, 10);
			g.setColor(Color.BLACK);
			g.fillRect((int) x + (health / 2), (int) y - 20, 50 - (health / 2), 10);
		} else if (type.equals("eraser")) {
			g.setColor(Color.BLUE);
			g.fillRect((int) x, (int) y, width, height);
			g.setColor(Color.YELLOW);
			g.fillRect((int) x, (int) y - 20, 50, 10);
			g.setColor(Color.BLACK);
			g.fillRect((int) x + (health / 5), (int) y - 20, 50 - (health / 5), 10);
		} else if (type.equals("spray")) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect((int) x, (int) y, width, height);
			g.setColor(Color.YELLOW);
			g.fillRect((int) x, (int) y - 20, 50, 10);
			g.setColor(Color.BLACK);
			g.fillRect((int) x + (health / 10), (int) y - 20, 50 - (health / 10), 10);
		} else if (type.equals("trashcan")) {
			g.setColor(Color.BLACK);
			g.fillRect((int) x, (int) y, width, height);
			g.setColor(Color.YELLOW);
			g.fillRect((int) x, (int) y - 20, 50, 10);
			g.setColor(Color.BLACK);
			g.fillRect((int) x + (health / 40), (int) y - 20, 50 - (health / 40), 10);
		}
	}

	public void update() {
		super.update();

		if (x < targetX) {
			x += speed;
			moveDirection = 2;
		}
		if (x > targetX) {
			x -= speed;
			moveDirection = 4;
		}
		if (y < targetY) {
			y += speed;
			moveDirection = 3;
		}
		if (y > targetY) {
			y -= speed;
			moveDirection = 1;
		}
		if (x == targetX && y == targetY) {
			targetNext();
		}
	}

	void targetNext() {
		targetIndex++;
		if (targetIndex >= ObjectManager.pathList.size()) {
			ObjectManager.loseLives(this);
		} else {
			targetX = (ObjectManager.pathList.get(targetIndex).x) + 25;
			targetY = (ObjectManager.pathList.get(targetIndex).y) + 25;
		}
	}
}
