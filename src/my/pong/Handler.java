package my.pong;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<Objeto> objeto = new LinkedList<Objeto>();
	
	public void tick() {
		for(int i=0; i<objeto.size(); i++) {
			Objeto obj = objeto.get(i);
			
			obj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<objeto.size(); i++) {
			Objeto obj = objeto.get(i);
			
			obj.render(g);
		}
	}
	
	public void addObjeto(Objeto obj) {
		this.objeto.add(obj);
	}
	
	public void removeObjeto(Objeto obj) {
		this.objeto.remove(obj);
	}
	
}
