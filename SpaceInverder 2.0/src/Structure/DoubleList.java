package Structure;

import java.util.Random;

import Game.GameObject;
import Game.ID;


public class DoubleList<T> {
	
	private DoubleNode<T> start;
	private DoubleNode<T> last;
	private int lenght;
	private int value = 1;
	private int cont = 0;
	private int check = 0;
	
	Random r = new Random();
	
	
	
	public DoubleList() {
		start = null;
		last = null;
		lenght = 0;
		
	}
	
	
	public int getLenght() {
		return lenght;
	}
	
	public void setLenght() {
		this.lenght = 0;
	}
	
	public void setAtFinal(T data) {
		DoubleNode<T> node = new DoubleNode<T>();
		node.setData(data);
		
		if (start == null) {
			start = node;
			start.setNext(null);
			start.setBack(null);
			last = start;
			lenght++;
			
		}else {
			
			last.setNext(node);
			node.setBack(last);
			node.setNext(null);
			last = node;
			lenght++;
		}
		
	}
	
	
		
	
	public void deleteNode() {
		DoubleNode<T> aux =  new DoubleNode<T>();
		DoubleNode<T> aux2 =  new DoubleNode<T>();
		DoubleNode<T> aux4 = new DoubleNode<T>();
		
		aux = start;
		aux2 = null;
		
		cont++;
		
		if (cont >= 30) {
			cont = 0;
			value = 0;
		}
		
		aux4 = start;
		while (value != 1 && aux4 != null) {

			if (((GameObject) aux4.getData()).getId() == ID.BasicEnemyBoss) {
				
				((GameObject) aux4.getData()).changeEnemy(1);
				
				if (aux4.getNext() != null && check == 0) {
					
					aux4 = aux4.getNext();
					((GameObject) aux4.getData()).changeEnemy(1);
					value = 1;
					
					
					
				}else if (aux4.getBack() != null) {
					
					aux4 = aux4.getBack();
					((GameObject) aux4.getData()).changeEnemy(1);
					value = 1;
					
					if (check == 0) {
						check = 1;
					}
					if (aux4 == start) {
						check = 0;
					}
					
				}
				
				
			
			}else {
				aux4 = aux4.getNext();
			}
			
			
		}
		

		while (aux != null) {
			
			if (((GameObject) aux.getData()).getLife() < 1) {
				
				if (((GameObject) aux.getData()).getId() == ID.BasicEnemyBoss && ((GameObject) aux.getData()).getLife() < 1) {
					delete();
				
				}else if (aux == start && lenght == 1) {
					delete(); 
					
				}else if(aux == start) {
					start = start.getNext();
					start.setBack(null);
					lenght--;
					
					
				}else if (aux.getNext() == null){
					aux2.setNext(null);
					aux = aux2;
					lenght--;
					
				}else {
					aux2.setNext(aux.getNext());
					aux2.getNext().setBack(aux2);
					lenght--;
					
					if (((GameObject) aux2.getData()).getVelX() > 1) {
						DoubleNode<T> aux3 =  new DoubleNode<T>();
						aux3 = aux2.getNext();
						while (aux3 != null) {
							((GameObject) aux3.getData()).resPos();
							aux3 = aux3.getNext();
							
						}
						
						
					}else {
						
						DoubleNode<T> aux3 =  new DoubleNode<T>();
						aux3 = aux2.getNext();
						while (aux3 != null) {
							((GameObject) aux3.getData()).res();;
							aux3 = aux3.getNext();
							
						}
						
					}
				}
			}
			aux2 = aux;
			aux = aux.getNext();
			
		}
		
	
	}
			
		
	
	
	
	public T getData(int position) {

		if (position == 0) {
			return start.getData();

		} else {
			DoubleNode<T> aux = start;

			for (int i = 0; i < position; i++) {
				aux = aux.getNext();

			}
			return aux.getData();
		}
	}
	
	public void delete() {
		start = null;
		lenght = 0;
	}

	
	

}
