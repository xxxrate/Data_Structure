package game.datastructure.tree;

/**
 * 树的节点类，属性为根节点、左右子树
 * 节点的构造方法为构建左右子树，以及数据项
 * @author acer
 *
 */
public class Node {
	private Object data;
	private Node leftChild;
	private Node rightChild;
	
	/**
	 * 创建有左右叶子的节点
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
	 * 调用上方函数创建独立节点
	 * @param data
	 */
	public Node(Object data) {
		this(null, null, data);
	}
	
	
	
	public void display() {
		System.out.println("当前节点值:" + this.data);
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
