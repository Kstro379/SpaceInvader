package Structure;

import java.util.Random;

import Game.GameObject;
import Game.ID;
import net.java.games.input.Component.Identifier.Axis;

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
		
	}public void deleteData(T data) {
		if (start != null) {
			DoubleNode<T> aux = start;
			DoubleNode<T> ant = null;
			
			while(aux != null) {
				if (aux.getData() == data) {
					if (ant == null) {
						start = start.getNext();
						aux.setNext(null);
						aux = start;
						lenght--;
						
					}else {
						ant.setNext(aux.getNext());
						aux.setNext(null);
						aux = ant.getNext();
						lenght--;
					}
				}else {
					ant = aux;
					aux = aux.getNext();
					lenght--;
				}
			}
		}
	}
	public T getData (int position) {
		
			
			if (position == 0) {
				return start.getData();
				
			}else{
				
				DoubleNode<T> aux = start;
				for (int i = 0; i < position; i++) {
					aux = aux.getNext();
					
				}
				
				return aux.getData();
			}
			
	}
	
			
		
			
			
	

	
	public void Change() {

		DoubleNode<T> aux = start;
		
		
		
		
		aux = start;
		GameObject back = null;
		GameObject temp = null;
		while(aux != null){
			
			GameObject var =  (GameObject) aux.getData();
			
			if (var.getId() == ID.BasicEnemyBoss) {
				
				if (aux == start && aux.getNext() != null) {
					
					
					
					 back =  (GameObject) aux.getNext().getData();
					 back.setX(back.getX() - 50);
					 temp =  (GameObject) aux.getData();
					 temp.setX(temp.getX() + 65);
					 aux.getNext().setData((T) temp);
					 aux.setData((T) back);
					 
					 
					
					
				}else if (aux.getNext() == null) {
					
					
					 
					 back =  (GameObject) aux.getBack().getData();
					 back.setX(back.getX() + 65);
					 temp =  (GameObject) aux.getData();
					 temp.setX(temp.getX() -65);
					 aux.getBack().setData((T) temp);
					 aux.setData((T) back);
					 
					 
					
					 
					
				 }else {
					 
					 value = r.nextInt(2);
					 if (value == 1 && aux.getBack().getBack() != null) {
						 
						 back =  (GameObject) aux.getBack().getData();
						 if(back.getX() < 600 && back.getX() > 100) {
							 
							 back.setX(back.getX() + 65);
							 temp =  (GameObject) aux.getData();
							 temp.setX(temp.getX() -65);
							 aux.getBack().setData((T) temp);
							 aux.setData((T) back);
						 }
						
						 
					 }else if (value != 1 && aux.getNext().getNext() != null){
						 
						 back =  (GameObject) aux.getNext().getData();
						 if (back.getX() > 100 && back.getX() < 600) {
							 back.setX(back.getX() - 65);
							 temp =  (GameObject) aux.getData();
							 temp.setX(temp.getX() + 65);
							 aux.getNext().setData((T) temp);
							 aux.setData((T) back);
						 }
						 
						 
					 }
					 
				}

			}
			aux = aux.getNext();
		}

	}

	public void deleteNode(T data) {
		DoubleNode<T> aux = start;
		DoubleNode<T> back = start;

		aux = start;
		back = null;
		while(aux != null) {
			if (start.getData() == data) {
				if (aux == start) {
					start = start.getNext();
					start.setBack(null) ;
					
				}else {
					back.setNext(aux.getNext());
					aux.getNext().setBack(aux.getBack());
				}
			}
			back = aux;
			aux = aux.getNext();
		}
		
	}
	
	public void delete() {
		start = null;
		lenght = 0;
	}

	
	

}
