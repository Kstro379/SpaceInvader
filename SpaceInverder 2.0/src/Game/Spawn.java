package Game;



public class Spawn {
	
	private Handler handler;
	private HUD hud;
	
	
	private int positionY;
	private int scoreKeep = 0;
	private int positionX;
	private int cont = 0;
	
	
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
			hud.setLevel(hud.getLevel() + 1);
			
			
		
			}else if (hud.getLevel() == 2 ) {
				
				if (cont <= 0) {
				
					for (int i = 0; i < 5; i++) {
						handler.addSimpleListBasic(new BasicEnemy(positionX, positionY, ID.BasicEnemy, handler));
						positionX += 50;
					}
					
				}
				cont++;
				
				
			}else if (hud.getLevel() == 3) {
				
			
			}else if (hud.getLevel() == 4) {
			

			}else if (hud.getLevel() == 5) {
				
				
			}else if (hud.getLevel() == 6) {
				
				
			}else if (hud.getLevel() == 7) {
				
			}else if (hud.getLevel() == 10) {
				handler.clearEnemys();
				handler.addObject(new BossEnemy((Game.WIDTH / 2) - 100, -96, ID.BossEnemy, handler));
	}
		
	}
		


	
}
