package Game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Player extends GameObject {
	
	Handler handler;
	
	
	private BufferedImage player_image;
	

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		player_image = ss.grabImage(1, 1, 50, 33);
		
			
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 33);
	}
	

	

	public void tick() {
		
		x += velX;
		
		x = Game.clamp(x, 0, Game.WIDTH - 68);
		y = 400;
		
		try {
			collision();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//handler.addObject(new Trail(x+8, y+12, ID.Trail, Color.white, 15, 15, 0.1f, handler));
		
		
	}
	
	public void collision() throws Exception {
		for (int i = 0; i < handler.basic.getLenght(); i++) {
			
			GameObject tempObject = handler.basic.getData(i);
			
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.BasicEnemyBoss) {//referencia
				if (getBounds().intersects(tempObject.getBounds())) {
					//codigo de colisión
					HUD.HEALTH -= 2;
				}
				
			}
		}
	}

	
	public void render(Graphics g) {
		
	
		g.drawImage(player_image, x, y, null);
		
		
	}

}
