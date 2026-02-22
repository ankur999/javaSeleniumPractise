package ankurgoyal.javaSelenium;

public class NestedLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=4;i++) {//this block will run 4 times
			
			System.out.println("outer loop started");
			
			for(int j=1;j<=4;j++) {
				
				System.out.println("inner loop started");
				
			}
			System.out.println("outer loop finished");
			
		}

	}

}
