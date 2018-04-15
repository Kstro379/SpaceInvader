package Structure;




import Game.GameObject;

import Game.ID;

public class CircularSimpleList<T> {
	
	private SimpleNode<T> start;
	private SimpleNode<T> last;
	private int lenght;
	private int posY;
	private int cont;
	private boolean var = false;
	
	
	public CircularSimpleList() {
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
		
		cont = 3;
		
		if (((GameObject) start.getData()).getLife() < 1) {
			
			if (((GameObject) start.getData()).getId() == ID.BasicEnemyBoss) {
				var = true;
			}
			start = start.getNext();
			last.setNext(start);
			lenght--;
			
			
			if (var == true) {
				SimpleNode<T> aux = start;
				while (cont == 0) {
					aux = aux.getNext();
				}
				((GameObject) aux.getData()).changeEnemy();
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
					while (cont == 0) {
						aux2 = aux2.getNext();
					}
					((GameObject) aux2.getData()).changeEnemy();
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
					while (cont == 0) {
						aux3 = aux3.getNext();
					}
					((GameObject) aux3.getData()).changeEnemy();
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

	

}
