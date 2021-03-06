package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Game.Game.STATE;


 /**
  * Realiza las detecciones del teclado ejecutar opereciones definidas
  * @author OlmanFrancisco
  *
  */
public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[3];
	private int cont = 1;
	Player player;
	Game game;
	
	/*
	 * Guarda las constantes de las teclas
	 */
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		
	}
	
	/*
	 * Detecta si una tecla fue presionada y si es alguna de las definidas con comandos(non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.player.getLenght(); i++) {
			GameObject tempObject;
			try {
				tempObject = handler.player.getData(i);
				if (tempObject.getId() == ID.Player) {
					
					if (key == KeyEvent.VK_A) {
						tempObject.setVelX(-5);
						keyDown[0] = true;
						
						
					}
					if (key == KeyEvent.VK_D) {
						tempObject.setVelX(5);
						keyDown[1] = true;
					}
					if (key == KeyEvent.VK_O) {
						
						if (cont == 1){
						handler.addplayerList(new Bullet(handler.player.getX() + 25, Game.HEIGHT - 100, 1, ID.Bullet, handler));
						keyDown[2] = true;
						//cont = 0;
						}
						else {
							//cont++;
						}
						
					}
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			
			
		}
		
		if (key == KeyEvent.VK_P) {
			
			if (Game.gameState == STATE.Game) {
				if (Game.paused) Game.paused = false;
				else Game.paused = true;
			}
			
		}
		if (key == KeyEvent.VK_E) System.exit(1);
		
	}
	
	/*
	 * Detecta cunado una tecla de jo de ser presionada(non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.player.getLenght(); i++) {
			GameObject tempObject;
			
			try {
				tempObject = handler.player.getData(i);
				if (tempObject.getId() == ID.Player) {
					
					if (key == KeyEvent.VK_A) keyDown[0] = false; 
					if (key == KeyEvent.VK_D) keyDown[1] = false;
					if (key == KeyEvent.VK_O) keyDown[2] = false;
					
					//Momento horizontal
					if (!keyDown[0] && !keyDown[1] ) tempObject.setVelY(0);
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			
		}
		
	}

}
