import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Timer;

//I'd like to speak to your manager

public class ObjectManager implements MouseListener, ActionListener {
	static int numLives = 25;
	Timer enemyTimer = new Timer(2000, this);

	// Arraylist of Path Objects
	public static ArrayList<Path> pathList = new ArrayList<Path>();
	public static ArrayList<Tower> towerList = new ArrayList<Tower>();
	public static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	public static ArrayList<Projectile> projectileList = new ArrayList<Projectile>();

	ObjectManager() {
		initTowers();
		initPaths();
		initEnemies();
		enemyTimer.start();
	}

	static double calcDist(double x, double x2, double y, double y2) {
		return Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)));
	}

	public static Enemy getClosestEnemy(double d, double e) {
		double shortestDistance = 10000;
		int enemyIndex = -1;

		for (int i = 0; i < enemyList.size(); i++) {
			if (calcDist(d, enemyList.get(i).x, e, enemyList.get(i).y) < shortestDistance) {
				shortestDistance = calcDist(d, enemyList.get(i).x, e, enemyList.get(i).y);
				enemyIndex = i;
			}
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
		enemyList.add(new Enemy(-40, 185, 50, 50));
	}

	public static void addProjectile(Projectile projectile) {
		projectileList.add(projectile);
	}

	public static void addEnemy(Enemy enemy) {
		enemyList.add(enemy);
	}

	// Update Method
	void update() {
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).update();
		}
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).update();
		}
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).update();
		}

		purgeObjects();
	}

	void purgeObjects() {
		for (int i = projectileList.size() - 1; i >= 0; i--) {
			if (projectileList.get(i).isAlive == false) {
				projectileList.remove(i);
			}
		}
	}

	// Draw Method
	void draw(Graphics g) {
		for (int i = 0; i < pathList.size(); i++) {
			pathList.get(i).draw(g);
		}
		for (int i = 0; i < towerList.size(); i++) {
			towerList.get(i).draw(g);
		}
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).draw(g);
		}
		for (int i = 0; i < projectileList.size(); i++) {
			projectileList.get(i).draw(g);
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
		System.out.println("clicked");
		for (int i = 0; i < towerList.size(); i++) {
			if (towerList.get(i).isClicked(e.getX(), e.getY())) {
				towerList.get(i).buyTower();
			}
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
		addEnemy(new Enemy(-40, 185, 50, 50));
	}
}
