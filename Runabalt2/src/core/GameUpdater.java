package core;

import GUI.Display;

public class GameUpdater extends Thread{

	private long lastTime = System.nanoTime();
	private final double amountOfTicks = 60.0;
	private double ns = 1000000000 / amountOfTicks;
	private double delta = 0;
	
	private boolean running;
	private Player p;
	private Display display;
	
	public GameUpdater(Player p, Display display) {
		this.p = p;
		this.display = display;
		
		this.running = true;
		
	}
	
	@Override
	public void run() {
		super.run();
		
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				delta--;
				p.update();
				updates++;
				
			}
			display.render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: "+ frames + "  TICKS: " + updates);
				updates = 0;
				frames = 0;
			}
			
		}
	}

}
