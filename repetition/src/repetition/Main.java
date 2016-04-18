package repetition;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
public class Main {
 
    public static void main(String[] args) {
         
         
        List<Person> elderThan25 = new ArrayList<Person>();
        elderThan25.add(new Person("Per", "per@gmail.com", LocalDate.of(1988, 12, 15)));
        elderThan25.add(new Person("Søren", "søren@gmail.com", LocalDate.of(2010, 11, 14)));
        elderThan25.add(new Person("Mads", "mads@gmail.com", LocalDate.of(1999, 10, 13)));
        elderThan25.add(new Person("John", "john@gmail.com", LocalDate.of(2010, 9, 12)));
        elderThan25.add(new Person("Mette", "mette@gmail.com", LocalDate.of(1982, 8, 11)));
        elderThan25.add(new Person("Lordes", "lordes@gmail.com", LocalDate.of(1986, 7, 10)));
        elderThan25.add(new Person("Misse", "misse@gmail.com", LocalDate.of(1978, 6, 9)));
        elderThan25.add(new Person("Glen", "glen@gmail.com", LocalDate.of(1953, 5, 8)));
        elderThan25.add(new Person("Benjamin", "benjamin@gmail.com", LocalDate.of(1956, 4, 7)));
        elderThan25.add(new Person("Helene", "helene@gmail.com", LocalDate.of(2012, 3, 6)));
        elderThan25.add(new Person("Jens", "jens@gmail.com", LocalDate.of(1950, 2, 5)));
        elderThan25.add(new Person("Louis", "louis@gmail.com", LocalDate.of(1953, 1, 4)));
        elderThan25.add(new Person("Sara", "sara@gmail.com", LocalDate.of(1955, 12, 3)));
        elderThan25.add(new Person("Pernille", "pernille@gmail.com", LocalDate.of(1957, 11, 2)));
        elderThan25.add(new Person("Dorthe", "dorthe@gmail.com", LocalDate.of(2000, 10, 1)));
        elderThan25.add(new Person("Rene", "rene@gmail.com", LocalDate.of(1999, 9, 30)));
        elderThan25.add(new Person("Karina", "karina@gmail.com", LocalDate.of(1998, 8, 29)));
        elderThan25.add(new Person("Jette", "jette@gmail.com", LocalDate.of(1940, 7, 28)));
        elderThan25.add(new Person("Godfred", "godfred@gmail.com", LocalDate.of(1982, 6, 27)));
        elderThan25.add(new Person("Gudmund", "gudmund@gmail.com", LocalDate.of(1987, 5, 26)));
     
       
        
         
         
       
  
        for (Person person : elderThan25 ) {
             
            if (person.getAge()> 25){
                 
                System.out.println("age: "  + person.getAge() + '\t'  
                		+ " Birthday: " + person.getBirthdate() + '\t'
                		+ " Name: " + person.getName() + '\t' 
                		+ " Email: " + person.getEmail());
            }
                 
                 
                 
            }
         

        }
         
    }

