package game.datastructure;

import java.util.Scanner;

public class Stack {
	
	private int size;
	private int top;
	private char[] array;
	
	public Stack(int size) {
		this.size = size;
		this.array = new char[size];
		this.top = -1;
	}
	
	public void push(char t) {
		if(!isFull()) {
			array[++top] = t;
			System.out.println("Ԫ��" + t + "��ջ");
		}else {
			System.out.println("��ǰջ��");
		}
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("��ǰջΪ��");
		}else{
			System.out.println("ջ������" + array[top] + " ");
			top--;
		}
		
	}
	
	public char getTop() {
		return array[top];
	}
	
	public boolean isFull() {
		if(top != size - 1) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	/*
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack my = new Stack(5);
		String s = scan.next();
		my.push(s);
		my.pop();
		scan.close();
		

	}*/

}
