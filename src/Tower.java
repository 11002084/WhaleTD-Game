import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Tower extends GameObject implements ActionListener {

	boolean isActive;
	boolean menu;
	String towerType;
	int towerLevel;
	Timer shootTimer;

	// Rectangle variable
	Rectangle tower;

	// Constructor :)
	Tower(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.isActive = false;
	}

	// Paint Component Method
	public void draw(Graphics g) {
		// Drawing Tower Spaces
		if (isActive == false) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect((int) x, (int) y, width, height);
		} else {
			if (towerType == "arrow") {
				g.setColor(Color.GREEN);
			} else if (towerType == "rifle") {
				g.setColor(Color.CYAN);
			} else if (towerType == "cannon") {
				g.setColor(Color.PINK);
			}
			g.fillRect((int) x, (int) y, width, height);
		}
	}

	boolean isClicked(double mouseX, double mouseY) {
		Rectangle mouse = new Rectangle((int) mouseX, (int) mouseY, 1, 1);
		if (menu == true && ObjectManager.money >= 50) {
			if (mouse.intersects(ObjectManager.button1)) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				towerType = "arrow";
				buyTower();
				ObjectManager.money-=50;
				this.shootTimer = new Timer(500, this);
				shootTimer.start();
				return true;
			}
			if (mouse.intersects(ObjectManager.button2)) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				towerType = "rifle";
				buyTower();
				ObjectManager.money-=50;
				this.shootTimer = new Timer(1000, this);
				shootTimer.start();
				return true;
			}
			if (mouse.intersects(ObjectManager.button3)) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				towerType = "cannon";
				buyTower();
				ObjectManager.money-=50;
				this.shootTimer = new Timer(3000, this);
				shootTimer.start();
				return true;
			} else {
				return false;
			}
		}

		else if (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height) {
			ObjectManager.disableMenus(this);
			menu = !menu;
			return true;
		} else {
			return false;
		}
	}

	void drawMenu(Graphics g) {
		if (menu == true) {
			g.setColor(Color.GREEN);
			g.fillRect(ObjectManager.button1.x, ObjectManager.button1.y, ObjectManager.button1.width,ObjectManager.button1.height);
			g.setColor(Color.CYAN);
			g.fillRect(ObjectManager.button2.x, ObjectManager.button2.y, ObjectManager.button2.width,ObjectManager.button2.height);
			g.setColor(Color.PINK);
			g.fillRect(ObjectManager.button3.x, ObjectManager.button3.y, ObjectManager.button3.width,ObjectManager.button3.height);
			g.setColor(Color.BLACK);
			g.drawRect(ObjectManager.button1.x, ObjectManager.button1.y, ObjectManager.button1.width,ObjectManager.button1.height);
			g.drawRect(ObjectManager.button2.x, ObjectManager.button2.y, ObjectManager.button2.width,ObjectManager.button2.height);
			g.drawRect(ObjectManager.button3.x, ObjectManager.button3.y, ObjectManager.button3.width,ObjectManager.button3.height);
		}
	}

	void drawTowerOutline(Graphics g) {
		if (menu == true) {
			g.setColor(Color.RED);
			g.fillRect((int) x - 10, (int) y - 10, 120, 120);
		}
	}

	void buyTower() {
		isActive = true;
	}

	void update() {
		if (isActive == true) {

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isActive == true) {
			Enemy target = ObjectManager.getClosestEnemy(x + (width / 2) - 5, y + (height / 2) - 5, 350);
			if (target != ObjectManager.fake) {
				ObjectManager.addProjectile(new Projectile(x + (width / 2) - 5, y + (height / 2) - 5, 10, 10,(target.x) + 25, (target.y) + 25, 1.5, 200, this.towerType));
			}
		}
	}
}
