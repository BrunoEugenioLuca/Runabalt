package utils;

import java.awt.Toolkit;

public interface StaticVariables {
	
	// @author SuperNinja variabili statiche per il mondo logico
	
	public static int WORLD_HEIGHT = 5;
	public static int WORLD_WIDTH = 10;
	

	// varialbli statiche per la classe Player

	public static double maxSpeed = 8.0;
	public static double minSpeed = 0.5;
	public static double stop = 1.5;
	public static int updateSpeed = 2;
	public static double maxFallSpeed = 10;
	
	// @author SuperNinja path statico per salvare il livello
	
	public static String path = "C:\\Users\\Luca\\git\\Runabalt\\Runabalt2\\levels";
	
	
	// @author SuperNinja caratteri per identificare gli oggetti
	
	public static char player = 'P';
	public static char palace = 'B';
	public static char gru = 'G';
	public static char archive = 'A';
	public static char empty = '-';
	

	// variabili statiche per il frame

	public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

}
