package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	
	public Handler handler;
	
	
	public Bullet(int x, int y, int life, ID id,  Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = 5;
		
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 5, 5);
	}

	
	public void tick() {
		
		y -= velX;
		

	}
	public void collision() throws Exception {
		for (int i = 0; i < handler.basic.getLenght(); i++) {
			
			GameObject tempObject = handler.basic.getData(i);
			
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.BasicEnemyBoss) {//referencia
				if (getBounds().intersects(tempObject.getBounds())) {
					//codigo de colisión
					
					handler.player.deleteBulletCol();
					
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 5, 5);
		
		
	}

	@Override
	public void changeEnemy() {
		// TODO Auto-generated method stub
		
	}

}