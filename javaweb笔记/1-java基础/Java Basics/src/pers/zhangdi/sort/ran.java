package pers.zhangdi.sort;

import java.util.Random;
//产生n个随机数并赋值给长度为n的数组
public class ran {
	public static int[] arr(int n) {
		Random ran = new Random() ;
		int[] a = new int[n] ;
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = ran.nextInt() ;
		}
		return a ;
	}
}
