package my.pong;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Janela extends Canvas {
	
	private static final long serialVersionUID = 8957613578514120332L;

	public Janela(int width, int height, String nome, Jogo jogo) {
		JFrame frame = new JFrame(nome);
		
		frame.setMinimumSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setPreferredSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jogo);
		frame.setVisible(true);
		jogo.start();
	}

}
