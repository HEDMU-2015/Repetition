package repetition;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Util<T,R> {

	public static int differenceInYears(LocalDate from, LocalDate to) {
		return Period.between(from, to).getYears();
	}
	
	public List<R> reduce(List<T> list, Predicate<T> predicate, Function<T, R> function) {
		return list
				.stream()
				.filter(p -> )
				.map();
	}
	
	public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate) {
		return 0;
	}
}
