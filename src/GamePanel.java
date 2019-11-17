import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
	
	Timer frameDraw;
	ObjectManager objectManager =  new ObjectManager();
	
	GamePanel(){
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	public void paintComponent(Graphics g) {
		objectManager.draw(g);
		objectManager.update();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	
}
