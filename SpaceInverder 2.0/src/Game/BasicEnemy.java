package Game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;



public class BasicEnemy extends GameObject{
	
	public Handler handler;
	
	private BufferedImage enemy_image;
	private SpriteSheet ss = new SpriteSheet(Game.sprite_enemy);
	private SpriteSheet ss2 = new SpriteSheet(Game.sprite_sheet);
	private Random r = new Random();
	
	
	
	
	public BasicEnemy(int x, int y,  int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = 3;
		
		enemy_image = ss.grabImage(1, 1, 50, 41);
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 41);
	}
	
	public void changeEnemy() {
		
		enemy_image = ss2.grabImage(1, 1, 50, 41);
		id = ID.BasicEnemyBoss;
		life = 3;
		
		
		
	}
	

	public void tick() {
		
		x += velX;
		if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
			y += 40;
		}
		
		try {
			collision();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
				
		
		
	}
	
	public void collision()  {
		for (int i = 0; i < handler.player.getLenght(); i++) {
			
			GameObject tempObject = handler.player.getData(i);
			
			if (tempObject.getId() == ID.Bullet) {
				if (getBounds().intersects(tempObject.getBounds())) {
					setLife(1);
					handler.player.deleteBulletCol();
				}
				
			}
		}
	}

	
	public void render(Graphics g) {
		g.drawImage(enemy_image, x, y, null);
		
		
	}

}
