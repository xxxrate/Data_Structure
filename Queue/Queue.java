package game.datastructure;

/**
 * 创建简单队列
 * 1)实现队尾添加元素
 * 2)实现对头挪出元素
 * 3)打印队列
 * @author acer
 *
 */
public class Queue {
	    private Object[] array;
	    private int size;
	    private int front;
	    private int rear;
	    private int items;

	public Queue(int size) {
	    this.size = size;
	    array = new Object[size];
	    front = 0;
	    rear = -1;
	    items = 0;
	}

	public void addItem(int item){
	    if(isFull()){
	        System.out.println("queue is full!");
	    }else{
	        if(rear == size -1){
	            rear = -1;
	        }
	        array[++rear] = item;
	        items++;
	    }
	}

	public Object removeItem(){
	    Object temp = null;
	    if(!isEmpty()){
	        temp = array[front];
	        array[front] = null;
	        front++;
	        items--;
	        if(front == size){
	            front = 1;
	        }
	        return temp;
	    }
	    return temp;
	}
	            
	public boolean isFull(){
	    return items == size;
	}

	public boolean isEmpty(){
	    return items == 0;
	}

	public int getTop(){
	    return (int) array[front];
	}

	public int getSize(){
	    return items;
	}
	
	public void display() {
		for(int i = 0;i < array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		Queue s = new Queue(5);
		s.addItem(1);
		s.addItem(2);
		s.addItem(3);
		s.addItem(4);
		s.addItem(5);
		s.addItem(6);
		s.display();
		System.out.println(s.front + " " + s.items + " " + s.rear + " " + s.size + " " + s.getTop());
		System.out.println(s.removeItem());
		System.out.println(s.removeItem());
		System.out.println(s.removeItem());
		System.out.println(s.removeItem());
		System.out.println(s.removeItem());
		System.out.println(s.removeItem());
		//System.out.println(s.front + " " + s.items + " " + s.rear + " " + s.size + " " + s.getTop());
	}

}
