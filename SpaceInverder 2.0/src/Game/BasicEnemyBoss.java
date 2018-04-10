package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class BasicEnemyBoss extends GameObject{
	
	public Handler handler;
	
	
	public BasicEnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 5;
		
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 40, 40);
	}

	
	public void tick() {
		
		x += velX;
		
		
		if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
			y += 40;
		}
				
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.1f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 40, 40);
		
		
	}
	
	public ID getID() {
		return id;
	}

}
