package editor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import core.World;
import utils.StaticVariables;

public class SaveLevel {
	
	public SaveLevel(World world) {
		writeLevel(world);	
	}

	private void writeLevel(World world) {
		BufferedWriter bw = null;
		char[][] matrix = world.getWorld();
		JFileChooser filec = new JFileChooser();
		if(filec.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		try {
			FileWriter file = null;
			file = new FileWriter(filec.getSelectedFile().getAbsolutePath());
		    //file = new FileWriter(StaticVariables.path);
			bw = new BufferedWriter(file);
			for(int i = 0 ; i < matrix.length ; i++) {
				for(int j = 0 ; j < matrix[i].length ; j++) {
					bw.write(matrix[i][j]);
				
				}
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
