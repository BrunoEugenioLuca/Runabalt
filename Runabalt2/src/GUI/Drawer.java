package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import core.Handler;
import core.Player;

public class Drawer {

	private Player player;
	
	private Handler handler;

	BufferedImage playerImg;

	
	public Drawer(Player player, Handler handler) {
		this.player = player;
		this.handler = handler;

	}

	private Image getPlayerImg() {
		ImageIcon i = new ImageIcon(getClass().getResource("/tmpPlayer.png"));

		return i.getImage();
	
	}
	
	private Image getBlockImage() {
		ImageIcon i = new ImageIcon(getClass().getResource("/block.png"));
		
		return i.getImage();
		
	}

	public void drawPlayer(Graphics g) {
		g.drawImage(getPlayerImg(),(int) player.getX(), (int)player.getY(), 32, 32, null);
	}
	
	public void drawHandler(Graphics g) {
			for(int i = 0; i < handler.getObjects().size(); i++)
				g.drawImage(getBlockImage(),(int) handler.getObjects().get(i).getX(),(int) handler.getObjects().get(i).getY(), 32, 32, null);
		
	}

}
