import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Tower extends GameObject implements ActionListener {

	//Main Tower Variables
	boolean isActive;
	boolean menu;
	String towerType;
	int towerLevel;
	Timer shootTimer;
	
	//Tower Costs
	int arrowConstructCost = 40;
	int rifleConstructCost = 60;
	int cannonConstructCost = 75;
	int arrowUpgradeMultiplier = 60;
	int rifleUpgradeMultiplier = 100;
	int cannonUpgradeMultiplier = 130;
	
	int arrowDamageMultiplier = 5;
	int rifleDamageMultiplier = 15;
	int cannonDamageMultiplier = 30;

	// Rectangle variable
	Rectangle tower;

	// Constructor :)
	Tower(int x, int y, int width, int height) {
		super(x, y, width, height);
		resetStats();
	}
	
	public void resetStats() {
		if(isActive) {
			this.shootTimer.stop();
			isActive = false;
		}
		menu = false;
		towerType = null;
		towerLevel = 0;
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

	//Construct Towers on Empty Spaces
	boolean isClicked(double mouseX, double mouseY) {
		Rectangle mouse = new Rectangle((int) mouseX, (int) mouseY - 25, 1, 1);
		if (menu == true && towerLevel == 0) {
			if (mouse.intersects(ObjectManager.arrowButton) && ObjectManager.money >= arrowConstructCost) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				towerType = "arrow";
				towerLevel = 1;
				buyTower();
				ObjectManager.money -= arrowConstructCost;
				ObjectManager.totalMoneySpent += arrowConstructCost;
				this.shootTimer = new Timer(350, this);
				shootTimer.start();
				return true;
			}
			if (mouse.intersects(ObjectManager.rifleButton) && ObjectManager.money >= rifleConstructCost) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				towerType = "rifle";
				towerLevel = 1;
				buyTower();
				ObjectManager.money -= rifleConstructCost;
				ObjectManager.totalMoneySpent += rifleConstructCost;
				this.shootTimer = new Timer(1000, this);
				shootTimer.start();
				return true;
			}
			if (mouse.intersects(ObjectManager.cannonButton) && ObjectManager.money >= cannonConstructCost) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				towerType = "cannon";
				towerLevel = 1;
				buyTower();
				ObjectManager.money -= cannonConstructCost;
				ObjectManager.totalMoneySpent += cannonConstructCost;
				this.shootTimer = new Timer(2500, this);
				shootTimer.start();
				return true;
			}
			if (mouse.intersects(ObjectManager.exitButton1)) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				return true;
			}
		}

		//Upgrade Tower Level
		else if (menu == true && towerLevel > 0) {
			if (mouse.intersects(ObjectManager.upgradeButton)) {
				if (towerType == "arrow" && ObjectManager.money >= towerLevel*arrowUpgradeMultiplier) {
					ObjectManager.money -= towerLevel*arrowUpgradeMultiplier;
					ObjectManager.totalMoneySpent += towerLevel*arrowUpgradeMultiplier;
					ObjectManager.numTowerUpgrades++;
					towerLevel++;
					ObjectManager.disableMenus(this);
					menu = !menu;
					return true;
				}
				else if (towerType == "rifle" && ObjectManager.money >= towerLevel*rifleUpgradeMultiplier) {
					ObjectManager.money -= towerLevel*rifleUpgradeMultiplier;
					ObjectManager.totalMoneySpent += towerLevel*rifleUpgradeMultiplier;
					ObjectManager.numTowerUpgrades++;
					towerLevel++;
					ObjectManager.disableMenus(this);
					menu = !menu;
					return true;
				}
				else if (towerType == "cannon" && ObjectManager.money >= towerLevel*cannonUpgradeMultiplier) {
					ObjectManager.money -= towerLevel*cannonUpgradeMultiplier;
					ObjectManager.totalMoneySpent += towerLevel*cannonUpgradeMultiplier;
					ObjectManager.numTowerUpgrades++;
					towerLevel++;
					ObjectManager.disableMenus(this);
					menu = !menu;
					return true;
				}
			} else if (mouse.intersects(ObjectManager.exitButton2)) {
				ObjectManager.disableMenus(this);
				menu = !menu;
				return true;
			}
		}

		else if (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height) {
			ObjectManager.disableMenus(this);
			menu = !menu;
			return true;
		} else {
			return false;
		}
		return false;
	}

	void drawMenu(Graphics g) {
		if (menu == true && towerType == "arrow") {
			g.setColor(Color.GREEN);
			g.fillRect((int) x, (int) y, 100, 50);
			g.setColor(Color.BLACK);
			g.drawString("+5 Damage", (int) x, (int) y + 30);
			g.drawString("$" + towerLevel*60, (int) x, (int) y + 45);
			g.fillRect((int) x, (int) y + 50, 100, 50);
			g.setColor(Color.WHITE);
			g.drawString("<-", (int) x, (int) y + 95);
		} else if (menu == true && towerType == "rifle") {
			g.setColor(Color.CYAN);
			g.fillRect((int) x, (int) y, 100, 50);
			g.setColor(Color.BLACK);
			g.drawString("+15 Damage", (int) x, (int) y + 30);
			g.drawString("$" + towerLevel*100, (int) x, (int) y + 45);
			g.fillRect((int) x, (int) y + 50, 100, 50);
			g.setColor(Color.WHITE);
			g.drawString("<-", (int) x, (int) y + 95);
		} else if (menu == true && towerType == "cannon") {
			g.setColor(Color.PINK);
			g.fillRect((int) x, (int) y, 100, 50);
			g.setColor(Color.BLACK);
			g.drawString("+30 Damage", (int) x, (int) y + 30);
			g.drawString("$" + towerLevel*130, (int) x, (int) y + 45);
			g.fillRect((int) x, (int) y + 50, 100, 50);
			g.setColor(Color.WHITE);
			g.drawString("<-", (int) x, (int) y + 95);
		} else if (menu == true && towerType == null) {
			g.setColor(Color.GREEN);
			g.fillRect((int) x, (int) y, 50, 50);
			g.setColor(Color.CYAN);
			g.fillRect((int) x + 50, (int) y, 50, 50);
			g.setColor(Color.PINK);
			g.fillRect((int) x, (int) y + 50, 50, 50);
			g.setColor(Color.BLACK);
			g.fillRect((int) x + 50, (int) y + 50, 50, 50);
			g.drawString("$40", (int) x, (int) y + 45);
			g.drawString("$60", (int) x + 50, (int) y + 45);
			g.drawString("$75", (int) x, (int) y + 95);
			g.setColor(Color.WHITE);
			g.drawString("<-", (int) x + 50, (int) y + 95);
		} else if (menu == false && towerLevel > 0) {
			g.setColor(Color.BLACK);
			g.drawString("" + towerLevel, (int) x + 45, (int) y + 55);
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
			Enemy target = ObjectManager.getClosestEnemy(x + (width / 2) - 5, y + (height / 2) - 5, 200);
			if (target != ObjectManager.fake) {
				double targetX = target.x;
				double targetY = target.y;
				int targetDirection = target.getDirection();

				if (targetDirection == 1) {
					targetY -= 30 * target.getSpeed();
				}

				if (targetDirection == 2) {
					targetX += 30 * target.getSpeed();
				}

				if (targetDirection == 3) {
					targetY += 30 * target.getSpeed();
				}

				if (targetDirection == 4) {
					targetX -= 30 * target.getSpeed();
				}

				ObjectManager.addProjectile(new Projectile(x + (width / 2) - 5, y + (height / 2) - 5, 10, 10, targetX, targetY, 5, 200, towerType, towerLevel));
				ObjectManager.numProjectilesFired++;
			}
		}
	}
}
