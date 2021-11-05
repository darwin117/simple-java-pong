package my.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends Objeto {
	
	public static final int w = 16;
	public static final int h = 80;

	Handler handler;
	
	Random r = new Random();
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id); 
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
	
	public void tick() {
		y += velY;
		y = Jogo.clamp(y, 0, Jogo.height-(h+(h/3)));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, w, h);
	}

}