package ankurgoyal.javaSelenium;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AssignmentJavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AssignmentJavaStreams ajs= new AssignmentJavaStreams();
		ajs.streamAssignment();

	}
	
	public void streamAssignment() {
		
		List<Integer> numbers=Arrays.asList(3,2,2,7,5,1,9,7);
		//print unique no from this array
		//sort the array
		//after sort give me the 3rd index
		
//		Set<Integer> newSet=numbers.stream().collect(Collectors.toSet());
//		System.out.println(newSet);
		
		numbers.stream().distinct().sorted().forEach(s->System.out.println(s));
		System.out.println("Getting 3rd index");
		List<Integer> newlist=numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newlist.get(3));
	}

}
