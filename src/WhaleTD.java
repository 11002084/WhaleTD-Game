import javax.swing.JFrame;
import javax.swing.JSplitPane;

//I DONT KNOW WHAT IM DOING AAAAAHHHHHH

public class WhaleTD {
	
	
	//JFrame Variable
	JFrame frame;
	
	//GamePanel Variable
	GamePanel gamePanel;
	
	//Dimension Variables
	public static final int HEIGHT = 800;
	public static final int WIDTH = 1400;
	
	//Constructor
	WhaleTD(JFrame frame, GamePanel gamePanel){
		this.frame=frame;
		this.gamePanel = gamePanel;
	}
	
	//Setup Method
	void setup(){
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(gamePanel.objectManager);
	}
	
	//Main Method :D
	public static void main(String[] args) {
		WhaleTD coolestWhale = new WhaleTD(new JFrame(), new GamePanel());
		coolestWhale.setup();
		
	}
}
