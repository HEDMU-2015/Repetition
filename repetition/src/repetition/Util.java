package repetition;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Juyoung Choi
 * 
 * Function : Represents a function that accepts one argument and produces a result. 
 * Predicate : Represents a predicate (boolean-valued function) of one argument. 

 * @param <T> : T - the type of the input to the function
 * @param <R> : R - the type of the result of the function
 */
public class Util <T, R> {
	
	public static int differentInYears(LocalDate from, LocalDate to){
		return Period.between(from, to).getYears();		
	}
	
//	public List<R> reduce(List<T> list, Predicate<T> predicate, Function<T, R> function){
//		return list
//				.stream()
//				.filter(predicate)
//				.map(function)
//				.collect(Collectors.toList());
//		}
//	
//	public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate){ // T? R?
//		
//		return list
//				.stream()
//				.filter(function)
//				.map(predicate)
//				.collect(Collectors.toList());
//	}
	
	
	

}
