import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject{
	
	Enemy(int x, int y, int width, int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public void draw(Graphics g) {
		// Drawing Tower Spaces
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
