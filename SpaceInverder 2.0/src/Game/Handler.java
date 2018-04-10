package Game;

import java.awt.Graphics;

import Structure.DoubleList;
import Structure.SimpleList;

public class Handler {
	
	
	//Recuerde crear las listas y luego solo agrega metodos pa
	//Recorrrelars con varios for  
	SimpleList<GameObject> player = new SimpleList<GameObject>();
	SimpleList<GameObject> basic = new SimpleList<GameObject>();
	DoubleList<GameObject> enemyChange = new DoubleList<GameObject>();
	
	Game game;
	
	public void tick() {

		if (player.getLenght() > 0) {

			for (int i = 0; i < player.getLenght(); i++) {
				

				GameObject tempObject;

				tempObject = (GameObject) player.getData(i);
				if (tempObject != null) {
					tempObject.tick();
				}

			}

		}
		
		if (basic.getLenght() > 0) {
			for (int i = 0; i < basic.getLenght(); i++) {
				System.out.println(basic.getLenght());

				GameObject tempObject  =  basic.getData(i);
				tempObject.tick();

				

			}

		}
		
		if (enemyChange.getLenght() > 0) {

			for (int i = 0; i < enemyChange.getLenght(); i++) {

				GameObject tempObject;

				tempObject = (GameObject) enemyChange.getData(i);
				enemyChange.Change(i);
				if (tempObject != null) {
					tempObject.tick();

				}

			}

		}

		
	}

	public void render(Graphics g) {
		
		if (player.getLenght() > 0) {
			
			for (int i = 0; i < player.getLenght(); ++i) {
				
				GameObject tempObject;

					tempObject = (GameObject) player.getData(i);
					if (tempObject != null) {
						tempObject.render(g);
					
					}
			
			}
		}
		
		if (basic.getLenght() > 0) {
			for (int i = 0; i < basic.getLenght(); ++i) {
				
				GameObject tempObject;
				
					tempObject = (GameObject) basic.getData(i);
					if (tempObject != null) {
						tempObject.render(g);
					
					}
			
			}
			
		}
		if (enemyChange.getLenght() > 0) {
			for (int i = 0; i < enemyChange.getLenght(); i++) {

				
				GameObject tempObject;
				
					tempObject = (GameObject) enemyChange.getData(i);
					enemyChange.Change(i);
					if (tempObject != null) {
						tempObject.render(g);

					
				} 
				
			}
		}

	
	}
	
	public void clearEnemys() {
		
	
			basic.delete();
			player.delete();
			enemyChange.delete();
			
			if (Game.gameState != Game.STATE.End) {
				//Lo quite por que en el metodo de limpiar los agrega de nuevo en el menu select
				//addSimpleList(new Player(Game.WIDTH/2-32, Game.HEIGHT/-100, ID.Player,this));
			}
		}
		
		
		
		
	
		
		
	
	

	
	public void addSimpleList(GameObject object) {
		this.player.setAtFinal(object);
	}
	
	public void addSimpleListBasic(GameObject object) {
		this.basic.setAtFinal(object);
	}
	
	public void addDoubleList(GameObject object) {
		this.enemyChange.insertAtFinal(object);
	}
	

	

}
