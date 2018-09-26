package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import core.World;
import core.Block;
import core.GameUpdater;
import core.Handler;
import core.Player;
import utils.KeyInput;
import utils.StaticVariables;

public class Display extends JPanel {

	private static final long serialVersionUID = 1L;

	private Player player;

	private Handler handler;

	private Drawer drawer;
	private World world;
	private GameUpdater gameUpdater;

	public Display() {

		initDisplay();
		
		initObjectsGame();
		
		initListeners();

		gameUpdater.start();
	}

	private void initDisplay() {
		this.setPreferredSize(new Dimension(StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT));
		this.setMaximumSize(new Dimension(StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT));
		this.setMinimumSize(new Dimension(StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT));

		this.setFocusable(true);

	}

	private void initObjectsGame() {
		world = new World();

		player = new Player(100, 300, world);

		handler = new Handler();
		
		initHandler();

		drawer = new Drawer(player, handler);

		gameUpdater = new GameUpdater(player, this);
	}
	
	private void initListeners() {
		addKeyListener(new KeyInput(player));
	}
	
	private void initHandler() {
		for(int i = 0; i < StaticVariables.SCREEN_WIDTH / 2; i += 32) {
			handler.addObject(new Block(i, 500));
			for(int j = 532 ; j < StaticVariables.SCREEN_HEIGHT - 32; j += 32)
				handler.addObject(new Block(i, j));
		}
			
	}

	private Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource("/background1.png"));

		return i.getImage();
	}

	public void render() {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(getBackgroundImage(), 0, 0, StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT, this);

		Graphics2D g2D = (Graphics2D) g;

		drawer.drawPlayer(g2D);
		
		drawer.drawHandler(g2D);

	}

}
