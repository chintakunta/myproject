package javabasic1;

import javax.swing.JFrame;

public class Snake {
	public Snake() {
		JFrame frame=new JFrame();
		Game game1=new Game();
		
		frame.add(game1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Snakecooing");
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args)
	{
		

	}

}
