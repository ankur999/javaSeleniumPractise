package ankurgoyal.javaSelenium;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CoreJavaBrushUpThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//String is an Object in java represent sequence of characters
		
		String s = "Ankur";//created string using string literal
		String s1 = "Ankur";
		
		//here string will check if Ankur is present in memory or not if it is present
		//it will not create new object and will use previous object if it is not present it will create new object.
		
		//another way creating string
		
		String str = new String("Welcome");
		String str1 = new String("Welcome");
		
		//In above statement it will create two new object if the value is same or not still it will create two.
		
		String str2 = new String("The Java Begins");
		String[] splittedString =str2.split("Java"); //{"The","Java","Begins"}
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1].trim());
		//System.out.println(splittedString[2]);
		
		//System.out.println(splittedString[1].trim());
		
		//printing char by char
		
		for(int i=0;i<str2.length();i++) {
			System.out.println(str2.charAt(i));
		}
		
		//printing in reverse order
		System.out.println("-------In Reverse--------");
		
		for(int i=str2.length()-1;i>=0;i--) {
			System.out.print(str2.charAt(i));
		}
		

	}

}
