package Game;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	Random r = new Random();
	
	private int positionY;
	private int scoreKeep = 0;
	private int positionX;
	private int cont = 0;
	private int check = 0;
	private int value = 0;
	
	
	
	public Spawn(Handler handler, HUD hud) {
		this.handler  = handler;
		this.hud = hud;
		positionX = 100;
		positionY = 100;
		
		
	}
	
	public void tick() {
		scoreKeep++;
		
		//Recuerde agregra los anemigos a las listas 
		//correspondinetes por medio de for
		//solo necestia una lista de cada una 
		// despues solo avanza con score 
		//luego los enmigos tiene la direccion
		
		if (scoreKeep >= 100) {
			scoreKeep = 0;
			cont = 0;
			check = 0;
			value = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			
		
			}else if (hud.getLevel() == 2 && cont == 0 ) {
				
					for (int i = 1; i <= 5; i++) {
						
						positionX += 15;
						handler.addSimpleListBasic(new BasicEnemy(positionX, positionY, ID.BasicEnemy, handler));
						positionX += 50;
					cont++;
	
				
					
				}
				
				
				
			}else if (hud.getLevel() == 3 && cont == 0) {
				
				positionX = 100;
				
				for (int i = 1; i < 5; i++) {

					value = r.nextInt(3);
					
					if (value == 2 && check == 0) {
						
						positionX += 15;
						handler.addSimpleListBasic(new BasicEnemyBoss(positionX, 40, ID.BasicEnemyBoss, handler));
						positionX += 50;
						check++;
						
					
					}else {
						
						positionX += 15;
						handler.addSimpleListBasic(new BasicEnemy(positionX, 40, ID.BasicEnemy, handler));
						positionX += 50;
							
					}
					
				}
				if (check == 0) {
					positionX += 15;
					handler.addSimpleListBasic(new BasicEnemyBoss(positionX, 40, ID.BasicEnemyBoss, handler));
					positionX += 50;
					
				}else {
					positionX += 15;
					handler.addDoubleList(new BasicEnemy(positionX, 40, ID.BasicEnemy, handler));
					positionX += 50;
				}
				cont++;
					
				
			
			}else if (hud.getLevel() == 4 && cont == 0) {
				
				positionX = 100;
				
				for (int i = 1; i < 5; i++) {

					value = r.nextInt(3);
					
					if (value == 2 && check == 0) {
						
						positionX += 15;
						handler.addDoubleList(new BasicEnemyBoss(positionX, 20, ID.BasicEnemyBoss, handler));
						positionX += 50;
						check++;
						
					
					}else {
						
						positionX += 15;
						handler.addDoubleList(new BasicEnemy(positionX, 20, ID.BasicEnemy, handler));
						positionX += 50;
							
					}
					//Comprobar que se agrego!!!
					
				}
				if (check == 0) {
					positionX += 15;
					handler.addDoubleList(new BasicEnemyBoss(positionX, 20, ID.BasicEnemyBoss, handler));
					positionX += 50;
				}
				else {
					positionX += 15;
					handler.addDoubleList(new BasicEnemy(positionX, 20, ID.BasicEnemy, handler));
					positionX += 50;
				}
				cont++;
			
				
			

			}else if (hud.getLevel() == 5) {

				
			}else if (hud.getLevel() == 6) {
				
				
			}else if (hud.getLevel() == 7) {
				
			}else if (hud.getLevel() == 10) {
				//handler.clearEnemys();
				//handler.addObject(new BossEnemy((Game.WIDTH / 2) - 100, -96, ID.BossEnemy, handler));
	}
		
	}
		


	
}
