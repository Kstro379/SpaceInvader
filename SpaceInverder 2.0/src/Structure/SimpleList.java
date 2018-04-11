package Structure;

import Game.GameObject;
import Game.ID;

public class SimpleList<T> {

	private SimpleNode<T> start;
	private int lenght;
	private int posY;

	public SimpleList() {
		start = null;
		lenght = 0;

	}

	public boolean isEmty() {
		return start == null;
	}

	public int getLenght() {
		return lenght;

	}

	public void setLenght() {
		this.lenght = 0;

	}

	public int getX() {
		GameObject aux;
		aux = (GameObject) start.getData();
		return aux.getX();
	}

	public void setAtFinal(T data) {
		SimpleNode<T> node = new SimpleNode<T>();

		node.setData(data);

		if (lenght == 0) {
			start = node;
			lenght++;

		} else {
			SimpleNode<T> aux = start;

			while (aux.getNext() != null) {
				aux = aux.getNext();
			}

			aux.setNext(node);
			lenght++;

		}
	}

	public T getData(int position) {

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

	public void deleteBullet() {

		if (lenght > 1) {
			SimpleNode<T> aux = start.getNext();
			GameObject temp = (GameObject) aux.getData();

			if (temp.getY() < 10 && temp.getId() == ID.Bullet) {
				start.setNext(aux.getNext());
				lenght--;

			}

		}

	}

	public void deleteBulletCol() {

		if (lenght > 1) {
			SimpleNode<T> aux = start.getNext();
			start.setNext(aux.getNext());
			lenght--;

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

			while (aux.getNext() != null) {
				aux2 = aux;
				temp = (GameObject) aux.getNext().getData();
				if (temp.getLife() < 1) {
					posY = temp.getY();
					aux2 = aux.getNext().getNext();
					aux.setNext(aux2);
					check++;
					lenght--;

				} else if (check > 0 && temp.getY() >= posY) {

					aux = aux.getNext();
					temp.res();

				} else {
					aux = aux.getNext();
				}
			}

		}
	}

	public void delete() {

		start = null;
		lenght = 0;

	}

}
