package game.datastructure.sort;

public class SimpleSelectionSort {
	
	/**
	 * 简单选择排序
	 * 1)选择最小(大)数与第一个位置进行交换
	 * 2)重复第一步,直到第n-1与第n个数进行比较
	 * @param a
	 */
	public void SelectSort(int[] a){
		int min;
		for(int i = 0;i < a.length;i++){
			System.out.print("第" + i + "趟:");
			Display(a);
			min = i;
			for(int j = i + 1;j < a.length;j++){
				if(a[min] > a[j]){
					min = j;
					//System.out.println(a[min] + " " + a[i]);
				}
			}
			Swap(a, min, i);
		}
	}
	
	/**
	 * 每一趟找出最小(大)的元素对第i个位置进行交换
	 * @param a 原序列
	 * @param min 最小值
	 * @param i 当前位置
	 */
	public void Swap(int[] a,int min,int i){
		if(min == i){
			//System.out.println("无需变换！");
			return;
		}
		int temp;//利用临时变量进行交换
		temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}
	
	/**
	 * 打印元素
	 * @param a
	 */
	public void Display(int[] a){
		for(int i = 0;i < a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		int[] a = {3,1,5,7,2,4,9,6,10,8};
		SimpleSelectionSort sort = new SimpleSelectionSort();
		System.out.println("当前序列：");
		sort.Display(a);
		sort.SelectSort(a);
		System.out.println("排序后序列：");
		sort.Display(a);
	}

}
