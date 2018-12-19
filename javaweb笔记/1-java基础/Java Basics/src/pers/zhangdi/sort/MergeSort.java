package pers.zhangdi.sort;

import java.util.Arrays;
//合并排序
public class MergeSort {
	public static void main(String[] args) {
		int[] a = ran.arr(75000) ;
		int n = a.length;
		MS(a , 0 , n-1) ;
		
		long starTime=System.currentTimeMillis();
		MS(a , 0 , n-1) ;
		long endTime = System.currentTimeMillis();
		long Time=endTime-starTime;
		System.out.println(Time + "ms");
	}
	
	public static void MS(int[] a , int low , int high) {
		if(low < high) {
			int mid = (low + high)/2 ;
			MS(a , low , mid) ;
			MS(a , mid + 1 , high) ;
			Merge2SortedSubArr(a , low , mid , high) ;
		}
	}
	
	public static void Merge2SortedSubArr(int[] a , int p ,int q , int r) {
		int[] b = new int[r + 1] ;
		int i = p ;
		int j = q + 1 ;
		int k =p ;
		while(i <= q && j <= r) {
			if(a[i] <= a[j]) 
				b[k++] = a[i++] ;
			else
				b[k++] = a[j++] ;
		}
		if(i == q + 1)
			for(; j <= r ; j++)
				b[k++] = a[j] ;
		else
			for(; i <= q ; i++)
				b[k++] = a[i] ;
		for(i = p ; i <= r ; i++)
			a[i] = b[i] ;
	}
}
