package ankurgoyal.javaSelenium;

public class ChildInherit extends ParentInherit {
	int i=20;
	
	public void engine() {
		System.out.println("New Engine code implemented from child");
	}
	
	public void color() {
		System.out.println(color);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParentInherit ci=new ChildInherit();
		//ci.color();
		ci.brakes();
		ci.engine();
		System.out.println(ci.i);

	}

}
