package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

public class LevelUpdate {
	
	private LinkedList<ObjectsGame> objects;
	private FileReader file;
	private String file_path;
	
	public LevelUpdate(String path) {
		objects = new LinkedList<ObjectsGame>();
		readLevel(path);
	}
	
	public void readLevel(String path) {
		try {
			file = new FileReader(file_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(" FILE NOT FOUND ");
		}
	}
	
	public LinkedList<ObjectsGame> getObjects(){
		return objects;
	}
	
	public void addObjects(char c) {
		
	}
	
	public void removeObjects(ObjectsGame o) {
		objects.remove(o);
	}

}
