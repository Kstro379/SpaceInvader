package Structure;

public class SimpleNode<T> {
	
	private T data;
	private SimpleNode<T> next;
	
	public SimpleNode() {
		this.next = null;
		this.data = null ;
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SimpleNode<T> getNext() {
		return next;
	}

	public void setNext(SimpleNode<T> next) {
		this.next = next;
	}
	
	

}
