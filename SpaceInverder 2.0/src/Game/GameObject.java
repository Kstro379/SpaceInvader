package Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected int life;
	private Random r = new Random();
	
	public GameObject(int x, int y, int life, ID id) {
		this.x = x;
		this.y = y;
		this.life = life;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void changeEnemy();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getLife() {
		return life;
	}

	public void setLife(int data) {
		this.life = life - data ;
	}
	
	public void saveLife(int data) {
		this.life = data;
	}
	
	public void res() {
		if (getVelX() > 0) {
			x = x-65;
		}else {
			x = x + 65;
		}
		
	}
	
	public void IncrementLife(){
		
		int value = 0;
		while (value < 0) {
			value = r.nextInt(6);
		}
		saveLife(value);
	}
	
	

}
