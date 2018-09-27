package core;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utils.StaticVariables;


public class Player extends ObjectsGame{
	
	private double velX;
	private double velY;
	private int timer;
	private World world;
	private boolean jumping;
	private double current;

	public Player(double x, double y, World world) {
		super(x, y);
		velX = StaticVariables.minSpeed;
		velY = 0;
		jumping = false;
		current = 0;
		timer = 0;
		this.world = world;
	}
	
	// @author SuperNinja update del Player
	@Override
	public void update() {
		timer++;
		if(timer == StaticVariables.updateSpeed) {
			if(velX <  StaticVariables.maxSpeed)
				velX += StaticVariables.minSpeed;
			else
				velX = StaticVariables.maxSpeed;
			timer = 0;
		}
		x += velX;
	
		jump();
		for(int i = 0 ; i < world.getObjectsGame().size() ; i++) {
			collision(world.getObjectsGame().get(i));		
		}
				
	
	}

	public void jump() {
		y += velY;
		
		if(y <= current && current != 0) {
			
			velY = StaticVariables.gravity;
			current = 0;
		}	
		x += velX;
	}
		
	// funzione che verifica con quali ostacoli collide il Player
	
	public void collision(ObjectsGame o) {
		if(this.getBounds().intersects(o.getBounds())) {		
			if(o instanceof Archive) { // se collide con l'archivio il Player diminuisce la sua velocita rispettando la velocita min 
				if(velX <= StaticVariables.minSpeed)
					velX = StaticVariables.minSpeed;
				else
					velX -= StaticVariables.stop; 
			}
			else if(o instanceof Gru || o instanceof Palace) {
				if(this.getX() == o.getX()) 
					this.x = o.getX(); // aggiungere in piu le dim del Player
				else if(this.getY() == o.getY()) {
					this.y = o.getY(); // aggiungere in piu le dim del Player
					velY = 0;
				}	
			}
		
		}
	}
	

	// funzione che crea un rettangolo intorno al Player 
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.getX(),(int)this.getY(), 32, 32);
	}

	
	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double veloY) {
		this.velY = veloY;
	}

	public void keyPressed(KeyEvent e) {
				
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			current = y-StaticVariables.maxJump;
			System.out.println("current: "+ current);
			velY = StaticVariables.speedJump;
			
		}
	}

}
