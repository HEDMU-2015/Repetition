package repetition.opgave2;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Util <T, R> {
	
	public static int differenceInYears(LocalDate from, LocalDate to) {
	
		return Period.between(from, to).getYears();
		
	}
	
	public List<R> reduce (List<T> list, Predicate<T> predicate, Function<T, R> function) {
		return list
		
		.stream().filter(predicate).map(function).collect(Collectors.toList());
	}
	
	public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate) {
		return list
				
		.stream().map(function).filter(predicate).collect(Collectors.toList());		
				
	}
}
