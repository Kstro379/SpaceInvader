package Game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Esta es la clase donde se necunetran tosos los comando que llegará a necesitar el jugador para 
 * su funciomalidad
 * @author OlmanFrancisco
 *
 */

public class Player extends GameObject {
	
	Handler handler;
	
	
	
	private BufferedImage player_image;
	

	public Player(int x, int y, int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		player_image = ss.grabImage(1, 1, 50, 33);
		
			
	}
	/**
	 * Crea un retangulo para las colisiones
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 33);
	}
	

	/**
	 * Actuliza posición imagenes y colisión
	 */

	public void tick() {
		
		x += velX;
		
		x = Game.clamp(x, 0, Game.WIDTH - 68);
		y = 400;
		
		try {
			collision();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Se encarga de verificar si hay alguna cilisión existente
	 * @throws Exception
	 */
	public void collision() throws Exception {
		for (int i = 0; i < handler.basic.getLenght(); i++) {
			
			GameObject tempObject = handler.basic.getData(i);
			
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy
					|| tempObject.getId() == ID.BasicEnemyBoss) {// referencia
				if (getBounds().intersects(tempObject.getBounds())) {
					// codigo de colisión
					HUD.HEALTH -= 2;
				}

			}
		}
		 
		
		
	}

	/*
	 * Dibuja imagen
	 * @see Game.GameObject#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		
	
		g.drawImage(player_image, x, y, null);
		
		
	}

	@Override
	public void changeEnemy(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sumPos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resPos() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void chanceX(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeY(int value) {
		// TODO Auto-generated method stub
		
	}


}
