package ankurgoyal.javaSelenium;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//it is a container which contain data of similar type
		
		int a[]=new int[5];//declares an array and allocates memory for the values; fist allocating memory then assigning values
		int b[]= {2,8,9,7};//directly assign memory to values
		a[0]=1;
		a[1]=5;
		a[2]=6;
		a[3]=9;
		a[4]=3;
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		

	}

}
