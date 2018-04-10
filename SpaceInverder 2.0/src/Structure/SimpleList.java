package Structure;

public class SimpleList<T> {
	
	private  SimpleNode<T> start;
	private int lenght;
	
	
	public SimpleList(){
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
	
	public void setAtFinal(T data) {
		SimpleNode<T> node = new SimpleNode<T>();
		
		node.setData(data);
		
		if (lenght == 0) {
			start = node;
			lenght++;
			
			
		}else {
			SimpleNode<T> aux = start;
			
			while(aux.getNext() != null) {
				aux = aux.getNext();
			}
			
			aux.setNext(node);
			lenght++;
			
		}
		
		
		
	}
	
	public T getData (int position)  {
		
		
			if (position == 0) {
				return start.getData();
				
			}else {
				
				SimpleNode<T> aux = start;
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
