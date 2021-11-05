package my.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import my.pong.Jogo.Estado;

public class Vitoria {
	
	Score score = Jogo.score;
	
	Random r = new Random();
	
	public Rectangle replayBtn = new Rectangle(Jogo.width/2-110, Jogo.height/2-17, 100, 50);
	public Rectangle exitBtn = new Rectangle(Jogo.width/2+10, Jogo.height/2-17, 100, 50);
	
	public void tick() {
		if(score.p1score == 10) {
			Jogo.estado = Estado.win;
		}
		if(score.p2score == 10) {
			Jogo.estado = Estado.win;
		}
	}
	
	public void render(Graphics g, int winner) {
		Font f1 = new Font("arial", Font.BOLD, 50);
		g.setFont(f1);
		g.setColor(Color.white);
		
		if(winner == 1) g.drawString("Jogador 1 ganhou!", Jogo.width/2-220, Jogo.height/2-40);
		else g.drawString("Jogador 2 ganhou!", Jogo.width/2-220, Jogo.height/2-40);
		
		Graphics2D g2d = (Graphics2D) g;
		Font f2 = new Font("arial", Font.BOLD, 20);
		g.setFont(f2);
		g.setColor(Color.white);
		g.drawString("Repetir", replayBtn.x+15, replayBtn.y+32);
		g.setColor(Color.green);
		g2d.draw(replayBtn);
		g.setColor(Color.white);
		g.drawString("Sair", exitBtn.x+29, exitBtn.y+32);
		g.setColor(Color.red);
		g2d.draw(exitBtn);
	}
	
}
