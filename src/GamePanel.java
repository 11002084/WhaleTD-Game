import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	// Paint Component Method
	@Override
	public void paintComponent(Graphics g){
		
		//Drawing Tower Spaces
		g.setColor(Color.DARK_GRAY);
		g.fillRect(10, 10, 100, 100);
		g.fillRect(10, 310, 100, 100);
		g.fillRect(160, 10, 100, 100);
		g.fillRect(160, 310, 100, 100);
		g.fillRect(160, 610, 100, 100);
		g.fillRect(310, 10, 100, 100);
		g.fillRect(310, 610, 100, 100);
		g.fillRect(460, 160, 100, 100);
		g.fillRect(460, 310, 100, 100);
		g.fillRect(460, 460, 100, 100);
		g.fillRect(610, 460, 100, 100);
		g.fillRect(610, 760, 100, 100);
		g.fillRect(760, 460, 100, 100);
		g.fillRect(910, 610, 100, 100);
		g.fillRect(1060, 460, 100, 100);
		g.fillRect(1210, 10, 100, 100);
		g.fillRect(1210, 160, 100, 100);
		g.fillRect(1210, 310, 100, 100);
		g.fillRect(1210, 460, 100, 100);
		g.fillRect(1210, 760, 100, 100);
		g.fillRect(1360, 760, 100, 100);
	}
}
