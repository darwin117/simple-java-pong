package my.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import my.pong.Jogo.Estado;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	private boolean[] keyDown = new boolean[4];
	
	int velP = 7;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		for(int i=0; i<keyDown.length; i++) {
			keyDown[i] = false;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i<handler.objeto.size(); i++) {
			Objeto obj = handler.objeto.get(i);
			
			if(obj.getID() == ID.Player1) {
				if(key == KeyEvent.VK_UP) { obj.setVelY(-velP); keyDown[0] = true; }
				if(key == KeyEvent.VK_DOWN) { obj.setVelY(velP); keyDown[1] = true; }
			}
			if(obj.getID() == ID.Player2) {
				if(key == KeyEvent.VK_W) { obj.setVelY(-velP); keyDown[2] = true; }
				if(key == KeyEvent.VK_S) { obj.setVelY(velP); keyDown[3] = true; }
			}
			
		}
		if(key == KeyEvent.VK_ESCAPE) {
			if(Jogo.estado == Estado.jogo) Jogo.estado = Estado.menu;
			else System.exit(0);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i<handler.objeto.size(); i++) {
			Objeto obj = handler.objeto.get(i);
			
			if(obj.getID() == ID.Player1) {
				if(key == KeyEvent.VK_UP) keyDown[0] = false;
				if(key == KeyEvent.VK_DOWN) keyDown[1] = false;
				
				if(!keyDown[0] && !keyDown[1]) obj.setVelY(0);
				else if(keyDown[0] && !keyDown[1]) obj.setVelY(-velP);
				else if(!keyDown[0] && keyDown[1]) obj.setVelY(velP);
			}
			
			if(obj.getID() == ID.Player2) {
				if(key == KeyEvent.VK_W) keyDown[2] = false;
				if(key == KeyEvent.VK_S) keyDown[3] = false;
				
				if(!keyDown[2] && !keyDown[3]) obj.setVelY(0);
				else if(keyDown[2] && !keyDown[3]) obj.setVelY(-velP);
				else if(!keyDown[2] && keyDown[3]) obj.setVelY(velP);
				
			}
		}
	}

}