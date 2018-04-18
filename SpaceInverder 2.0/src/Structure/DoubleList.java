package Structure;

import java.util.Random;

import Game.GameObject;
import Game.ID;


public class DoubleList<T> {
	
	private DoubleNode<T> start;
	private DoubleNode<T> last;
	private int lenght;
	private int value;
	
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
	
	public void change() {
		DoubleNode<T> aux =  new DoubleNode<T>();
		aux = start;
		while(aux != null) {
			if (((GameObject) aux.getData()).getId() == ID.BasicEnemyBoss) {
				aux = aux.getNext();
			}
			aux = aux.getNext();
		}
		
	}
	
	public void deleteNode() {
		DoubleNode<T> aux =  new DoubleNode<T>();
		DoubleNode<T> aux2 =  new DoubleNode<T>();
		
		aux = start;
		aux2 = null;
		
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
							System.out.println("eeeeeeeeeeeeee");
						}
						
						
					}else {
						
						DoubleNode<T> aux3 =  new DoubleNode<T>();
						aux3 = aux2.getNext();
						while (aux3 != null) {
							((GameObject) aux3.getData()).res();;
							aux3 = aux3.getNext();
							System.out.println("oooooooooooooo");
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
