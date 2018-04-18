package others;
import java.util.Scanner;

import game.datastructure.Stack;

/**
 * ����ջʵ���沨��ʽ(��׺���ʽ)
 * 1)��������ջ�ֱ������ֺ������
 * 2)�Ƚϵ�ǰ���ַ���Ϊ����ѹ��element��Ϊ��������Ҫ������������ȼ������жϣ�������ѹ��op������ѹ��element
 * @author acer
 *
 */
public class ReversePolish {
	private Stack element;
	private Stack op;
	private String input;
	
	
	public ReversePolish(String in) {
		this.input = in;
		this.element = new Stack(input.length());
		this.op = new Stack(input.length());
		System.out.println("������ɣ�����Ϊ" + input.length() );
	}
	
	/**
	 * �����
	 * 1)��opΪ�գ���ѹ��op
	 * 2)������"(",ѹ��op������Ƚ�opջ����Ԫ�����ȼ�  (1)��С����ջ��Ԫ�ز�ѹ��element������ѹ��op
	 * 3)������")",����opջ����ֱ������"("���ظ�2��3
	 * 4)��ʣ�µ�opԪ�ص���
	 * �ַ�
	 * 1)ֱ��ѹ��element
	 */
	public void judge() {
		for(int i = 0;i < input.length();i++) {
			char temp = input.charAt(i);
			System.out.println("��" + i + "��:" + "��ǰԪ��Ϊ:" + temp);
			switch(temp){
			case '(':
				op.push(temp);
				System.out.println(temp + "��ջ");
				break;
			case ')':
				System.out.println("����������");
				getLast();
				break;
			case '+':
			case '-':
				getOp(temp,1);
				break;
			case '*':
			case '/':
				getOp(temp,2);
				break;
		    default:
		    	element.push(temp);//ѹ��Ԫ��
				System.out.println("Ԫ�أ�" + temp + "��ջ");
				break;
			}
		}
		//����ʣ�������
		while(!op.isEmpty()) {
			element.push(op.getTop());
			System.out.println("ʣ�������elementջ" + op.getTop() + "��ջ" );
			op.pop();
			System.out.println(op.isEmpty());
		}
	}
	
	/**
	 * �Ƚ���������ȼ�
	 * 1)������"(",ѹ��op������Ƚ�opջ����Ԫ�����ȼ�  (1)��С����ջ��Ԫ�ز�ѹ��element������ѹ��op
	 * 2)������")",����opջ����ֱ������"("���ظ�1��2
	 * @param opThis
	 * @param level
	 */
	public void getOp(char opThis,int level) {
		while(!op.isEmpty()) {
			char top = op.getTop();
			System.out.println("�������ȼ��Ƚϣ���ǰԪ��Ϊ��" + top);
			if(top == '(') {
				op.push(opThis);
				System.out.println("���������ţ�" + opThis + "ֱ����ջ");
				break;
			}else{
				int level2;
				if(top == '+' || top == '-') {//����ջ��Ԫ�����ȼ�   + - �����ȼ�Ϊ1 * /Ϊ2
					level2 = 1;
				}else {
					level2 = 2;
				}
				if(level > level2) {
					op.push(opThis);
					System.out.println("��ǰ�����" + opThis + "���ȼ���ջ��Ԫ��" + top + "��");
					break;
				}else {
					element.push(opThis);
					System.out.println("��ǰ�����" + opThis + "���ȼ���ջ��Ԫ��" + top + "��");
				}
			}
			
		}
		if(op.isEmpty()) {//���opջΪ����ֱ��ѹ�������
			op.push(opThis);
			System.out.println("opջΪ�գ�ѹ��" + opThis);
		}
	}
	
	/**
	 * ���������ţ���ջ˳�򵯳�Ԫ��
	 */
	public void getLast() {
		while(!op.isEmpty()) {
			char topThis = op.getTop();
			System.out.println("��ǰջ��Ԫ��Ϊ" + topThis);
			if(topThis != '(') {
				element.push(topThis);
				System.out.println("�������������ջ����ѹ��element" + topThis);
				op.pop();
				System.out.println("-----------");
			}else {
				op.pop();
				System.out.println("�������ѵ���");
				System.out.println("-----------");
			}
		}
	}
	
	
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String s = scan.next();
		String s = "A*(B+C)-D/(E+F)";
		System.out.println(s);
		ReversePolish re = new ReversePolish(s);
		re.judge();
		for(int i = 0;i < s.length();i++) {
			re.element.pop();
		}
//		scan.close();
	}

}
