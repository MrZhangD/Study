package pers.zhangdi.sort;

//≤Â»Î≈≈–Ú
public class InserttionSort {
	public static void main(String[] args) {
		int [] a =  {2,7,3,12,4} ;
		IS(a,5) ;
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void IS(int[] a , int n) {
		int x ;
		int j ;
		for(int i = 1 ; i < n ; i++) {
			x = a[i] ;
			j = i - 1 ;
			while(j >= 0 && a[j] > x) {
				a[j+1] = a[j--] ;
			}
			a[j+1] = x ;
		}
	}
}

