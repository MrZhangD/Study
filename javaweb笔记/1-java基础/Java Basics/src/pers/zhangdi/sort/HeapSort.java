package pers.zhangdi.sort;

import java.util.Arrays;
//堆排序
public class HeapSort {
	public static void main(String[] args) {
		int[] a = ran.arr(75000) ;
		int n = a.length;
		
		long starTime=System.currentTimeMillis();
		HS(a , n) ;
		long endTime = System.currentTimeMillis();
		long Time=endTime-starTime;
		System.out.println(Time + "ms");
	}
	//排序
	public static void HS(int[] H , int n) {
		MakeHeap(H , n) ;
		for(int i = n - 1 ; i > 0 ; i--) {
			int temp = H[0] ;
			H[0] = H[i] ;
			H[i] = temp ;
			SiftDown(H , i , 0) ;
		}
	}
	//建立初始堆
	public static void MakeHeap(int[] H , int n) {
		for(int i = n/2 - 1 ; i >= 0 ; i--) {
			SiftDown(H , n , i) ;
		}
	}
	//筛选
	public static void SiftDown(int[] H , int n , int i) {
		boolean done = false ;
		while (!done && ((i = 2 * i + 1) < n)) {
			if((i + 1 < n) && (H[i + 1] > H[i]))
				i++ ;
			if(H[(i - 1) / 2] < H[i]) {
				int temp = H[(i - 1) / 2] ;
				H[(i - 1) / 2] = H[i] ;
				H[i] = temp ;
			}
			else
				done = true ;
		}
	}
}
