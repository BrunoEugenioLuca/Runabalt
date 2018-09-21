package utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import core.Player;

public class KeyInput extends KeyAdapter{

	private Player player;
	
	public KeyInput(Player player) {
		this.player = player;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}



}
