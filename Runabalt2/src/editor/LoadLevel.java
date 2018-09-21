package editor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import core.World;

public class LoadLevel {
	
	
	public LoadLevel(String level_path, World world) {
		readlevel(level_path, world);
	}

	private void readlevel(String level_path, World world) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(level_path));
			String line = reader.readLine();
			int i= 0;
			while(line != null) {
				world.addChar(i, line.toCharArray());
				world.addToList(i,line.toCharArray());
				i++;
				line = reader.readLine();
			}	
			reader.close();
 		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("FILE NOT FOUND");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
