package pers.zhangdi.sort;

import java.util.Arrays;
//快速排序
public class QuickSort {
	public static void main(String[] args) {
		int[] a = ran.arr(75000) ;
		int n = a.length;
		QS(a , 0 , n - 1) ;
		
		long starTime=System.currentTimeMillis();
		QS(a , 0 , n - 1) ;
		long endTime = System.currentTimeMillis();
		long Time=endTime-starTime;
		System.out.println(Time + "ms");
	}
	//排序
	public static void QS(int[] a , int low , int high) {
		if(low < high) {
			int p = partition(a  , low , high) ;
			QS(a , low , p - 1) ;
			QS(a , p + 1 , high) ;
		}
	}
	//分区
	public static int partition(int[] a , int low , int high) {
		int pivot = a[high] ;			//枢轴
		int i = low - 1 ;
		for(int j = low ; j <= high - 1 ; j++) {
			if(a[j] < pivot) {
				i++ ;
				if(i < j) {
					int temp = a[i] ;
					a[i] = a[j] ;
					a[j] = temp ;
				}
			}
		}
		if(a[high] < a[i + 1]) {
			int temp = a[high] ;
			a[high] = a[i + 1] ;
			a[i + 1] = temp ;
		}
		return (i + 1) ;	
	}
}
