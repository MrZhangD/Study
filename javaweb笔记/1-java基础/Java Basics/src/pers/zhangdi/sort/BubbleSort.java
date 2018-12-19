package pers.zhangdi.sort;

//冒泡排序

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = ran.arr(75000) ;
		int n = a.length;
		
		long starTime=System.currentTimeMillis();
		BS(a , n) ;
		long endTime = System.currentTimeMillis();
		long Time=endTime-starTime;
		System.out.println(Time + "ms");
//		System.out.println(Arrays.toString(a));
	}
	
	public static void BS(int[] a , int n) {
		for(int i = n - 1 ; i >= 1 ; i--) {
			boolean hasSwap = false ;
			for(int j = 0 ; j <= (i - 1) ; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j] ;
					a[j] = a[j+1] ;
					a[j+1] = temp ;
					hasSwap = true ;
				}
			}
			if(!hasSwap)
				break ;
		}
	}
}
