package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossBulletEnemy extends GameObject{
	
	public Handler handler;
	Random r = new Random();
	
	public BossBulletEnemy(int x, int y, int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
		
		
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		//if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		//if (x <= 0 || x >= Game.WIDTH - 16)velX *= -1;
		
		//if (y >= Game.HEIGHT) handler.removeObject(this);
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.white, 16, 16, 0.02f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
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