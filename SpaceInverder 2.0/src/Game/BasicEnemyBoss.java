package Game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


	/*
	 * Clase encargada de crear al jefe de cada lista
	 */
public class BasicEnemyBoss extends GameObject{
	
	public Handler handler;
	
	private BufferedImage enemy_image;
	private SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
	private SpriteSheet ss2 = new SpriteSheet(Game.sprite_enemy);

	public BasicEnemyBoss(int x, int y,  int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = 3;
		
		
		enemy_image = ss.grabImage(1, 1, 50, 41);
		
		
	}
	/*
	 * Dibuja retangulo para colisiones(non-Javadoc)
	 * @see Game.GameObject#getBounds()
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 41);
	}
	/*
	 * Camba las propiedades del objecto(non-Javadoc)
	 * @see Game.GameObject#changeEnemy(int)
	 */
	@Override
	public void changeEnemy(int value) {
			
			if (id == ID.BasicEnemy) {
				id = ID.BasicEnemyBoss;
				life = 5;
				enemy_image = ss.grabImage(1, 1, 50, 41);
			}
			else {
				id = ID.BasicEnemy;
				life = 1;
				enemy_image = ss2.grabImage(1, 1, 50, 41);
			}
			
			
					
		
	}
	
	/*
	 * Actializa las posicion y vida de objecto y revisa si hay colisión(non-Javadoc)
	 * @see Game.GameObject#tick()
	 */
	public void tick() {
		
		
		
		x += velX;
		if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
			y += 40;
			
		}
		try {
			collision();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
	}

	/*
	 * Metodo para detectar si existe alguna colisión
	 */
	public void collision() throws Exception {
		

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
	/*
	 * Regresa el ID del objecto
	 */
	public ID getID() {
		return id;
	}
	/*
	 * Dibuja al objeto(non-Javadoc)
	 * @see Game.GameObject#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		g.drawImage(enemy_image, x, y, null);
		
		
	}

	
	/*
	 * Suma cordenadas vectoriales al objecto(non-Javadoc)
	 * @see Game.GameObject#sumPos()
	 */
	@Override
	public void sumPos() {
		
		if (getVelX() > 0) {
			x = x+65;
		}else {
			x = x - 65;
		}
		
		
	}
/*
 * Resta cordenadas vectoriales al objecto(non-Javadoc)
 * @see Game.GameObject#resPos()
 */
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeY(int value) {
		// TODO Auto-generated method stub
		
	}

}
