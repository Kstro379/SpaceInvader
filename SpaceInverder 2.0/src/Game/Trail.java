package Game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Trail extends GameObject {
	
	private float alpha = 1;
	private float life1;
	
	private Handler handler;
	private Color color;
	
	
	private int width, height;
	
	//life = 0.001 -0.1

	public Trail(int x, int y, int life, ID id, Color color, int width, int height, float life1, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life1 = life1;
		
	}

	public void tick() {
		if (alpha > life1) {
			alpha -= (life1 - 0.0001f);
		}//else handler.removeObject(this);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTrasparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		g2d.setComposite(makeTrasparent(1));
		
	}
	
	private AlphaComposite makeTrasparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public Rectangle getBounds() {
		return null;
	}

}
