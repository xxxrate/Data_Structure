package game.datastructure.structure;

/**
 * 堆栈
 * 1)LIFO 先进后出表
 * 2)实现压栈push(),弹出pop()
 * 3)需要检查堆栈是否为空
 * 4)需要检查堆栈是否为满
 * 5)访问栈顶数据
 * @author pc
 *
 */
public class Stack {
	private int[] a;
	private int MAX;
	private int top;
	
	public Stack(int size){
		this.MAX = size;
		a = new int[MAX];
		top = -1;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == (this.MAX - 1));
	}
	
	public void push(int value){	
		if(top < MAX - 1){
			a[++top] = value;
		}else{
			System.out.println("is full");
		}
	}
	
	public int pop(){
		return a[top--];
	}
	
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		System.out.println("length" + stack.MAX);
		stack.push(6);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println("当前栈顶元素" + stack.pop());
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
	}

}
