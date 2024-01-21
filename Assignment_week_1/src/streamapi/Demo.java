package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Demo {
	public static void main(String[] args) {
		
		//Stream object created below of type Stream
				Stream stream = Stream.of(10,20,30,40,50);
//				long count = stream.count();
//				System.out.println(count);
				Comparator<Integer> comparator = (i1,i2)->{ return i1.toString().compareTo(i2.toString());};
				Optional<Integer> optional = stream.max(comparator);
				if(optional.isPresent())
				{
					System.out.println(optional.get());
				}
				else {
					System.out.println(optional.orElse(0));
				}
				
				String names[] = {"Satish","ravi","ford","adam","king"};
				Stream<String> stream2 = Arrays.stream(names);
				stream2.map((str)->{ System.out.println(str); return str.length();}).forEach((len)->{System.out.println(len);});
				
				List list = Arrays.asList(names);
				Stream<String> stream3 = list.stream();
				stream3.map((str)->{return str.length();}).filter((len)->{return len>7;}).forEach(System.out::println);
				
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(30);
		list1.add(10);
		list1.add(20);
		list1.add(40);
		list1.add(2);
		list1.add(5);
		list1.add(100);
		
		Stream<Integer> stream1 = list1.stream();
//		stream.limit(5).forEach( System.out::println );
//		stream.skip(3).forEach( System.out::println );
//		stream.distinct().forEach( System.out::println );
	   Integer result = stream1.reduce((a,b)->{return a+b;}).orElse(0);		
	   System.out.println(result);
	}
}
