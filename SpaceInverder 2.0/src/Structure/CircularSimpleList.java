package Structure;

import Game.GameObject;

public class CircularSimpleList<T> {
	
	private SimpleNode<T> start;
	private SimpleNode<T> last;
	private int lenght;
	
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

		GameObject temp = (GameObject) start.getData();
		if (temp.getLife() < 1) {
			start = start.getNext();
			lenght--;

		} else {

			SimpleNode<T> aux = start;
			SimpleNode<T> aux2 = null;
			int check = 0;
			int cont = 0;
			
			while (cont < lenght) {
				aux2 = aux;
				temp = (GameObject) aux.getNext().getData();
				if (temp.getLife() < 1) {
					aux2 = aux.getNext().getNext();
					aux.setNext(aux2);
					check++;
					lenght--;
					cont++;

				} else if (check > 0) {

					aux = aux.getNext();
					temp.res();
					cont++;

				} else {
					aux = aux.getNext();
					cont++;
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
