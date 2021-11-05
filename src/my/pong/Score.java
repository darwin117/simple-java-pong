package my.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Score {

	int p1score = 0;
	int p2score = 0;
	
	Random r = new Random();
	
	public void render(Graphics g) {
		g.setFont(new Font("arial", Font.PLAIN, 50));
		g.setColor(Color.white);
		g.drawString(String.valueOf(p1score/10)+String.valueOf(p1score%10), Jogo.width/2+30, 50);
		g.drawString(String.valueOf(p2score/10)+String.valueOf(p2score%10), Jogo.width/2-100, 50);
	}
	
}
