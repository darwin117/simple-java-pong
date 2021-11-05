package my.pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Jogo extends Canvas implements Runnable {

	private static final long serialVersionUID = -8684432279863489716L;
	
	public static final int width = 760, height = width/12*7;
	public static final String nome = "Pong xd";
	
	Random r = new Random();
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	private Menu menu = new Menu();
	public static Score score = new Score();
	private Vitoria win = new Vitoria();
	
	public enum Estado {
		menu,
		jogo,
		win;
	}
	
	public static Estado estado = Estado.menu;
	
	public Jogo() {
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput());
				
		new Janela(width, height, nome, this);
		
		players();
		
		for(int i=-15; i<=15; i++) {
			int h = height/2-(16*i);
			handler.addObjeto(new Divisor(width/2-8, h, ID.Divisor, handler));
		}
		
		bola();
		
	}
	
	public void players() {
		handler.addObjeto(new Player(width-48, height/2-64, ID.Player1, handler));
		handler.addObjeto(new Player(16, height/2-64, ID.Player2, handler));
	}
	
	public void bola() {
		handler.addObjeto(new Bola(width/2-16, height/2-32, ID.Bola, handler));
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double numTicks = 60D;
		double ns = 1000000000/numTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) render();
			frames++;
			
			if(System.currentTimeMillis()-timer>1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		if(estado == Estado.jogo) {
			handler.tick();
			win.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		if(estado == Estado.jogo) {
			handler.render(g);
			score.render(g);
		}
		else if(estado == Estado.menu) {
			menu.render(g);
		}
		else if(estado == Estado.win) {
			if(score.p1score > score.p2score) win.render(g, 1);
			else win.render(g, 2);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var>=max) {
			return var = max;
		}
		else if(var<=min) {
			return var = min;
		}
		else {
			return var;
		}
	}
	
	public static void main(String[] args) {
		new Jogo();
	}

}

