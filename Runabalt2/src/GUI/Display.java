package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import core.World;
import core.GameUpdater;
import core.Player;
import utils.KeyInput;
import utils.StaticVariables;

public class Display extends JPanel {

	private static final long serialVersionUID = 1L;

	private Player player;

	private Drawer drawer;
	private World world;
	private GameUpdater gameUpdater;

	public Display() {
		this.world = new World();
		
		world.printWorld();
		
		player = new Player(100, 300, world);

		drawer = new Drawer(player);

		gameUpdater = new GameUpdater(player, this);

		initDisplay();

		gameUpdater.start();
	}

	public void initDisplay() {
		this.setPreferredSize(new Dimension(StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT));
		
		addKeyListener(new KeyInput(player));
		
		this.setFocusable(true);

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
		
		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(getBackgroundImage(), 0, 0, StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT, null);

		drawer.drawPlayer(g2D);
	}

}
