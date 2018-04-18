package others;
import java.util.Scanner;

import game.datastructure.Stack;

/**
 * 利用栈实现逆波兰式(后缀表达式)
 * 1)创建两个栈分别存放数字和运算符
 * 2)比较当前的字符，为数字压到element，为操作符则要按照运算符优先级进行判断，若大则压入op，否则压入element
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
		System.out.println("构造完成，长度为" + input.length() );
	}
	
	/**
	 * 运算符
	 * 1)若op为空，则压入op
	 * 2)若遇到"(",压入op，否则比较op栈顶的元素优先级  (1)若小弹出栈顶元素并压入element，否则压入op
	 * 3)若遇到")",弹出op栈顶，直到遇到"("，重复2、3
	 * 4)将剩下的op元素弹出
	 * 字符
	 * 1)直接压入element
	 */
	public void judge() {
		for(int i = 0;i < input.length();i++) {
			char temp = input.charAt(i);
			System.out.println("第" + i + "趟:" + "当前元素为:" + temp);
			switch(temp){
			case '(':
				op.push(temp);
				System.out.println(temp + "入栈");
				break;
			case ')':
				System.out.println("遇到右括号");
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
		    	element.push(temp);//压入元素
				System.out.println("元素：" + temp + "入栈");
				break;
			}
		}
		//处理剩余运算符
		while(!op.isEmpty()) {
			element.push(op.getTop());
			System.out.println("剩余运算符element栈" + op.getTop() + "入栈" );
			op.pop();
			System.out.println(op.isEmpty());
		}
	}
	
	/**
	 * 比较运算符优先级
	 * 1)若遇到"(",压入op，否则比较op栈顶的元素优先级  (1)若小弹出栈顶元素并压入element，否则压入op
	 * 2)若遇到")",弹出op栈顶，直到遇到"("，重复1、2
	 * @param opThis
	 * @param level
	 */
	public void getOp(char opThis,int level) {
		while(!op.isEmpty()) {
			char top = op.getTop();
			System.out.println("进行优先级比较，当前元素为：" + top);
			if(top == '(') {
				op.push(opThis);
				System.out.println("遇到左括号，" + opThis + "直接入栈");
				break;
			}else{
				int level2;
				if(top == '+' || top == '-') {//赋予栈顶元素优先级   + - 的优先级为1 * /为2
					level2 = 1;
				}else {
					level2 = 2;
				}
				if(level > level2) {
					op.push(opThis);
					System.out.println("当前运算符" + opThis + "优先级比栈顶元素" + top + "高");
					break;
				}else {
					element.push(opThis);
					System.out.println("当前运算符" + opThis + "优先级比栈顶元素" + top + "低");
				}
			}
			
		}
		if(op.isEmpty()) {//如果op栈为空则直接压入运算符
			op.push(opThis);
			System.out.println("op栈为空，压入" + opThis);
		}
	}
	
	/**
	 * 遇到右括号，按栈顺序弹出元素
	 */
	public void getLast() {
		while(!op.isEmpty()) {
			char topThis = op.getTop();
			System.out.println("当前栈顶元素为" + topThis);
			if(topThis != '(') {
				element.push(topThis);
				System.out.println("遇到右括号输出栈顶并压入element" + topThis);
				op.pop();
				System.out.println("-----------");
			}else {
				op.pop();
				System.out.println("左括号已弹出");
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
