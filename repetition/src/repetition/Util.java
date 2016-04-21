package repetition;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util <T, R>{

	public static int differenceInYears(LocalDate from, LocalDate to){
		int age = from.compareTo(to);
		return age;
		
	}
	
	 public List<R> reduce(List<T> list, Predicate<T> predicate, Function<T, R> function){
		 
		 return list
		 .stream()
		 .filter(predicate)
		 .map(function)
		 .collect(Collectors.toList());
		 
		 	 
	 }
	
	 public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate){
		 return list
		 .stream()
		 .map(function)
		 .filter(predicate)
		 .collect(Collectors.toList());		 
	 }
}
