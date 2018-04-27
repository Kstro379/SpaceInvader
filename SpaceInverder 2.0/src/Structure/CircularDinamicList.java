package Structure;

import java.util.Random;

import Game.GameObject;
import Game.ID;

public class CircularDinamicList<T> {
	
	private SimpleNode<T> start;
	private SimpleNode<T> last;
	private int lenght;
	private int posY;
	private int cont = 0;
	private boolean var = false;
	private Random r = new Random();
	private boolean inOrden = false;
	private int lif, lif2, check = 0;
	
	
	public CircularDinamicList() {
		start = null;
		last = null;
		lenght = 0;
	}
	
	public boolean isEmpty() {
		return start == null;
		
	}
	
	public int getLenght() {
		return lenght;
		
	}
	
	public void addAtFinal(T data) {
		SimpleNode<T> node = new SimpleNode<T>();
		node.setData(data);
		
		if (start == null) {
			start = node;
			last = start;
			start.setNext(last);
			lenght++;
			
		}else {
			last.setNext(node);
			node.setNext(start);
			last = node;
			lenght++;
		}
		
		
	}

	public T getData(int position)  {


			if (position == 0) {
				return start.getData();

			} else {
				SimpleNode<T> aux = start;

				for (int i = 0; i < position; i++) {
					aux = aux.getNext();

				}
				return aux.getData();
			}
	}
			
	public void compare() {
		
		while(cont < 1) {
			cont = r.nextInt(3);
		}
		
		
		if (((GameObject) start.getData()).getLife() < 1) {
			
			if (((GameObject) start.getData()).getId() == ID.BasicEnemyBoss) {
				var = true;
			}
			start = start.getNext();
			last.setNext(start);
			lenght--;
			
			
			if (var == true) {
				SimpleNode<T> aux = start;
				while (cont != 0) {
					aux = aux.getNext();
					cont--;
				}
				((GameObject) aux.getData()).changeEnemy(2);
				var = false;
				
			}
			
		}else {
			
			SimpleNode<T> aux = start;
			int check = 0;
			
			while(((GameObject) aux.getNext().getData()).getLife() >= 1 && aux != last ) {
				aux = aux.getNext();
			}
			
			if (aux.getNext() == last && ((GameObject) aux.getNext().getData()).getLife() < 1) {
				
				if (((GameObject) aux.getNext().getData()).getId() == ID.BasicEnemyBoss) {
					var = true;
				}
				
				aux.setNext(start);
				last = aux;
				posY = ((GameObject) aux.getNext().getData()).getY();
				check = 1;
				lenght--;
				
				if (var == true) {
					SimpleNode<T> aux2 = start;
					while (cont != 0) {
						aux2 = aux2.getNext();
						cont--;
					}
					((GameObject) aux2.getData()).changeEnemy(2);
					var = false;
					
				}
				
			}else if (((GameObject) aux.getNext().getData()).getLife() < 1 ){
				
				if (((GameObject) aux.getNext().getData()).getId() == ID.BasicEnemyBoss) {
					var = true;
				}
				
				SimpleNode<T> aux2 = aux.getNext() ;
				posY = ((GameObject) aux.getNext().getData()).getY();
				aux.setNext(aux2.getNext());
				check = 1;
				lenght--;
				
				if (var == true) {
					SimpleNode<T> aux3 = start;
					while (cont != 0) {
						aux3 = aux3.getNext();
						cont--;
					}
					((GameObject) aux3.getData()).changeEnemy(2);
					var = false;
					
				}
			
			}
			
			while (aux != last) {
				
			if (check > 0 && ((GameObject) aux.getData()).getY() >= posY) {
				aux = aux.getNext();
				((GameObject) aux.getData()).res();
			}
			else {
				aux = aux.getNext();
			}
			
			
			}
		}	
		
	}
	
	public void delete() {
		start = null;
		last = null;
		lenght = 0;
		
	}
	
	public void bubleSort() {
		
		SimpleNode<T> aux = new SimpleNode<T>();
		SimpleNode<T> aux2 = new SimpleNode<T>();
		SimpleNode<T> aux3 = new SimpleNode<T>();
		
		
		while (inOrden == false) {
			
			aux  = start;
			aux2 = start.getNext();
			aux3 = aux2;
			check = 0;
			
			while (aux != last) {
				
				if (((GameObject) aux2.getData()).getLife() > ((GameObject) aux.getData()).getLife()) {
					
					
					System.out.println(lif = ((GameObject) aux2.getData()).getLife());
					System.out.println(lif = ((GameObject) aux.getData()).getLife());
					
					
					((GameObject) aux.getData()).saveLife(((GameObject) aux3.getData()).getLife());
					((GameObject) aux2.getData()).saveLife(((GameObject) aux.getData()).getLife());
					
					
					aux = aux.getNext();
					aux2 = aux2.getNext();
					aux3 = aux2;
					check++;
					
				}else {
					System.out.println("dddddddddd");
					aux = aux.getNext();
					aux2 = aux2.getNext();
					aux3 = aux2;
				}
			}
			
			if (check == 0) {
				inOrden = true;
			}
			
			
		}
		

		}
	

}