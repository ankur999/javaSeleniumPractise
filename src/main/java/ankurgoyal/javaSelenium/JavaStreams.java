package ankurgoyal.javaSelenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class JavaStreams {

	public static void main(String[] args) {

		JavaStreams js = new JavaStreams();
		js.streamFilter();
		js.streamMap();
		js.streamColllect();

	}

	// @Test

	public void streamFilter() {

		ArrayList<String> list = new ArrayList<>();

		list.add("Akhil");
		list.add("Ramesh");
		list.add("Arun");
		list.add("Prem");
		list.add("Anil");

		Long c = list.stream().filter(s -> s.startsWith("A")).count();// Streams help to reduce code using lambda
																		// functions
		System.out.println(c);

		// we can do the above thing in single line without defining array list
		// Note: there is no life of intermediate option if we don't define terminal
		// option.
		// terminal option will execute only if intermediate option(filter) return true
		//

//		Stream.of("Akhil","Ram","Shyam","Arun","Ajay").filter(s->s.startsWith("A")).count();

//		Long d=Stream.of("Akhil","Ram","Shyam","Arun","Ajay").filter(s->
//		{
//			s.startsWith("A");
//			return true;
//			
//			
//		}).count();
//		
//		System.out.println(d);

		// to print all the names from the list using streams
		list.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// to print only one result whose length is greater than 4
		list.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

	}

	public void streamMap() {

		// print the names having last letter as a also convert into upper case
		// use map method to modify the results

		Stream.of("Akhil", "Ram", "Shyama", "Aruna", "Ajay").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// print names with first letter as A with upper case and sorted

		Stream.of("Akhil", "Ram", "Shyama", "Aruna", "Ajay").filter(s -> s.startsWith("A")).map(s -> s.toUpperCase())
				.sorted().forEach(s -> System.out.println(s));
		
		//Merging two arraylist
		
		List<String> l1=Arrays.asList("Akhil", "Ram", "Shyama", "Aruna", "Ajay");
		List<String> l2=Arrays.asList("Sita", "Getta", "Rekha", "Alia", "Deepika");
		
		Stream<String> newStream=Streams.concat(l1.stream() , l2.stream());
		
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//to check name is present in the list or not
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		
		
	}
	
	public void streamColllect() {//used to collect your results and convert back to list 
								  //till now we took the list and convert it to stream
		System.out.println("From StreamCollect");
		
		List<String> collectorList=Stream.of("Akhil", "Ram", "Shyama", "Aruna", "Ajay").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println(collectorList.get(0));
		
		
		
	}

}
