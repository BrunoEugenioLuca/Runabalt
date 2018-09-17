package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import core.GameUpdater;
import core.Player;
import utils.StaticVariables;

public class Display extends JPanel {

	private static final long serialVersionUID = 1L;

	private Player player;

	private Drawer drawer;

	private GameUpdater gameUpdater;

	public Display() {
		player = new Player(100, 100);

		drawer = new Drawer(player);

		gameUpdater = new GameUpdater(player, this);

		initDisplay();

		gameUpdater.start();
	}

	public void initDisplay() {
		this.setPreferredSize(new Dimension(StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT));

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

		g.drawImage(getBackgroundImage(), 0, 0, StaticVariables.SCREEN_WIDTH, StaticVariables.SCREEN_HEIGHT, null);

		drawer.drawPlayer(g);
	}

}
