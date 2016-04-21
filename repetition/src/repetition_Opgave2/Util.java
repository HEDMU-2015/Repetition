package repetition_Opgave2;
/*Lav en ny klasse - Util - med en enkelt static metode, med følgende signatur:
 - public static int differenceInYears(LocalDate from, LocalDate to)*/

/*Ret Util-klassen:
 - Så den erklæres public class Util<T, R>
 - Tilføj en metode, med følgende signatur: public List<R> reduce(List<T> list, Predicate<T> predicate, Function<T, R> function)
 - Tilføj en metode, med følgende signatur: public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate)
 - Lav begge metoder ved hjælp af Stream, filter og map
 - Hvad er forskellen, og hvornår skal den ene bruges fremfor den anden?*/

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Util<T, R> {
	
	public List<R> reduce(List<T> list, Predicate<T> predicate, Function<T, R> function){
		
		return null;
	}
	
	public List<R> reduce(List<T> list, Function<T, R> function, Predicate<R> predicate){
		
		return null;
	}

	public static int differenceInYears(LocalDate from, LocalDate to){
		
		return 0;
	}
}
