import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

//I'd like to speak to your manager

public class ObjectManager {
	// Arraylist of Path Objects
	ArrayList<Path> pathList = new ArrayList<Path>();
	ArrayList<Tower> towerList = new ArrayList<Tower>();

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
		pathList.add(new Path(0, 160, 410, 100));
		pathList.add(new Path(310, 160, 100, 400));
		pathList.add(new Path(10, 460, 400, 100));
		pathList.add(new Path(10, 460, 100, 400));
		pathList.add(new Path(10, 760, 550, 100));
		pathList.add(new Path(460, 610, 100, 200));
		pathList.add(new Path(460, 610, 400, 100));
		pathList.add(new Path(760, 610, 100, 250));
		pathList.add(new Path(760, 760, 400, 100));
		pathList.add(new Path(1060, 610, 100, 200));
		pathList.add(new Path(1060, 610, 400, 100));
		pathList.add(new Path(1360, 0, 100, 710));
	}

	//Update Method
	void update() {

	}

	//Draw Method
	void draw() {
		for(int i=0; i<pathList.size(); i++) {
			pathList.get(1);
			Tower.draw(g);
		}
	}
}
