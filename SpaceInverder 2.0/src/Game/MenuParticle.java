package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * Se encargar de dibujar las particulas del menú
 * @author OlmanFrancisco
 *
 */

public class MenuParticle extends GameObject{
	
	public Handler handler;
	Random r = new Random();
	
	private Color colorParticle;
	
	
	
	
	public MenuParticle(int x, int y, int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = (r.nextInt(7 - -7) + -7);
		velY = (r.nextInt(7 - -7) + -7);
		if (velX == 0) velX = 1;
		if (velY == 0) velY = 1;
		
		
		colorParticle = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
		
		
		
	}
	/**
	 * Dibuja retangulo para colisiones
	 */
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	/**
	 * Acualiza posiciones y comprieba que no se salga de la pantalla
	 */
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16)velX *= -1;
				
		//handler.addSimpleList(new Trail(x, y, ID.Trail, colorParticle, 16, 16, 0.1f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(colorParticle);
		g.fillRect(x, y, 16, 16);
		
		
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