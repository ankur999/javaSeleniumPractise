package ankurgoyal.javaSelenium;

public interface WorldSpecificTrafficControl {
	
	//we can define variables in interface also but that should be public
	int i=4;
	
	public void GoGreen();
	public void StopRed();
	public void WaitYellow();

}
