package ankurgoyal.javaSelenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUpTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// If Else Condition

		// Print only values which is multiple of 2
		// Check if array has multiple of 2

		int[] myarr = { 1, 2, 3, 4, 5, 6, 7, 8 };

		for (int i = 0; i < myarr.length; i++) {

//			if(myarr[i]%2==0) {
//				System.out.println(myarr[i]);
//			}
//			else {
//				System.out.println("Not Multiple of 2");
//				
//			}

			if (myarr[i] % 2 == 0) {
				System.out.println("Array has multiple of two");
				break;// will exist the loop if condition is met earlier
			} else {
				System.out.println("Array doesn't has multiple of two");
			}

		}

		// ArrayList

		ArrayList list = new ArrayList();
		list.add(1);// adding values is arraylist
		list.add(null);// Can store null values
		list.add("Rahul");// can store duplicates values
		list.add("Rahul");
		System.out.println(list.get(0));// Retrieving value from arraylist
		System.out.println(list.get(2));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("--------using for eachloop------");

		for (Object ls : list) {
			System.out.println(ls);
		}

		// items present in arraylist or not

		System.out.println(list.contains("Rahul"));

		// converting array to arraylist
		String[] name1 = { "Rahul", "Tina", "Meera", "Romil" };

		List<String> al = Arrays.asList(name1);
		System.out.println(al);
		System.out.println(al.contains("Tina"));

	}

}
