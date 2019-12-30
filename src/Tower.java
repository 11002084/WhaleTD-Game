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
		this.shootTimer = new Timer(1000, this);
		shootTimer.start();
	}

	// Paint Component Method
	public void draw(Graphics g) {
		// Drawing Tower Spaces
		if (isActive == false) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect((int) x, (int) y, width, height);
		} else {
			g.setColor(Color.GREEN);
			g.fillRect((int) x, (int) y, width, height);
		}
	}

	boolean isClicked(double mouseX, double mouseY) {
		if (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height) {
			ObjectManager.disableMenus(this);
			menu = !menu;
			return true;
		} else {
			return false;
		}
	}

	void drawMenu(Graphics g) {
		if(menu == true) {
			g.setColor(Color.BLUE);
			g.fillRect(200, 245, 200, 200);
			g.fillRect(650, 245, 200, 200);
			g.fillRect(1100, 245, 200, 200);
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
				ObjectManager.addProjectile(new Projectile(x + (width / 2) - 5, y + (height / 2) - 5, 10, 10, (target.x)+25, (target.y)+25, 1.5, 200));
			}
		}
	}
}
