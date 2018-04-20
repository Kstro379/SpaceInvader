package Game;

import java.awt.Graphics;

import Structure.CircularDinamicList;
import Structure.CircularDoubleList;
import Structure.CircularSimpleList;
import Structure.DoubleList;
import Structure.SimpleList;

/*
 * Ciclo principal que se encarga de las funciones de actualización del juego 
 */
public class Handler {

	public SimpleList<GameObject> player = new SimpleList<GameObject>();
	SimpleList<GameObject> basic = new SimpleList<GameObject>();
	SimpleList<GameObject> claseA = new SimpleList<GameObject>();
	CircularSimpleList<GameObject> claseC = new CircularSimpleList<GameObject>();
	CircularDinamicList<GameObject> claseD = new CircularDinamicList<GameObject>(); 
	DoubleList<GameObject> claseB = new DoubleList<GameObject>();
	CircularDoubleList<GameObject> claseE = new CircularDoubleList<GameObject>();

	private int cont;

	Game game;
	/*
	 * Actualiza cada una de las listas creadas para saber si se eliminaron enemigos o se movieron
	 */
	public void tick() {
		
		
		
		if (basic != null) {
			for (int i = 0; i < basic.getLenght(); i++) {

				GameObject tempObject = basic.getData(i);
				if (tempObject != null) {
					tempObject.tick();
					

				}
			}
		}
		if (claseA.getLenght() > 0) {
			for (int i = 0; i < claseA.getLenght(); i++) {

				GameObject tempObject = claseA.getData(i);
				if (tempObject != null) {
					tempObject.tick();

				}
			}
		}

		if (claseB.getLenght() > 0) {
			for (int i = 0; i < claseB.getLenght(); i++) {

				GameObject tempObject;
				tempObject = (GameObject) claseB.getData(i);
				if (tempObject != null) {
					tempObject.tick();
				}

			}
			claseB.deleteNode();
			

		}
		if (claseC.getLenght() > 0) {
			
			for (int i = 0; i < claseC.getLenght(); i++) {

				GameObject tempObject;
				tempObject = (GameObject) claseC.getData(i);
				if (tempObject != null) {
					tempObject.tick();
					
				}
			}
			/*
			 *Mueve al enemigo de posición
			 */
			claseC.compare();
		}

		if (claseD.getLenght() > 0) {

			for (int i = 0; i < claseD.getLenght(); i++) {

				GameObject tempObject;
				tempObject = (GameObject) claseD.getData(i);
				if (tempObject != null) {
					tempObject.tick();

				}
			}
			/*
			 * Mueve a los enemigos de posición
			 */
			claseD.compare();
			
			
		}
		
		if (claseE.getLenght() > 0) {

			for (int i = 0; i < claseE.getLenght(); i++) {

				GameObject tempObject;
				tempObject = (GameObject) claseE.getData(i);
				if (tempObject != null) {
					tempObject.tick();

				}
			}
			/*
			 * Mueve a los enemigos de posición
			 */
			claseE.compare();
			
			
		}
		
		if (player.getLenght() > 0) {

			for (int i = 0; i < player.getLenght(); i++) {

				GameObject tempObject;

				tempObject = (GameObject) player.getData(i);
				if (tempObject != null) {
					tempObject.tick();

				}

			}
			/*
			 * Elimina las balas del jugador
			 */
			player.deleteBullet();

		}
	}
	/*
	 * Se encarga de dibujar todos los obejetos en pantalla según cada una de las listas creadas
	 */
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
		if (claseC.getLenght() > 0) {

			for (int i = 0; i < claseC.getLenght(); ++i) {

				GameObject tempObject;

				tempObject = (GameObject) claseC.getData(i);
				if (tempObject != null) {
					tempObject.render(g);

				}
			}
			
		}
		
		if (claseD.getLenght() > 0) {

			for (int i = 0; i < claseD.getLenght(); ++i) {

				GameObject tempObject;

				tempObject = (GameObject) claseD.getData(i);
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
			basic.compare();
		}
		if (claseA.getLenght() > 0) {
			for (int i = 0; i < claseA.getLenght(); ++i) {

				GameObject tempObject;

				tempObject = (GameObject) claseA.getData(i);
				if (tempObject != null) {
					tempObject.render(g);

				}
			}
			claseA.compare();
		}
		
		if (claseE.getLenght() > 0) {
			for (int i = 0; i < claseE.getLenght(); ++i) {

				GameObject tempObject;

				tempObject = (GameObject) claseE.getData(i);
				if (tempObject != null) {
					tempObject.render(g);

				}
			}
			
			claseE.circle();
		}
		
		if (claseB.getLenght() > 0) {
			for (int i = 0; i < claseB.getLenght(); i++) {

				GameObject tempObject;
				
				tempObject = (GameObject) claseB.getData(i);
				if (tempObject != null) {
					tempObject.render(g);
					cont++;

				}
				

			}
			
		}
		/*
		 * Cambia enemigos de posición y elinina nodos sobrantes
		 */
		
		
		
		
	}
	/*
	 * Elimina la onformación de todas las listas
	 */
	public void clearEnemys() {

		basic.delete();
		player.delete();
		claseA.delete();
		claseC.delete();
		claseD.delete();
		claseE.delete();
		claseB.delete();

		if (Game.gameState != Game.STATE.End) {
			// Lo quite por que en el metodo de limpiar los agrega de nuevo en el menu
			// select
			// addSimpleList(new Player(Game.WIDTH/2-32, Game.HEIGHT/-100, ID.Player,this));
		}
	}
	/*
	 * Retorna al jugador 
	 */
	public int getPlayerX() {
		return this.player.getX();
	}
	/*
	 * Añade a la lista
	 */
	public void addplayerList(GameObject object) {
		this.player.setAtFinal(object);
	}
	/*
	 * Añade a la lista
	 */
	public void addbasicList(GameObject object) {
		this.basic.setAtFinal(object);
	}
	/*
	 * Añade a la lista
	 */
	public void addDoubleList(GameObject object) {
		this.claseB.setAtFinal(object);
	}
	/*
	 * Añade a la lista
	 */
	public void addClaseAList(GameObject object) {
		this.claseA.setAtFinal(object);
	}
	/*
	 * Añade a la lista
	 */
	public void addClaseCList(GameObject object) {
		this.claseC.addAtFinal(object);
	}
	/*
	 * Añade a la lista
	 */
	public void addClaseDList(GameObject object) {
		this.claseD.addAtFinal(object);
	}
	/*
	 * Añade a la lista
	 */
	public void addClaseEList(GameObject object) {
		this.claseE.addAtFinal(object);
	}
	public void addBullet() {
		this.player.setAtFinal(new Bullet(player.getX() + 25, Game.HEIGHT - 100, 1, ID.Bullet, this));
	}
}
