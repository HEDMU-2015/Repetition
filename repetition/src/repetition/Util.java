package repetition;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Util<T, R> {
	

	
	public static long differenceInYears(LocalDate from, LocalDate to) {
		long years = to.until(from, ChronoUnit.YEARS);
		to = to.plusYears(years);
		return years;
	}
	public List<R> reduce(List<T> list, Predicate<T> predicate, Function<T, R> function){
		return null;
		
	}
	public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate){
		return null;
	}
	
}
