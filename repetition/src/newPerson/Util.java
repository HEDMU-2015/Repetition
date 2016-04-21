package newPerson;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Util<T, R> {

	public static int differenceInYears(LocalDate from, LocalDate to) {

		int ageInYears = (int) ChronoUnit.YEARS.between(from, to);
		return ageInYears;
	}

	public List<R> reduce(List<T> list, Predicate<T> predicate, Function<T, R> function) {
		return list.stream().filter(predicate).map(function).collect(Collectors.toList());
	}

	public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate) {

		System.out.println(list);
		return list.stream().map(function).filter(predicate).collect(Collectors.toList());

	}

}