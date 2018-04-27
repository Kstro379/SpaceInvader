package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import Conection.ServerAndroid;
import Game.Game.STATE;

/**
 * Encargado de desplagar todos los menus del juego, sus botones y caracteristicas, así como animaciones y sonidos
 * @author OlmanFrancisco
 *
 */

public class Menu extends MouseAdapter {
	
	private Handler handler;
	private HUD hud;
	
	
	
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		
	}
	
	/**
	 * Detecta los eventos del mouse y se se encuentar en la posión de alfgin botón al hacer click
	 */
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (Game.gameState == STATE.Menu) {
			// Boton de inicio
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				Game.gameState = STATE.Select;
				System.out.println("aaaaaaaaaaaaaaa");
				AudioPlayer.getSound("button_sound").play();
				AudioPlayer.getSound("start_sound").play();
			}

			// Boton de ayuda
			if (mouseOver(mx, my, 210, 250, 200, 64)) {
				Game.gameState = STATE.Help;
				AudioPlayer.getSound("button_sound").play();

			}

			// Boton de finalizar
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				AudioPlayer.getSound("button_sound").play();
				System.exit(1);
				
			}

			// Regresar de ayuda
		} else if (Game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
				AudioPlayer.getSound("button_sound").play();
				return;
			}
			/**
			 * Si el menú es el del final ejecuta las funciones de crear botones y las particulas 
			 */
		}else if (Game.gameState == STATE.End) {
			
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				handler.clearEnemys();
				handler.addplayerList(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT - 100, 1, ID.Player, handler));
				AudioPlayer.getSound("button_sound").play();
				
		
			}
			/**
			 * Si el menú es el del select ejecuta las funciones de crear botones y las particulas 
			 */

		}else if (Game.gameState == STATE.Select) {
			//Boton de inicio
			if (mouseOver(mx, my, 210, 250, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.clearEnemys();
				handler.addplayerList(new Player((Game.WIDTH / 2) - 32, Game.HEIGHT - 100, 1, ID.Player, handler));
				AudioPlayer.getSound("button_sound").play();
				
				
			
				/**
				 * Si el menú es el inicial ejecuta las funciones de crear botones y las particulas 
				 */
			}else if (mouseOver(mx, my, 210, 150, 200, 64)) {
					Game.gameState = STATE.Game;
					handler.clearEnemys();
					handler.addplayerList(new Player((Game.WIDTH / 2) - 32, Game.HEIGHT - 100, 1, ID.Player, handler));
					AudioPlayer.getSound("button_sound").play();
					
			}
		}
	}
	/*
	 * Calcula las posiciones del mouse(non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */

	public void mouseReleased(MouseEvent e) {
		
	}
	
	//Revisa si esta dentro del retangulo
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	/*
	 * Dibuja los componetes según el menú que se este utilizndo
	 */
	public void render(Graphics g) {
		
		if (Game.gameState == STATE.Menu){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Menú", 240, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Jugar", 273, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Ayuda", 273, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quitar", 273, 390);
			
		}else if (Game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Ayuda", 240, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Volver", 273, 390);
			
		}else if (Game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Gamer Over", 170, 70);
			
			g.setFont(fnt2);
			g.drawString("Has perdido", 225, 215);
			g.drawString("Score: " + hud.getScore(), 240, 280);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 240, 390);
				
		}if (Game.gameState == STATE.Select){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Aplicación movil", 240, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Conectar", 273, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Omitir", 273, 290);
			
			
		}
	}
}
