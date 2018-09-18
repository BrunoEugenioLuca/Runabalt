package launch;

import GUI.Window;
import core.World;
import utils.StaticVariables;

public class Launcher {
	
	public static void main(String args[]) {
		new Window();
		World w = new World();
		w.printWorld();
	}

}
