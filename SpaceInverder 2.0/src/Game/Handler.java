package Game;

import java.awt.Graphics;
import java.util.LinkedList;

import Structure.SimpleList;

public class Handler {
	
	
	//Recuerde crear las listas y luego solo agrega metodos pa
	//Recorrrelars con varios for  
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	SimpleList<GameObject> object1 = new SimpleList<GameObject>();
	Game game;
	
	public void tick() {
		for (int i = 0 ; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
		for (int i = 0; i < object1.getLenght(); i++) {

			try {
				GameObject tempObject = (GameObject) object1.getData(i);
				System.out.println(tempObject);
				if (tempObject != null) {
					tempObject.tick();

				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
		for (int i = 0; i < object1.getLenght(); ++i) {
			try {
				GameObject tempObject = (GameObject) object1.getData(i);
				System.out.println(tempObject);
				if (tempObject != null) {
					tempObject.render(g);
				
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void clearEnemys() {
		for (int i = 0; i < object.size(); i++) {
	
				object.clear();
				object1.delete();
				
				
				
				
				if (Game.gameState != Game.STATE.End) {
					addSimpleList(new Player(Game.WIDTH/2-32, Game.HEIGHT/-100, ID.Player,this));
				}
				
			}
		
		
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void addSimpleList(GameObject object) {
		this.object1.setAtFinal(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	

}
