package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class bullet extends GameObject{
	
	public Handler handler;
	
	
	public bullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 2;
		
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 5, 5);
	}

	
	public void tick() {
		
		y += velX;

		
				
		
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 5, 5);
		
		
	}

}