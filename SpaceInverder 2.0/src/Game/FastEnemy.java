package Game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;



public class FastEnemy extends GameObject{
	
	public Handler handler;
	
	private BufferedImage enemy_image;
	private SpriteSheet ss = new SpriteSheet(Game.sprite_enemy);
	private SpriteSheet ss2 = new SpriteSheet(Game.sprite_sheet);
	private Random r = new Random();
	private int cont = 0;

	
	
	
	
	public FastEnemy(int x, int y,  int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = 5;
		velY = 5;
		enemy_image = ss.grabImage(1, 1, 50, 41);
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 41);
	}
	
	public void changeEnemy(int value) {
		
		if (value == 1) {
			
			enemy_image = ss2.grabImage(1, 1, 50, 41);
			id = ID.BasicEnemyBoss;
			
			
			while (cont < 1) {
				cont = r.nextInt(8);
			}
			
			life = cont;
			
		}else {
			
			enemy_image = ss2.grabImage(1, 1, 50, 41);
			id = ID.BasicEnemyBoss;
			
		}
		
		
		
		
	}

	
	public void tick() {
		
		x += velX;
		y += velY;
		
		
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

	@Override
	public void sumPos() {
		
		if (getVelX() > 0) {
			x = x+65;
		}else {
			x = x - 65;
		}
		
		
	}

	@Override
	public void resPos() {
		
		if (getVelX() > 0) {
			x = x-65;
		}else {
			x = x + 65;
		}
		
	}



	@Override
	public void chanceX(int value) {
		if (value == 1) {
			
			while (velX < 0) {
				velX *= -1;
			}
			
		}else {
			
			while(velX > 0) {
				velX *= -1;
			}
		}
		
	}

	@Override
	public void changeY(int value) {
		
		if (value == 1) {
			
			while (velY< 0) {
				velY *= -1;
			}
		}else {
			
			while(velY > 0) {
				velY *= -1;
			}
		}
		
		
	}



}