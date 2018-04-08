package Structure;

public class DoubleList<T> {
	
	private DoubleNode<T> start;
	private int lenght;
	
	public DoubleList() {
		start = null;
		lenght = -1;
	}
	
	public void insertAtStart(T data) {
		DoubleNode<T> node = new DoubleNode<T>();
		node.setData(data);
		
		if (start == null) {
			start = node;
			lenght++;
			
		}else {
			node.setNext(start);
			start.setBack(node);
			start = node;
			lenght++;
		}
	}
	
	public void insertAtFinal(T data) {
		DoubleNode<T> node = new DoubleNode<T>();
		node.setData(data);
		
		if (start == null) {
			start = node;
			lenght++;
			
		}else {
			DoubleNode<T> aux = start;
			
			while(aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(node);
			node.setBack(aux);
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
	public T getData (int position) throws Exception{
		
		if (position >= 0 && position <= lenght && start.getData() != null) {
			if (position == 1) {
				return start.getData();
				
			}else {
				DoubleNode<T> aux = start;
				for (int i = 0; i < position; i++) {
					aux = aux.getNext();
				}
				
				return aux.getData();
			}
			
		}else {
			throw new Exception("Invalid");
		}
	}
	
	public void delete() {
		start = null;
		lenght = 0;
	}
	
	

}
