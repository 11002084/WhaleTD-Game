import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Enemy extends GameObject{
	
	Rectangle enemy;
	int targetIndex = 0;
	int health = 100;
	
	Enemy(int x, int y, int width, int height){
		super(x, y, width, height);
		targetNext();
	}
	public void reduceHealth() {
		health-=25;
	}
	
	public void draw(Graphics g) {
		// Drawing Tower Spaces
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public void update() {
		super.update();
		
		if(x<targetX) {
			x++;
		}
		if(x>targetX) {
			x--;
		}
		if(y<targetY) {
		    y++;
		}
		if(y>targetY) {
			y--;
		}
		if(x==targetX && y==targetY) {
			targetNext();
		}
	}
	
	void targetNext(){
		targetIndex++;
		if(targetIndex >= ObjectManager.pathList.size()) {
			ObjectManager.loseLives(this);
		}else {
		targetX=(ObjectManager.pathList.get(targetIndex).x)+25;
		targetY=(ObjectManager.pathList.get(targetIndex).y)+25;
		}
	}
}
