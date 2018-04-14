package game.datastructure.sort;

public class ShellSort {
	
	/**
	 * 希尔排序（直接排序的改良）[排序次数无法确定，故不稳定]
	 * 1)基本思路与直接排序一样，增加间距进行比较
	 * 2)从第一个数开始，设定间距为d，与第d-1个进行比较，进行置换
	 * 3)直至最后d = 1
	 * @param a
	 * @param d
	 */
	public void ShellSortO(int[] a,int d){
		int i;
		for(i = d;i < a.length;i++){//条件1	
			if(a[i] < a[i-d]) {
				int n = a[i];//条件2
				a[i] = a[i-d];
				int j;
				for(j = i-d;j >= 0 &&n < a[j];j=j-d){//条件3
					a[j+d] = a[j];
				}
				a[j+d] = n;
			}
			
		}
	}
	
	/**
	 * 插入间隔进行直接插入排序
	 * @param a
	 */
	public void ShellSortR(int[] a){
		int d = a.length/2;
		while(d >= 1){//间距为1结束排序
			ShellSortO(a,d);
			d = d/2;
		}
		
	}
	
	/**
	 * 打印元素
	 * @param a
	 */
	public void Display(int[] a){
		for(int i = 0;i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		int[] a = {3,1,6,11,8,9};
		ShellSort sort = new ShellSort();
		System.out.println("排序前：");
		sort.Display(a);
		sort.ShellSortR(a);
		System.out.println("排序后：");
		sort.Display(a);
	}

}
