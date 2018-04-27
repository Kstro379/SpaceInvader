package Game;

import java.util.Random;

/**
 * La clase spawn es la encargada de crear los enemigos por nivel, cargandolos en la listas predefinidas
 * @author OlmanFrancisco
 *
 */

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
		positionX = 10;
		positionY = 200;
	
	}
	
	/**
	 * Este metodo es el encargado de actualizar los enemigos según el nivel en que se encuentran
	 * cargando en listas los eneimgos correspondientes
	 */
	
	public void tick() {
		scoreKeep++;
		
		//Recuerde agregra los anemigos a las listas 
		//correspondinetes por medio de for
		//solo necestia una lista de cada una 
		// despues solo avanza con score 
		//luego los enmigos tiene la direccion
		
		if (scoreKeep >= 13000) {
			scoreKeep = 0;
			cont = 0;
			check = 0;
			value = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			
		
			}else if (hud.getLevel() == 1 ) {
				
				

//				positionX = 400;
//				positionY = 300;
//				FastEnemy e1 = new FastEnemy(positionX-1, positionY, 5, ID.FastEnemy, handler);
//				e1.setVelX(-1);
//				e1.setVelY(-1);
//				FastEnemy e2 = new FastEnemy(positionX-1, positionY-50, 5, ID.FastEnemy, handler);
//				e2.setVelX(-1);
//				e2.setVelY(-1);
//				FastEnemy e3 = new FastEnemy(positionX+1, positionY-150, 5, ID.FastEnemy, handler);
//				e3.setVelX(1);
//				e3.setVelY(1);
//				FastEnemy e4 = new FastEnemy(positionX+1, positionY-200, 5, ID.FastEnemy, handler);
//				e4.setVelX(1);
//				e4.setVelY(1);
//				
//				handler.addClaseEList(e1);
//				handler.addClaseEList(e2);
//				handler.addClaseEList(new BasicEnemyBoss(positionX, positionY-100, 10, ID.BasicEnemyBoss,handler));
//				handler.addClaseEList(e3);
//				handler.addClaseEList(e4);
//				cont++;
				//Lista 1
				
			
			if (scoreKeep == 50) {

				positionX = 100;

				for (int i = 1; i <= 5; i++) {

					value = r.nextInt(3);

					if (value == 2 && check == 0) {

						value = 0;

						while (value < 1) {
							value = r.nextInt(6);
						}

						positionX += 15;
						handler.addClaseDList(new BasicEnemyBoss(positionX, 40, value, ID.BasicEnemyBoss, handler));
						positionX += 50;
						check++;

					} else {

						value = 0;
						while (value < 1) {
							value = r.nextInt(6);
						}
						positionX += 15;
						handler.addClaseDList(new BasicEnemy(positionX, 40, value, ID.BasicEnemy, handler));
						positionX += 50;

					}

				}
				handler.claseD.bubleSort();
			}
			
			
				
//*******			
//			if (scoreKeep == 50 || scoreKeep == 650 || scoreKeep == 950) {
//				positionX = 50;
//				for (int i = 1; i <= 5; i++) {
//
//					positionX += 15;
//					handler.addbasicList(new BasicEnemy(positionX, 50, 1, ID.BasicEnemy, handler));
//					positionX += 50;
//					cont++;
//					
//					if (scoreKeep >= 950) {
//						hud.setCurrent("Basic");
//						hud.setFollowing("Basic");
//					}else {
//						hud.setCurrent("Basic");
//						hud.setFollowing("A");
//					}
//					
//
//				}
//			}
//
//			if (scoreKeep == 200 || scoreKeep == 750) {
//				positionX = 50;
//				check = 0;
//				hud.setCurrent("A");
//				hud.setFollowing("Basic");
//
//				for (int i = 1; i < 5; i++) {
//
//					value = r.nextInt(3);
//
//					if (value == 2 && check == 0) {
//
//						value = 0;
//						while (value < 1) {
//							value = r.nextInt(6);
//						}
//
//						positionX += 15;
//						handler.addClaseAList(new BasicEnemyBoss(positionX, 50, value, ID.BasicEnemyBoss, handler));
//						positionX += 50;
//						check++;
//
//					} else {
//
//						positionX += 15;
//						handler.addClaseAList(new BasicEnemy(positionX, 50, 1, ID.BasicEnemy, handler));
//						positionX += 50;
//
//					}
//
//				}
//				if (check == 0) {
//
//					value = 0;
//					while (value < 1) {
//						value = r.nextInt(6);
//					}
//					positionX += 15;
//					handler.addClaseAList(new BasicEnemyBoss(positionX, 50, value, ID.BasicEnemyBoss, handler));
//					positionX += 50;
//
//				} else {
//					positionX += 15;
//					handler.addClaseAList(new BasicEnemy(positionX, 50, 1, ID.BasicEnemy, handler));
//					positionX += 50;
//				}
//				cont++;
//
//			}
//
//			if (scoreKeep == 400 || scoreKeep == 850 || scoreKeep == 1050) {
//				positionX = 50;
//				hud.setCurrent("Basic");
//				 hud.setFollowing("Basic");
//				for (int i = 1; i <= 8; i++) {
//
//					positionX += 15;
//					handler.addbasicList(new BasicEnemy(positionX, 50, 1, ID.BasicEnemy, handler));
//					positionX += 50;
//					cont++;
//					
//					if (scoreKeep >= 1050) {
//						hud.setCurrent("Basic");
//						hud.setFollowing("END");
//						
//					}else {
//						hud.setCurrent("Basic");
//						hud.setFollowing("Basic");
//					}
//					
//
//				}
//			}
//			
//			
			
			

		} else if (hud.getLevel() == 3 && cont == 0) {

			for (int i = 1; i <= 8; i++) {

				positionX += 15;
				handler.addbasicList(new BasicEnemy(positionX, 50, 1, ID.BasicEnemy, handler));
				positionX += 50;
				cont++;

			}
//				positionX = 100;a
//				
//				for (int i = 1; i < 5; i++) {
//
//					value = r.nextInt(3);
//					
//					if (value == 2 && check == 0) {
//						
//						value = 0;
//						while (value  < 1) {
//							value = r.nextInt(6);
//						}
//						
//						positionX += 15;
//						handler.addClaseAList(new BasicEnemyBoss(positionX, 100, value, ID.BasicEnemyBoss, handler));
//						positionX += 50;
//						check++;
//						
//					
//					}else {
//						
//						positionX += 15;
//						handler.addClaseAList(new BasicEnemy(positionX, 100, 1, ID.BasicEnemy, handler));
//						positionX += 50;
//							
//					}
//					
//				}
//				if (check == 0) {
//					
//					value = 0;
//					while (value  < 1) {
//						value = r.nextInt(6);
//					}
//					positionX += 15;
//					handler.addClaseAList(new BasicEnemyBoss(positionX, 100, value, ID.BasicEnemyBoss, handler));
//					positionX += 50;
//					
//				}else {
//					positionX += 15;
//					handler.addClaseAList(new BasicEnemy(positionX, 100, 1, ID.BasicEnemy, handler));
//					positionX += 50;
//				}
//				cont++;
					
				
			
			}else if (hud.getLevel() == 4 && cont == 0) {
				
				positionX = 50;
				check = 0;
				
				for (int i = 1; i < 5; i++) {

					value = r.nextInt(3);
					
					if (value == 2 && check == 0) {
						
						value = 0;
						while (value  < 1) {
							value = r.nextInt(6);
						}
						
						positionX += 15;
						handler.addDoubleList(new BasicEnemyBoss(positionX, 20, value, ID.BasicEnemyBoss, handler));
						positionX += 50;
						check++;
						
					
					}else {
						
						positionX += 15;
						handler.addDoubleList(new BasicEnemy(positionX, 20, 1, ID.BasicEnemy, handler));
						positionX += 50;
							
					}
					//Comprobar que se agrego!!!
					
				}
				if (check == 0) {
					
					value = 0;
					while (value < 1) {
						value = r.nextInt(6);
					}
					
					positionX += 15;
					handler.addDoubleList(new BasicEnemyBoss(positionX, 20, value, ID.BasicEnemyBoss, handler));
					positionX += 50;
				}
				else {
					
					positionX += 15;
					handler.addDoubleList(new BasicEnemy(positionX, 20, 1, ID.BasicEnemy, handler));
					positionX += 50;
				}
				cont++;
			
				
			

			}else if (hud.getLevel() == 5 && cont == 0) {
				for (int i = 1; i <= 8; i++) {
					
					 positionX += 15;
					 handler.addbasicList(new BasicEnemy(positionX, 20, 1, ID.BasicEnemy,
					 handler));
					 positionX += 50;
					 cont++;

					 }
//				positionX = 100;
//				
//				for (int i = 1; i < 5; i++) {
//
//					value = r.nextInt(3);
//					
//					if (value == 2 && check == 0) {
//						
//						value = 0;
//						while (value  < 1) {
//							value = r.nextInt(6);
//						}
//						
//						positionX += 15;
//						handler.addClaseCList(new BasicEnemyBoss(positionX, 40, value, ID.BasicEnemyBoss, handler));
//						positionX += 50;
//						check++;
//						
//					
//					}else {
//						
//						positionX += 15;
//						handler.addClaseCList(new BasicEnemy(positionX, 40, 10, ID.BasicEnemy, handler));
//						positionX += 50;
//							
//					}
//					
//				}
//				if (check == 0) {
//					
//					value = 0;
//					while (value  < 1) {
//						value = r.nextInt(6);
//					}
//					positionX += 15;
//					handler.addClaseCList(new BasicEnemyBoss(positionX, 40, value, ID.BasicEnemyBoss, handler));
//					positionX += 50;
//					
//				}else {
//					positionX += 15;
//					handler.addClaseCList(new BasicEnemy(positionX, 40, 10, ID.BasicEnemy, handler));
//					positionX += 50;
//				}
//				cont++;
//				
//			}else if (hud.getLevel() == 6) {
//				
//				positionX = 100;
//				
//				for (int i = 1; i < 5; i++) {
//				
//				value = r.nextInt(3);
//
//				if (value == 2 && check == 0) {
//
//					value = 0;
//					while (value < 1) {
//						value = r.nextInt(6);
//					}
//
//					positionX += 15;
//					handler.addClaseDList(new BasicEnemyBoss(positionX, 40, value, ID.BasicEnemyBoss, handler));
//					positionX += 50;
//					check++;
//
//				} else {
//
//					value = 0;
//					while (value < 1) {
//						value = r.nextInt(6);
//
//						positionX += 15;
//						handler.addClaseDList(new BasicEnemy(positionX, 40, value, ID.BasicEnemy, handler));
//						positionX += 50;
//
//					}
//
//				}
//
//			}
//			if (check == 0) {
//
//				value = 0;
//				while (value < 1) {
//					value = r.nextInt(6);
//				}
//				positionX += 15;
//				handler.addClaseDList(new BasicEnemyBoss(positionX, 40, value, ID.BasicEnemyBoss, handler));
//				positionX += 50;
//
//			} else {
//
//				value = 0;
//				while (value < 1) {
//					value = r.nextInt(6);
//
//					positionX += 15;
//					handler.addClaseCList(new BasicEnemy(positionX, 40, value, ID.BasicEnemy, handler));
//					positionX += 50;
//				}
//			
//				cont++;
//			}
//			
//			}else if (hud.getLevel() == 7) {
//				
//			}else if (hud.getLevel() == 10) {
				//handler.clearEnemys();
				//handler.addObject(new BossEnemy((Game.WIDTH / 2) - 100, -96, ID.BossEnemy, handler));
	}
		
	}
		


	
}
