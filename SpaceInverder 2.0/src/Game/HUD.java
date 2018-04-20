package Game;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Encargada de actualizar los datos relevantes al jugar
 */
public class HUD {
	
	public static int HEALTH = 100;
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	private String current = " ";
	private String following = " ";
	

	/*
	 * Crea y actualiza la barra de vida
	 */
	public void tick() {
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2;
		score++;
		
	}
	
	/*
	 * Dibuja en pantalla, la vida score y nivel
	 */
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 525, 35);
		g.drawString("Level: " + level, 430, 35);
		g.drawString("Current: " + current, 230, 35);
		g.drawString("Following: " + following, 320, 35);
		
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	
	

}
