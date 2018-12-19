package web;


public class test {
	public static void main(String[] args) {
		String str="/Web03/list1.jsp";
		System.out.println(str.lastIndexOf("/") + "------" + str.lastIndexOf("."));
		System.out.println(str.subSequence(str.lastIndexOf("/"),str.lastIndexOf(".")));
	}
}
