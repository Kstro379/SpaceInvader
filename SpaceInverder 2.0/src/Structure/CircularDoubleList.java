package Structure;

import Game.GameObject;
import Game.ID;

public class CircularDoubleList<T> {
	
	private DoubleNode<T> start;
	private DoubleNode<T> last ;
	private int lenght;
	
	public CircularDoubleList() {
		
		start = null;
		last = null;
		lenght = 0;
		
	}
	
	public void addAtFinal(T data) {
		DoubleNode<T> node = new DoubleNode<>();
		
		node.setData(data);
		
		if (start == null) {
			start = node;
			start.setNext(start);
			last = node;
			node.setBack(last);
			lenght++;
			
		}else {
			last.setNext(node);
			node.setNext(start);
			node.setBack(last);
			last = node;
			start.setBack(last);
			lenght++;
		}
		
	}
	
	public void compare() {
		DoubleNode<T> aux = new DoubleNode<>();
		DoubleNode<T> aux2 = new DoubleNode<>();

		aux = start;
		aux2 = last;
		int cont = 1;

		while (cont <= lenght) {

			if (((GameObject) aux.getData()).getLife() < 1){

				if (((GameObject) aux.getData()).getId() == ID.BasicEnemyBoss) {
					delete();

				} else if (aux == start) {
					start = start.getNext();
					last.setNext(start);
					start.setBack(last);
					lenght--;
					cont++;

				} else if (aux == last) {
					last = aux2;
					start.setBack(last);
					last.setNext(start);
					lenght--;
					cont++;

				} else {
					aux2.setNext(aux.getNext());
					aux.getNext().setBack(aux2);
					lenght--;
					cont++;

				}

			}else {
				aux2 = aux;
				aux = aux.getNext();
				cont++;
			}
			
		}

	}
	
	public void delete() {

		start = null;
		last = null;
		lenght = 0;

	}

	public int getLenght() {
		return lenght;
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
	public void circle() {
		
		DoubleNode<T> aux = start;
		GameObject enemy;

		while (((GameObject) aux.getData()).getId() != ID.BasicEnemyBoss) {
			aux = aux.getNext();
		}

		enemy = ((GameObject) aux.getData());
		aux = start;
		int cont = 1;

		while (cont <= lenght) {
			
  			if (((GameObject) aux.getData()).getId() != ID.BasicEnemyBoss) {

				if (((GameObject) aux.getData()).getX() == enemy.getX() && ((GameObject) aux.getData()).getVelX() <= 0) {
					((GameObject) aux.getData()).changeY(2);
					aux = aux.getNext();
					cont++;

				} else if (((GameObject) aux.getData()).getX() == enemy.getX() && ((GameObject) aux.getData()).getVelX() >= 0) {
					((GameObject) aux.getData()).changeY(1);
					aux = aux.getNext();
					cont++;

				} else if (((GameObject) aux.getData()).getY() == enemy.getY() && ((GameObject) aux.getData()).getVelY() >= 0) {
					((GameObject) aux.getData()).chanceX(2);
					aux = aux.getNext();
					cont++; 
				
				} else if (((GameObject) aux.getData()).getY() == enemy.getY() && ((GameObject) aux.getData()).getVelY() <= 0) {
					((GameObject) aux.getData()).chanceX(1);
					aux = aux.getNext();
					cont++; 
					
				}else {
					aux = aux.getNext();
					cont++;

				}

			}else {
				aux = aux.getNext();
				cont++;
			}

		}

	}
}
