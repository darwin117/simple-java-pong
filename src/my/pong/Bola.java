package my.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola extends Objeto {
	
	public static final int vel = 5;
	public static final int w = 16;
	public static final int h = 16;
	
	Random r = new Random();
	
	Handler handler;
	Score score = Jogo.score;	
	
	public Bola(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = setDir(vel);
		velY = setDir(vel);
	}
	
	public int setDir(int vel) {
		int rand = r.nextInt(2);
		if(rand == 0) rand--;
		return vel*rand;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);	
	}
	
	private void collision() {
		for(int i=0; i<handler.objeto.size(); i++) {
			Objeto obj = handler.objeto.get(i);
			if(obj.getID() == ID.Player1 || obj.getID() == ID.Player2) {
				if(getBounds().intersects(obj.getBounds())) {
					velX*=-1;
					int rand = r.nextInt(2);
					if(rand == 0) rand--;
					velY*=rand;
				}
			}
		}
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y<=0 || y>=Jogo.height-(h*3)) velY *= -1;
		if(x<=-w) {
			score.p1score++;
			//System.out.println("p1: "+score.p1score);
			x = Jogo.width/2-w;
			velX = setDir(vel);
			y = Jogo.height/2-w;
			velY = setDir(vel);
					
		}
		if(x>=Jogo.width-w) {
			score.p2score++;
			//System.out.println("p2: "+score.p2score);
			x = Jogo.width/2-w;
			velX = setDir(vel);
			y = Jogo.height/2-w;
			velY = setDir(vel);
		}
		
		collision();
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, w, h);
	}

}
