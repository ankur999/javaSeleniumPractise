package ankurgoyal.javaSelenium;

public class ArrayEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//print max in the col wher you find the min no in row
		//2 4 7
		//3 6 9
		//1 2 8
		//in above 3r row has min value and max value in that col is 3 so o/p should be 3
		//Step 1 find min no
		//step 2 identify column of min no.
		//step 3 find max no in that column
		
		
		
		int arr[][]= {{2,4,7},{3,6,9},{1,2,8}};
		int min=arr[0][0];//2
		int mincolumn=0;
		

		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				if(min>=arr[i][j]) {
					min=arr[i][j];
					mincolumn=j;
					
				}
				
			}
			
		}
		//mincolumn=0
		int max=arr[0][mincolumn];//00=2
		int k=0;
		while(k<3) {
			
			if(arr[k][mincolumn]>max) {
				max=arr[k][mincolumn];
			}
			k++;
			
		}
		System.out.println(max);
		

	}
	

}
