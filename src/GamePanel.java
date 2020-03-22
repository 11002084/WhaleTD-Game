import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
	
	Timer frameDraw;
	ObjectManager objectManager =  new ObjectManager();
	static JLabel labelMoney =  new JLabel();
	static JLabel labelLives = new JLabel();
			
	GamePanel(){
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		add(labelMoney);
		add(labelLives);
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
