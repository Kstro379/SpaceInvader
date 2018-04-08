package Structure;

public class CircularSimpleList<T> {
	
	private SimpleNode<T> start;
	private SimpleNode<T> last;
	private int lenght;
	
	public void  CircularSimleList() {
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
		
		if (isEmpty()) {
			start = node;
			last = node;
			
			last.setNext(start);
			
			lenght++;
			
		}else {
			last.setNext(node);
			node.setNext(start);
			last = node;
			
			lenght++;
		}
		
		
	}

	public T getData(int position) throws Exception {

		if (position >= 0 && position < lenght) {

			if (position == 0) {
				return start.getData();

			} else {
				SimpleNode<T> aux = start;

				for (int i = 0; i < position; i++) {
					aux = aux.getNext();

				}
				return aux.getData();
			}

		} else {
			throw new Exception("Invalid");
		}
	}
	
	public void delete() {
		start = null;
		last = null;
		lenght = 0;
		
	}

}
