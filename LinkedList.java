package game.datastructure.linkedlist;

/**
 * 自定义实现链表
 * Head-> |data|next| -> |others|
 * 自定义类Node表示节点，头节点为Head
 * data：当前节点数据
 * next:下一个节点的引用
 * 实现功能：
 * 1)链尾增加节点
 * 2)删除任意节点
 * 3)打印链表
 * 
 * 
 * @author pc
 *
 */

public class LinkedList {
	
	//头节点为空
	Node head = null;
	//自定义节点类
	class Node {
		int data;
		Node next = null;//下一节点为空
		
		public Node(int data){
			this.data = data;
		}		
	}
	
	/**
	 * 添加节点
	 * @param data
	 * @return
	 */
	public boolean addNode(int data){
		Node newNode = new Node(data);
		
		if(head == null){
			head = newNode;
			System.out.println("头节点为空，头节点添加成功！");
			return true;
		}else if(head != null){
			//创建临时节点，将下一个节点的next（引用）传递出去
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			System.out.println("后续节点添加成功！" + temp.next.data);
			return true;
		}else {
			System.out.println("节点添加失败！");
			return false;
		}
	}
	
	/**
	 * 根据索引位置删除
	 * @param index
	 */
	public void deleteNode(int index){
		Node preNode = head;
		Node curNode = preNode.next;
		
		//有bug，无法完全清空链表
		if(index == 0 && head.next == null){
			head = null;
			System.out.println("链表为空，删除头节点成功！" + head);
			return;
		}
		
		if(index == 0){//删除头节点
			head = head.next;
			System.out.println("头节点删除成功！");
		}else if(index > 0 && index < length()){
			int i = 1;
			while(preNode != null){
				if(i == index){
					preNode.next = curNode.next;
					System.out.println("节点删除成功！");
					break;
				}
				preNode = curNode;
				curNode = curNode.next;
				i++;
			}
		}else {
			System.out.println("节点删除失败！");
		}
	}
	
	/**
	 * 获取链表长度
	 * @return
	 */
	public int length(){
		Node temp = head;
		int length = 0;
		while(temp != null) {
			temp = temp.next;
			length++;
		}
		System.out.println("length:" + length);
		return length;
	}
	
	/**
	 * 通过创建temp临时节点，循环遍历链表
	 */
	public void display(){
		if(head != null){
			System.out.print(head.data + "->");
			Node temp = head.next;
			while(temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList one = new LinkedList();
		one.addNode(0);
		one.addNode(1);
		one.addNode(2);
		one.addNode(3);
		one.display();
		one.length();
		one.deleteNode(0);
		one.display();
		one.deleteNode(0);
		one.display();
		one.deleteNode(0);
		one.display();
		one.deleteNode(0);
		one.display();
	}

}
