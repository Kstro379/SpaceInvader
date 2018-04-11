package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject{
	
	public Handler handler;
	
	private int timer = 100;
	private int timer2 = 50;
	Random r = new Random();
	
	public BossEnemy(int x, int y, int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = 0;
		velY = 2;
		
		
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 96, 96);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		if (timer <= 0) {
			velY = 0;
		
		}else {
			timer--;
		}
		
		if (timer <= 0)
			timer2--;
		if (timer2 <= 0) {

			if (velX == 0)
				velX = 2;

			if (velX > 0)
				velX += (int) 0.01f;
			else if (velX < 0)
				velX -= (int) 0.01f;
			
			
			
			int spawn = r.nextInt(10);
			if (spawn == 0)
				handler.addplayerList((new BossBulletEnemy(x + 48, y + 48, 5, ID.BasicEnemy, handler)));
		}
		
		
		
		
		
		//if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 96)velX *= -1;
				
		//handler.addSimpleList(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.08f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 96, 96);
		
		
	}

}