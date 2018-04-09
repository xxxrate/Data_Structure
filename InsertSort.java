package game.datastructure.sort;

public class InsertSort {
	/**
	 * 直接插入排序
	 * 1)设第一个数为已排序序列
	 * 2)设第n个数为哨兵与已排序列进行对比
	 * 3)当发现与其相等时插入该序列后面
	 * @param a
	 */
	public void insert(int[] a){
		int i;
		for(i = 1;i < a.length;i++){//条件1
			int n = a[i];//条件2
			int j;
			for(j = i; j > 0 && n < a[j-1]; j--){//条件3
				a[j] = a[j-1];
			}
			a[j] = n;
		}
	}
	
	/*
	 * 打印元素
	 */
	public void display(int[] a){
		for(int i = 0;i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		int[] a = {3,1,6,11,8,9};
		InsertSort sort = new InsertSort();
		System.out.println("排序前：");
		sort.display(a);
		sort.insert(a);
		System.out.println("排序后：");
		sort.display(a);
	}

}
