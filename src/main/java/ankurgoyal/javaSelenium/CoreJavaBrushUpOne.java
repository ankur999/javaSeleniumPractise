package ankurgoyal.javaSelenium;

public class CoreJavaBrushUpOne {

	public static void main(String[] args) {

		int myNum = 5;// primitive datatype
		String website = "RahulShetty Academy";// non primitive
		char letter = 'r';
		float f = 10.4f;
		boolean b = true;

		System.out.println(myNum);
		System.out.println(website);
		System.out.println(letter);
		System.out.println(f);
		System.out.println(b);

		// Arrays: used to store and retrieve value of similar data types

		// declaration

		int[] arr = new int[5];// first way
		arr[0] = 12;
		arr[1] = 10;
		arr[2] = 15;
		arr[3] = 17;
		arr[4] = 18;

		int[] arr1 = { 1, 2, 3, 4, 5 };// second way
		System.out.println(arr[2]);

		// Loops

		System.out.println("------Value from arrays1---------");
		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
		}

		System.out.println("------Value from arrays2---------");
		for (int i = 0; i < arr1.length; i++) {

			System.out.println(arr1[i]);
		}

		// String Array
		System.out.println("-------Printing String Arrays--------");
		String[] name = { "Rahul", "Tina", "Meera", "Romil" };

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}

		// enhanced for loop

		System.out.println("--------Using forEach Loop--------");

		for (String s : name) {
			System.out.println(s);

		}

	}

}
