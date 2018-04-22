package game.datastructure.tree;
import java.util.ArrayList;
import java.util.List;

import game.datastructure.tree.Node;

/**
 * 创建二叉树
 * 1)首先利用数据列表保存各个数据项
 * 2)读取数据列表中的各个数据项，创建独立节点，并保存在节点列表中
 * 3)读取节点列表，按顺序创建二叉树
 * @author acer
 *
 */
public class Tree {
	private Node root = new Node(null);//初始化根节点
	private List<Node> datum;//使用节点列表保存元素
	/**
	 * 构造二叉树
	 * 1)
	 * @param data
	 */
	public Tree(Object[] data) {
		datum = new ArrayList<Node>();
		for (Object object : data) {
			datum.add(new Node(object));
		}
		root = datum.get(0);
		for(int i = 0;i < data.length/2;i++) {
			datum.get(i).setLeftChild(datum.get(i*2+1));
			if(i*2+2 < datum.size()) {
				datum.get(i).setRightChild(datum.get(i*2+2));
			}
			
		}
	}
	
	/**
	 * 遍历二叉树
	 * 
	 */
	public void preorder(Node root) {
		if(root != null) {
			visit(root);
			preorder(root.getLeftChild());
			preorder(root.getRightChild());
		}
	}
	
	public void visit(Object object) {
		System.out.println(object + "");
	}
	
	
	public static void main(String[] args) {
		Object[] data = {0,1,2,3,4,5,6,7};
		Tree tree = new Tree(data);
		tree.preorder(tree.root);
	}

}