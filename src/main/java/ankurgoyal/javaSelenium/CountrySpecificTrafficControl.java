package ankurgoyal.javaSelenium;

public class CountrySpecificTrafficControl implements WorldSpecificTrafficControl, ContinentTrafficControl{

	@Override
	public void GoGreen() {
		// TODO Auto-generated method stub
		System.out.println("Green Go Implementation");
	}

	@Override
	public void StopRed() {
		// TODO Auto-generated method stub
		System.out.println("Red Stop Implementation");
	}

	@Override
	public void WaitYellow() {
		// TODO Auto-generated method stub
		System.out.println("Yellow Wait Implementation");
		
	}
	
	public void walk() {
		System.out.println("Walking on the streets of australia");
	}
	
	public static void main(String args[]) {
		
		WorldSpecificTrafficControl wstc=new CountrySpecificTrafficControl();
		wstc.GoGreen();
		wstc.StopRed();
		wstc.WaitYellow();
		//cstf.walk();//i can not use this i am using ref of parent class to use this i need to change ref to child class
		CountrySpecificTrafficControl cstc=new CountrySpecificTrafficControl();
		cstc.trainSymbol();
		
	}

	@Override
	public void trainSymbol() {
		// TODO Auto-generated method stub
		System.out.println("train Symbol Activated");
		
	}
	
	
	

}
