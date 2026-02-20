package ankurgoyal.javaSelenium;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Why Methods: wrapping code into a block so that it it can used again.
		
		MethodsDemo md = new MethodsDemo();
		md.getData();
		MethodsDemo.getData2();//calling static by using class name only as static belongs to class not the object

	}
	
	
	public void getData() {
		
		System.out.println("Hello World");
		
	}
	
public static void getData2() {
		
		System.out.println("Hello World again");
		
	}
	

}
