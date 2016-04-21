package logic;

import java.util.Optional;

import domain.Person_opgave3;
import persistence.PersonMapper_opgave3;
import util.DataAccess_opgave3;
import util.LogicTrans_opgave3;

public class PersonLogic_opgave3 {
	PersonMapper_opgave3 personMapper = new PersonMapper_opgave3();
	
	public void create(Person_opgave3 domain){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		new LogicTrans_opgave3<>(dataAccess).transaction(()-> personMapper.create(dataAccess, domain));
	}
	
	public Person_opgave3 read(int id){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		return new LogicTrans_opgave3<Optional<Person_opgave3>>(dataAccess).transaction(()-> personMapper.read(dataAccess, id)).get();
	}
	
	public void update(Person_opgave3 domain){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		new LogicTrans_opgave3<>(dataAccess).transaction(()-> personMapper.update(dataAccess, domain));
		
	}
	
	public void delete(Person_opgave3 domain){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		new LogicTrans_opgave3<>(dataAccess).transaction(()-> personMapper.delete(dataAccess, domain));
		
	}

}
