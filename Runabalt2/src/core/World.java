package core;

import utils.StaticVariables;

public class World {
	
	private char[][] matrix;
	
	public World() {
		matrix = new char[StaticVariables.WORLD_WIDTH][StaticVariables.WORLD_HEIGHT];
		getMatix();
		
	}
	
	public char[][] getMatix() {
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[i].length ; j++){
				matrix[i][j] = StaticVariables.empty;
			}
		}
		return matrix;
	}
	
	public void add(ObjectsGame o) {
		
		if(o instanceof Player)
			matrix[(int) o.getX()][(int)o.getY()] = StaticVariables.player;
		else if(o instanceof Palace)
			matrix[(int)o.getX()][(int)o.getY()] = StaticVariables.palace;
		else if(o instanceof Gru)
			matrix[(int) o.getX()][(int) o.getY()] = StaticVariables.gru;
		else if(o instanceof Archive)
			matrix[(int)o.getX()][(int) o.getY()] = StaticVariables.archive;
	}
	
	public void remove(ObjectsGame o) {
		matrix[(int)o.getX()][(int) o.getY()] = StaticVariables.empty;
	}
	
	
	public void printWorld() {
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[i].length; j++ ) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
