package core;

import java.util.LinkedList;

public class Handler {
	
	 private LinkedList<ObjectsGame> objects;
	 
	 public Handler() {
		objects = new LinkedList<ObjectsGame>();
		
	}
	 
	 public void addObject(ObjectsGame o) {
		 objects.add(o);
		 
	 }
	 
	 public void removeObject(ObjectsGame o) {
		 objects.remove(o);
		 
	 }
	 
	public LinkedList<ObjectsGame> getObjects() {
		return objects;
	}

}
