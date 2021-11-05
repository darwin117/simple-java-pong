package my.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Menu {
	
	Random r = new Random();
	
	public Rectangle playBtn = new Rectangle(Jogo.width/2-110, Jogo.height/2-17, 100, 50);
	public Rectangle exitBtn = new Rectangle(Jogo.width/2+10, Jogo.height/2-17, 100, 50);
	
	public void render(Graphics g) {
		Font f1 = new Font("arial", Font.BOLD, 50);
		g.setFont(f1);
		g.setColor(Color.white);
		g.drawString("PONG", Jogo.width/2-77, Jogo.height/2-40);
		
		Graphics2D g2d = (Graphics2D) g;
		Font f2 = new Font("arial", Font.BOLD, 30);
		g.setFont(f2);
		g.setColor(Color.white);
		g.drawString("Play", playBtn.x+19, playBtn.y+35);
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g2d.draw(playBtn);
		g.setColor(Color.white);
		g.drawString("Sair", exitBtn.x+21, exitBtn.y+35);
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g2d.draw(exitBtn);
	}

}
