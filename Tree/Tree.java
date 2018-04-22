package game.datastructure.tree;
import java.util.ArrayList;
import java.util.List;

import game.datastructure.tree.Node;

/**
 * ����������
 * 1)�������������б������������
 * 2)��ȡ�����б��еĸ�����������������ڵ㣬�������ڽڵ��б���
 * 3)��ȡ�ڵ��б���˳�򴴽�������
 * @author acer
 *
 */
public class Tree {
	private Node root = new Node(null);//��ʼ�����ڵ�
	private List<Node> datum;//ʹ�ýڵ��б���Ԫ��
	/**
	 * ���������
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
	 * ����������
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