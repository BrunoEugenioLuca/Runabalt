package GUI;

import java.awt.Component;
import core.World;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	private Component currentComponent;

	public Window() {
		currentComponent = new Display();

		initFrame();
	}

	public void initFrame() {
		this.add(currentComponent);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

}
