package repetition;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Util<T,R> {

	public static int differenceInYears(LocalDate from, LocalDate to){
		
		Period difference = Period.between(from, to);
		return difference.getYears() ;
		
	}
	
	public List<R> reduce1(List<T> list, Predicate<T> predicate, Function<T, R> function){
		//function er input/output. Derfor hvis vi har en person ind, og objektet skal v�re person ud, s� skal person -> person n�r denne bliver kaldt.
		return list
				.stream()
				.filter(predicate)
				.map(function)
				.collect(Collectors.toList());
		
	}
	
	//forskellen imellem disse to er om der bliver filtreret f�rst eller bagefter. Skal der filtreres p� det der mappes s� bruger man nummer 2.
	//nummer 1 kn f.eks. bruges til at f� fat i navn eller lignende fra outputtet, det kan nummer 2 dog ikke.
	
	public List<R> reduce2(List<T> list, Function<T, R> function, Predicate<R> predicate){
		//map/filter er byttet rundt her i forhold til reduce1.
		return list
				.stream()
				.map(function)
				.filter(predicate)
				.collect(Collectors.toList());
		
	}
	
	
}
