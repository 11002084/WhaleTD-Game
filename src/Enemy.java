import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{
	
	Rectangle enemy;
	int targetIndex = 0;
	
	Enemy(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		targetNext();
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
		targetX=(ObjectManager.pathList.get(targetIndex).x)+25;
		targetY=(ObjectManager.pathList.get(targetIndex).y)+25;
	}
}
