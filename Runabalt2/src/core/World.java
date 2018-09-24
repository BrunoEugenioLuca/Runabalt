package core;

import java.util.LinkedList;

import utils.StaticVariables;

public class World {

	private char[][] matrix;
	private LinkedList<ObjectsGame> objectsGame;

	public World() {
		matrix = new char[StaticVariables.WORLD_HEIGHT][StaticVariables.WORLD_WIDTH];
		objectsGame = new LinkedList<ObjectsGame>();
		emptyWorld();
	}

	public char[][] emptyWorld() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = StaticVariables.empty;
			}
		}
		return matrix;
	}

	public char[][] getWorld() {
		return matrix;
	}

	public void clear() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = StaticVariables.empty;
			}
		}
	}

	public void addChar(int i, char[] c) {
		matrix[i] = c;
	}

	public void add(ObjectsGame o) {

		if (o instanceof Player)
			matrix[(int) o.getX()][(int) o.getY()] = StaticVariables.player;
		else if (o instanceof Palace)
			matrix[(int) o.getX()][(int) o.getY()] = StaticVariables.palace;
		else if (o instanceof Gru)
			matrix[(int) o.getX()][(int) o.getY()] = StaticVariables.gru;
		else if (o instanceof Archive)
			matrix[(int) o.getX()][(int) o.getY()] = StaticVariables.archive;
	}

	public void addToList(int i, char[] list) {
		for (int j = 0; j < list.length; j++) {
			char c = list[j];
			switch (c) {
			case 'P':
				objectsGame.add(new Player(i, j, this));
				break;
			case 'B':
				objectsGame.add(new Palace(j, j));
				break;
			case 'G':
				objectsGame.add(new Gru(i, j));
				break;
			case 'A':
				objectsGame.add(new Archive(i, j));
				break;
			default:
				break;
			}
		}
	}

	public void remove(ObjectsGame o) {
		matrix[(int) o.getX()][(int) o.getY()] = StaticVariables.empty;
	}

	public LinkedList<ObjectsGame> getObjectsGame() {
		return objectsGame;
	}

	public void setObjectsGame(LinkedList<ObjectsGame> objectsGame) {
		this.objectsGame = objectsGame;
	}

	public void printWorld() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
