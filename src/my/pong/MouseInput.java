package my.pong;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import my.pong.Jogo.Estado;

public class MouseInput implements MouseListener {
	
	Score score = Jogo.score;

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		if(Jogo.estado != Estado.jogo) {
			if(Jogo.estado == Estado.menu) {
				if(mouseX >= Jogo.width/2-110 && mouseX <= Jogo.width/2-10) {
					if(mouseY >= Jogo.height/2-17 && mouseY <= Jogo.height/2+33) {
						Jogo.estado = Estado.jogo;
					}
				}
			}
			else {
				if(mouseX >= Jogo.width/2-110 && mouseX <= Jogo.width/2-10) {
					if(mouseY >= Jogo.height/2-17 && mouseY <= Jogo.height/2+33) {
						score.p1score = 0;
						score.p2score = 0;
						Jogo.estado = Estado.jogo;
					}
				}
			}
			if(mouseX >= Jogo.width/2+10 && mouseX <= Jogo.width/2+110) {
				if(mouseY >= Jogo.height/2-17 && mouseY <= Jogo.height/2+33) {
					System.exit(0);
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}
