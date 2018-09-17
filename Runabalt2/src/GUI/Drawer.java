package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import core.Player;

public class Drawer {

	private Player player;

	BufferedImage playerImg;

	
	public Drawer(Player player) {
		this.player = player;

	}

	private Image getPlayerImg() {
		ImageIcon i = new ImageIcon(getClass().getResource("/tmpPlayer.png"));

		return i.getImage();
	
	}

	public void drawPlayer(Graphics g) {
		g.drawImage(getPlayerImg(),(int) player.getX(), (int)player.getY(), 32, 32, null);
	}

}
