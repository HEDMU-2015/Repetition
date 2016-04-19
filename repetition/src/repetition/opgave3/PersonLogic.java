package repetition.opgave3;

import java.util.Optional;

public class PersonLogic {
	PersonMapper personMapper = new PersonMapper();
	
	public void create(Person domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> personMapper.create(dataAccess, domain));
	}
	
	public Person read(int id){
		DataAccess dataAccess = new DataAccess();		
		return new LogicTrans<Optional<Person>>(dataAccess).transaction(()-> personMapper.read(dataAccess, id)).get();
	}
	
	public void update(Person domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> personMapper.update(dataAccess, domain));
		
	}
	
	public void delete(Person domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> personMapper.delete(dataAccess, domain));
		
	}

}
