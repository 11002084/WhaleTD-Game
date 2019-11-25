import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Tower extends GameObject implements ActionListener {

	boolean isActive;
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
			g.fillRect(x, y, width, height);
		} else {
			g.setColor(Color.GREEN);
			g.fillRect(x, y, width, height);
		}
	}

	boolean isClicked(int mouseX, int mouseY) {
		if (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height) {
			return true;
		} else {
			return false;
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
			ObjectManager.addProjectile(new Projectile(x+(width/2)-5, y+(height/2)-5, 10, 10, 1, 1));
		}
	}
}
