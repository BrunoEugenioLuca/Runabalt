package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import utils.StaticVariables;

public class World {
	
	private char[][] matrix;
	
	
	public World() {
		matrix = new char[StaticVariables.WORLD_WIDTH][StaticVariables.WORLD_HEIGHT];
		//this.getMatix();
		String s = "levels/lll.txt";
		this.readTxt(s);
	}
	
	public char[][] getMatix() {
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[i].length ; j++){
				matrix[i][j] = StaticVariables.empty;
			}
		}
		return matrix;
	}
	
	public void clear() {
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[i].length ; j++){
				matrix[i][j] = StaticVariables.empty;
			}
		}
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
	
	public void readTxt(String file){

		try {
			BufferedReader read = new BufferedReader(new FileReader(file));
			int riga = 0;
			String linea = read.readLine();
			while (linea != null) {
				matrix[riga] = linea.toCharArray();
				riga++;
				linea = read.readLine();
			}	
			read.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LinkedList<ObjectsGame> getObjects(){
		LinkedList<ObjectsGame> objects = new LinkedList<ObjectsGame>();
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[i].length ; j++) {
				char c = matrix[i][j];
				switch (c) {
				case 'P':
					objects.add(new Player(i, j));
					break;
				case 'B':
					objects.add(new Palace(j, j));
					break;
				case 'G':
					objects.add(new Gru(i, j));
					break;
				case 'A':
					objects.add(new Archive(i, j));
					break;
				default:
					break;
				}
			}
		}
		
		return objects;
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
