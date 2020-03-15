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
	//Enemy Spawning Variables
	int spawnStartTowel = 5000;
	int spawnStartEraser = 25000;
	int spawnStartSpray = 45000;
	int spawnStartTrashcan = 80000;
	int spawnDelayTowel = 1000;
	int spawnDelayEraser = 2000;
	int spawnDelaySpray = 5000;
	int spawnDelayTrashcan = 10000;
	
	int spawnCounter = 0;
	int minSpawnDelay = 100;
	int spawnDelayReduction = 100;
	int spawnDelayReductionDelay = 20000;
	int totalTime = 0;
	Timer enemyTimer = new Timer(10, this);
	
	//Other Enemy Variables
	int towelMoney = 10;
	int eraserMoney = 25;
	int sprayMoney = 50;
	int trashcanMoney = 200;
	int towelHealth = 100;
	int eraserHealth = 250;
	int sprayHealth = 500;
	int trashcanHealth = 2000;
	/*Don't touch*/ int towelSpeed = 1;
	/*Don't touch*/ int eraserSpeed = 1;
	/*Don't touch*/ int spraySpeed = 1;
	/*Don't touch*/ int trashcanSpeed = 1;
	int reduceAmount;
	
	//Player Values
	static int numLives = 10;
	static int money = 100;
	static int livesReduction = 1;
	Timer moneyTimer = new Timer(1000, this);
	
	//Objects and Rectangles
	public static Enemy fake;
	public static Rectangle arrowButton;
	public static Rectangle rifleButton;
	public static Rectangle cannonButton;
	public static Rectangle exitButton1;
	public static Rectangle upgradeButton;
	public static Rectangle exitButton2;
	public static Rectangle instructionButton;

	// Arraylist of Path Objects
	public static ArrayList<Path> pathList = new ArrayList<Path>();
	public static ArrayList<Tower> towerList = new ArrayList<Tower>();
	public static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	public static ArrayList<Projectile> projectileList = new ArrayList<Projectile>();

	//ObjectManager Constructor
	ObjectManager() {
		instructionButton = new Rectangle(1000, 10, 100, 100);
		initTowers();
		initPaths();
		initEnemies();
		fake = new Enemy(-69, -420, 0, 0, "eraser", 100, 2);
		enemyTimer.start();
		moneyTimer.start();

	}

	//Calculate Distance using Maths
	public static double calcDist(double x, double x2, double y, double y2) {
		return Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)));
	}

	//Calculate Distances and Get Closest Enemy
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

	//Initialize Enemies
	void initEnemies() {
		enemyList.add(new Enemy(-40, 185, 50, 50, "towel", 0, 1));
	}

	//Initialize Projectiles
	public static void addProjectile(Projectile projectile) {
		projectileList.add(projectile);
	}

	//Add Enemy Object
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

	//Check Lives and Exit Game if Lives is 0
	void checkLives() {
		if (numLives <= 0) {
			System.exit(0);
		}
	}

	//Check if Projectile Is Touching Enemy
	void checkCollision() {
		for (int i = 0; i < enemyList.size(); i++) {
			for (int j = 0; j < projectileList.size(); j++) {
				if (projectileList.get(j).collisionBox.intersects(enemyList.get(i).collisionBox)) {
					enemyList.get(i).reduceHealth(projectileList.get(j).type, projectileList.get(j).level);
					projectileList.get(j).isAlive = false;
				}
			}
		}
	}

	//Check the Health of Enemies
	void checkHealth() {
		for (int i = 0; i < enemyList.size(); i++) {
			if (enemyList.get(i).health <= 0) {
				enemyList.get(i).isAlive = false;
			}
		}
	}

	//Remove Projectiles and Enemies that Aren't Alive
	void purgeObjects() {
		for (int i = projectileList.size() - 1; i >= 0; i--) {
			if (projectileList.get(i).isAlive == false) {
				projectileList.remove(i);
			}
		}

		for (int i = enemyList.size() - 1; i >= 0; i--) {
			if (enemyList.get(i).isAlive == false) {
				if(enemyList.get(i).type.equals("towel")) {
					money += towelMoney;
				}
				
				else if(enemyList.get(i).type.equals("eraser")) {
					money += eraserMoney;
				}
				
				else if(enemyList.get(i).type.equals("spray")) {
					money += sprayMoney;
				}
				
				else if(enemyList.get(i).type.equals("trashcan")) {
					money += trashcanMoney;
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

	//Hide Tower Menus
	public static void disableMenus(Tower tower) {
		for (int i = 0; i < towerList.size(); i++) {
			if (towerList.get(i) != tower) {
				towerList.get(i).menu = false;
			}
		}
	}

	//Lose Life if Enemy Gets Past Gauntlet
	public static void loseLives(Enemy enemy) {
		enemyList.remove(enemy);
		numLives -= livesReduction;
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
				arrowButton = new Rectangle((int)towerList.get(i).x, (int)towerList.get(i).y, 50, 50);
				rifleButton = new Rectangle((int)towerList.get(i).x+50, (int)towerList.get(i).y, 50, 50);
				cannonButton = new Rectangle((int)towerList.get(i).x, (int)towerList.get(i).y+50, 50, 50);
				exitButton1 = new Rectangle((int)towerList.get(i).x+50, (int)towerList.get(i).y+50, 50, 50);
				upgradeButton = new Rectangle((int)towerList.get(i).x, (int)towerList.get(i).y, 100, 50);
				exitButton2 = new Rectangle((int)towerList.get(i).x, (int)towerList.get(i).y+50, 100, 50);
			}
		}

		if (instructionButton.intersects(e.getX(), e.getY(), 1, 1)) {
			JOptionPane.showMessageDialog(null, " Welcome to Whale Tower Defense (without the whales right now)."
					+ "\n Your goal is to kill those squares coming through the path using towers." + "\n"
					+ "\n Click on an empty gray space and select one of the colored buttons that pops up to build a tower."
					+ "\n Green buttons build green towers, which shoot at a fast rate but deal low damage."
					+ "\n Blue buttons build blue towers, which shoot at a medium rate and deal medium damage."
					+ "\n Pink buttons build pink towers, which shoot at a slow rate but deal large damage."
					+ "\n If you accidentally clicked an empty gray space, you can click the black button to close the build menu." + "\n"
					+ "\n You need 40 gold to build a green tower."
					+ "\n You need 60 gold to build a blue tower."
					+ "\n You need 75 gold to build a pink tower."
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
			
			if (totalTime > spawnStartTowel && spawnCounter % spawnDelayTowel == 0) {
				enemyList.add(new Enemy(-40, 185, 50, 50, "towel", trashcanHealth, towelSpeed));
			}
			
			if (totalTime > spawnStartEraser && spawnCounter % spawnDelayEraser == 0) {
				enemyList.add(new Enemy(-40, 185, 50, 50, "eraser", trashcanHealth, eraserSpeed));
			}
			
			if(totalTime > spawnStartSpray && spawnCounter % spawnDelaySpray == 0) {
				enemyList.add(new Enemy(-40, 185, 50, 50, "spray", trashcanHealth, spraySpeed));
			}
			
			if(totalTime > spawnStartTrashcan && spawnCounter % spawnDelayTrashcan == 0) {
				enemyList.add(new Enemy(-40, 185, 50, 50, "trashcan", trashcanHealth, trashcanSpeed));
			}
			
			if (totalTime % spawnDelayReductionDelay == 0) {
				if(spawnDelayTowel > minSpawnDelay) {
					spawnDelayTowel -= spawnDelayReduction;
				}
				if(spawnDelayTowel > minSpawnDelay) {
					spawnDelayEraser -= spawnDelayReduction;
				}
				if(spawnDelayTowel > minSpawnDelay) {
					spawnDelaySpray -= spawnDelayReduction;
				}
				if(spawnDelayTowel > minSpawnDelay) {
					spawnDelayTrashcan -= spawnDelayReduction;
				}
			}
		}

		if (e.getSource() == moneyTimer) {
			money++;
		}
	}
}
