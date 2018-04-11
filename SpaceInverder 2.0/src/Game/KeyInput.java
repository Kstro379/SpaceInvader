package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Game.Game.STATE;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[3];
	Player player;
	
	Game game;
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		
	}
	
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
						handler.addplayerList(new Bullet(handler.player.getX() + 25, Game.HEIGHT - 100, 1, ID.Bullet, handler));
						keyDown[2] = true;
						
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
