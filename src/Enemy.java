import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Enemy extends GameObject implements ActionListener{
	
	Rectangle enemy;
	int targetIndex = 0;
	Timer enemyTimer;
	
	Enemy(int x, int y, int width, int height){
		super(x, y, width, height);
		targetNext();
		this.enemyTimer = new Timer(2000, this);
		enemyTimer.start();
	}
	
	public void draw(Graphics g) {
		// Drawing Tower Spaces
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
	public void update() {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ObjectManager.addEnemy(new Enemy(-40, 185, 50, 50));
	}
}
