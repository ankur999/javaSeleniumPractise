package ankurgoyal.javaSelenium;

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//find min no in a 3*3 array
		
		int arr[][]= {{2,4,7},{3,6,9},{1,2,8}};
		
		int min=arr[0][0];//2
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				if(min>=arr[i][j]) {
					min=arr[i][j];
					
				}
				//System.out.println(min);
			}
			
		}
		System.out.println(min);
		
		
		
		
		

	}

}
