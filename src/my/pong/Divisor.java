package my.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Divisor extends Objeto {
	
	Handler handler;
	Random rand = new Random();
	public Divisor(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		g.fillRect(x, y, 2, 8);
	}

	public Rectangle getBounds() {
		return null;
	}

}
