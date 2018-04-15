package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	
	public Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		for (int i = 0; i < handler.player.getLenght(); i++) {
			try {
				if (handler.player.getData(i).getId() == ID.Player) {
					player = handler.player.getData(i);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y - player.getY())*y - player.getY()); 
		
		velX = (int) ((-1.0/distance) * diffX);
		velY = (int) ((-1.0/distance) * diffY);
		
		if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16)velX *= -1;
				
		//handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.1f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 16, 16);
		
		
	}

	@Override
	public void changeEnemy() {
		// TODO Auto-generated method stub
		
	}

}