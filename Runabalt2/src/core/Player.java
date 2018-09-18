package core;

import java.awt.Rectangle;
import java.util.LinkedList;

import utils.StaticVariables;


public class Player extends ObjectsGame{
	
	private double velX = StaticVariables.minSpeed;
	private double velY = StaticVariables.gravity;
	private int timer = 0;
	private LinkedList<ObjectsGame> objects;
	private World world;
	
	private boolean jumping = false;
	
	
	
	
	public Player(double x, double y) {
		super(x, y);
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
		y += velY;
		
		objects = new LinkedList<ObjectsGame>();
		world = new World();
		objects = world.getObjects();
		for(int i = 0 ; i < objects.size() ; i++) {
			collision(objects.get(i));
		}
		
	
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
	
	public void jump() {
		velY = -10;
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


}
