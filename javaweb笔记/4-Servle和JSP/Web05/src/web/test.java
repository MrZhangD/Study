package web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "张迪";
		String str1 = URLEncoder.encode(str,"utf-8");
		System.out.println(str1);
		System.out.println(URLDecoder.decode(str1, "utf-8"));
	}

}
