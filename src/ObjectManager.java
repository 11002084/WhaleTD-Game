import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

//I'd like to speak to your manager

public class ObjectManager implements MouseListener, ActionListener {
	int spawnDelayEraser = 1000;
	int spawnDelayTrashcan = 4500;
	int spawnCounter = 0;
	int totalTime = 0;
	int reduceAmount;
	static int numLives = 10;
	Timer enemyTimer = new Timer(10, this);
	Timer moneyTimer = new Timer(1000, this);
	public static Enemy fake;
	static int money = 100;
	public static Rectangle button1;
	public static Rectangle button2;
	public static Rectangle button3;
	public static Rectangle button4;
	public static Rectangle instructionButton;

	// Arraylist of Path Objects
	public static ArrayList<Path> pathList = new ArrayList<Path>();
	public static ArrayList<Tower> towerList = new ArrayList<Tower>();
	public static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	public static ArrayList<Projectile> projectileList = new ArrayList<Projectile>();

	ObjectManager() {
		instructionButton = new Rectangle(1000, 10, 100, 100);
		initTowers();
		initPaths();
		initEnemies();
		fake = new Enemy(-69, -420, 0, 0, "eraser", 100);
		enemyTimer.start();
		moneyTimer.start();

	}

	public static double calcDist(double x, double x2, double y, double y2) {
		return Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)));
	}

	public static Enemy getClosestEnemy(double d, double e, double max) {
		double shortestDistance = 10000;
		int enemyIndex = -1;

		for (int i = 0; i < enemyList.size(); i++) {
			double dist = calcDist(d, enemyList.get(i).x, e, enemyList.get(i).y);

			if (dist < shortestDistance && dist < max) {
				shortestDistance = calcDist(d, enemyList.get(i).x, e, enemyList.get(i).y);
				enemyIndex = i;
			}
		}

		if (enemyIndex == -1) {
			return fake;
		}

		return enemyList.get(enemyIndex);
	}

	// Creating the motherload of tower objects
	void initTowers() {
		towerList.add(new Tower(10, 10, 100, 100));
		towerList.add(new Tower(10, 310, 100, 100));
		towerList.add(new Tower(160, 10, 100, 100));
		towerList.add(new Tower(160, 310, 100, 100));
		towerList.add(new Tower(160, 610, 100, 100));
		towerList.add(new Tower(310, 10, 100, 100));
		towerList.add(new Tower(310, 610, 100, 100));
		towerList.add(new Tower(460, 160, 100, 100));
		towerList.add(new Tower(460, 310, 100, 100));
		towerList.add(new Tower(460, 460, 100, 100));
		towerList.add(new Tower(610, 460, 100, 100));
		towerList.add(new Tower(610, 760, 100, 100));
		towerList.add(new Tower(760, 460, 100, 100));
		towerList.add(new Tower(910, 610, 100, 100));
		towerList.add(new Tower(1060, 460, 100, 100));
		towerList.add(new Tower(1210, 10, 100, 100));
		towerList.add(new Tower(1210, 160, 100, 100));
		towerList.add(new Tower(1210, 310, 100, 100));
		towerList.add(new Tower(1210, 460, 100, 100));
		towerList.add(new Tower(1210, 760, 100, 100));
		towerList.add(new Tower(1360, 760, 100, 100));
	}

	// All paths lead to Rome. These lead to Whalesville
	void initPaths() {
		// pathList.add(new Path(0, 160, 410, 100));
		pathList.add(new Path(0, 160, 10, 100));
		pathList.add(new Path(10, 160, 100, 100));
		pathList.add(new Path(110, 160, 100, 100));
		pathList.add(new Path(210, 160, 100, 100));
		pathList.add(new Path(310, 160, 100, 100));
		// pathList.add(new Path(310, 160, 100, 400));
		pathList.add(new Path(310, 260, 100, 100));
		pathList.add(new Path(310, 360, 100, 100));
		pathList.add(new Path(310, 460, 100, 100));
		// pathList.add(new Path(10, 460, 400, 100));
		pathList.add(new Path(210, 460, 100, 100));
		pathList.add(new Path(110, 460, 100, 100));
		pathList.add(new Path(10, 460, 100, 100));
		// pathList.add(new Path(10, 460, 100, 400));
		pathList.add(new Path(10, 560, 100, 100));
		pathList.add(new Path(10, 660, 100, 100));
		pathList.add(new Path(10, 760, 100, 100));
		// pathList.add(new Path(10, 760, 550, 100));
		pathList.add(new Path(110, 760, 100, 100));
		pathList.add(new Path(210, 760, 100, 100));
		pathList.add(new Path(310, 760, 100, 100));
		pathList.add(new Path(410, 760, 100, 100));
		// pathList.add(new Path(460, 610, 100, 200));
		pathList.add(new Path(460, 760, 100, 100));
		pathList.add(new Path(460, 660, 100, 100));
		pathList.add(new Path(460, 610, 100, 100));
		// pathList.add(new Path(460, 610, 400, 100));
		pathList.add(new Path(560, 610, 100, 100));
		pathList.add(new Path(660, 610, 100, 100));
		pathList.add(new Path(760, 610, 100, 100));
		// pathList.add(new Path(760, 610, 100, 250));
		pathList.add(new Path(760, 710, 100, 100));
		pathList.add(new Path(760, 760, 100, 100));
		// pathList.add(new Path(760, 760, 400, 100));
		pathList.add(new Path(860, 760, 100, 100));
		pathList.add(new Path(960, 760, 100, 100));
		// pathList.add(new Path(1060, 610, 100, 200));
		pathList.add(new Path(1060, 760, 100, 100));
		pathList.add(new Path(1060, 660, 100, 100));
		pathList.add(new Path(1060, 610, 100, 100));
		// pathList.add(new Path(1060, 610, 400, 100));
		pathList.add(new Path(1160, 610, 100, 100));
		pathList.add(new Path(1260, 610, 100, 100));
		pathList.add(new Path(1360, 610, 100, 100));
		// pathList.add(new Path(1360, 0, 100, 710));
		pathList.add(new Path(1360, 510, 100, 100));
		pathList.add(new Path(1360, 410, 100, 100));
		pathList.add(new Path(1360, 310, 100, 100));
		pathList.add(new Path(1360, 210, 100, 100));
		pathList.add(new Path(1360, 110, 100, 100));
		pathList.add(new Path(1360, 10, 100, 100));
		pathList.add(new Path(1360, -90, 100, 100));
	}

	void initEnemies() {
		enemyList.add(new Enemy(-40, 185, 50, 50, "eraser", 100));
	}

	public static void addProjectile(Projectile projectile) {
		projectileList.add(projectile);
	}

	public static void addEnemy(Enemy enemy) {
		enemyList.add(enemy);
	}

	// Update Method
	void update() {
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).update();
		}
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).update();
		}
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).update();
		}

		checkCollision();
		checkHealth();
		// checkLives();
		purgeObjects();
		GamePanel.setMoneyLabel(money + " Gold  ");
		GamePanel.setLivesLabel(numLives + " Lives");
	}

	void checkLives() {
		if (numLives <= 0) {
			System.exit(0);
		}
	}

	void checkCollision() {
		for (int i = 0; i < enemyList.size(); i++) {
			for (int j = 0; j < projectileList.size(); j++) {
				if (projectileList.get(j).collisionBox.intersects(enemyList.get(i).collisionBox)) {
					if (projectileList.get(j).type.equals("arrow")) {
						reduceAmount = 2;
					} else if (projectileList.get(j).type.equals("rifle")) {
						reduceAmount = 5;
					} else if (projectileList.get(j).type.equals("cannon")) {
						reduceAmount = 10;
					}

					for (int k = 0; k < reduceAmount; k++) {
						enemyList.get(i).reduceHealth();
					}
					projectileList.get(j).isAlive = false;
				}
			}
		}
	}

	void checkHealth() {
		for (int i = 0; i < enemyList.size(); i++) {
			if (enemyList.get(i).health <= 0) {
				enemyList.get(i).isAlive = false;
			}
		}
	}

	void purgeObjects() {
		for (int i = projectileList.size() - 1; i >= 0; i--) {
			if (projectileList.get(i).isAlive == false) {
				projectileList.remove(i);
			}
		}

		for (int i = enemyList.size() - 1; i >= 0; i--) {
			if (enemyList.get(i).isAlive == false) {
				if(enemyList.get(i).type.equals("eraser")) {
					money += 10;
				}
				
				else if(enemyList.get(i).type.equals("trashcan")) {
					money += 40;
				}
				
				enemyList.remove(i);
			}
		}
	}

	// Draw Method
	void draw(Graphics g) {
		for (int i = 0; i < pathList.size(); i++) {
			pathList.get(i).draw(g);
		}
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).draw(g);
		}
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).drawTowerOutline(g);
		}
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).draw(g);
		}
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).drawMenu(g);
		}
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).draw(g);
		}

		g.setColor(Color.RED);
		g.fillRect(instructionButton.x, instructionButton.y, instructionButton.width, instructionButton.height / 2);
		g.setColor(Color.BLACK);
		g.drawString("Click Me For", 1005, 25);
		g.drawString("Instuctions", 1005, 50);
	}

	public static void disableMenus(Tower tower) {
		for (int i = 0; i < towerList.size(); i++) {
			if (towerList.get(i) != tower) {
				towerList.get(i).menu = false;
			}
		}
	}

	public static void loseLives(Enemy enemy) {
		enemyList.remove(enemy);
		numLives -= 1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < towerList.size(); i++) {
			if (towerList.get(i).isClicked(e.getX(), e.getY()) == true) {
				button1 = new Rectangle((int)towerList.get(i).x, (int)towerList.get(i).y, 50, 50);
				button2 = new Rectangle((int)towerList.get(i).x+50, (int)towerList.get(i).y, 50, 50);
				button3 = new Rectangle((int)towerList.get(i).x, (int)towerList.get(i).y+50, 50, 50);
				button4 = new Rectangle((int)towerList.get(i).x+50, (int)towerList.get(i).y+50, 50, 50);
			}
		}

		if (instructionButton.intersects(e.getX(), e.getY(), 1, 1)) {
			JOptionPane.showMessageDialog(null, " Welcome to Whale Tower Defense (without the whales right now)."
					+ "\n Your goal is to kill those yellow squares coming through the path using towers." + "\n"
					+ "\n Click on an empty gray space and select one of the buttons that pops up to build a tower."
					+ "\n Green towers shoot at a fast rate but deal low damage."
					+ "\n Blue towers shoot at a medium rate and deal medium damage."
					+ "\n Pink towers shoot at a slow rate but deal large damage." + "\n"
					+ "\n You need 50 gold to build a tower."
					+ "\n You gain gold passively over time, but also by killing enemies." + "\n"
					+ "\n Don't run out of lives or you lose and the screen will close.");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == enemyTimer) {
			spawnCounter += 1;
			totalTime += 10;
			
			if (spawnCounter % spawnDelayEraser == 0) {
				enemyList.add(new Enemy(-40, 185, 50, 50, "eraser", 100));
			}
			
			if (spawnCounter % spawnDelayTrashcan == 0) {
				enemyList.add(new Enemy(-40, 185, 50, 50, "trashcan", 250));
			}
			
			if (spawnDelayEraser > 10 && spawnDelayTrashcan > 10 && totalTime % 20000 == 0) {
				spawnDelayEraser -= 50;
				spawnDelayTrashcan -= 50;
			}
		}

		if (e.getSource() == moneyTimer) {
			money++;
		}
	}
}
