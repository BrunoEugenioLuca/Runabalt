package launch;

import GUI.Window;
import core.World;

public class Launcher {
	
	public static void main(String args[]) {
		new Window();
		World w = new World();
		w.printWorld();	
	}

}
