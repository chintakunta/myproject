package javabasic1;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Game extends JPanel
{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1000, HEIGHT = 1000;
	public Game() 
	{
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}

}
