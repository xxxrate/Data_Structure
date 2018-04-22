package game.datastructure.tree;

/**
 * ���Ľڵ��࣬����Ϊ���ڵ㡢��������
 * �ڵ�Ĺ��췽��Ϊ���������������Լ�������
 * @author acer
 *
 */
public class Node {
	private Object data;
	private Node leftChild;
	private Node rightChild;
	
	/**
	 * ����������Ҷ�ӵĽڵ�
	 * @param leftChild
	 * @param rightChild
	 * @param data
	 */
	public Node(Node leftChild,Node rightChild,Object data) {
		this.data = data;
		this.setLeftChild(leftChild);
		this.setRightChild(rightChild);	
	}
	
	/**
	 * �����Ϸ��������������ڵ�
	 * @param data
	 */
	public Node(Object data) {
		this(null, null, data);
	}
	
	
	
	public void display() {
		System.out.println("��ǰ�ڵ�ֵ:" + this.data);
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	

	
}
