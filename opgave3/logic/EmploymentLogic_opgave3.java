package logic;

import java.util.Optional;

import domain.Employment_opgave3;
import persistence.EmploymentMapper_opgave3;
import util.DataAccess_opgave3;
import util.LogicTrans_opgave3;

public class EmploymentLogic_opgave3 {
	
	private EmploymentMapper_opgave3 employmentMapper = new EmploymentMapper_opgave3();
	
	public void create(Employment_opgave3 domain){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		new LogicTrans_opgave3<>(dataAccess).transaction(()-> employmentMapper.create(dataAccess, domain));
	}
	
	public Optional<Employment_opgave3> read(int id){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		return new LogicTrans_opgave3<Optional<Employment_opgave3>>(dataAccess).transaction(()-> employmentMapper.read(dataAccess, id));
	}
	
	public void update(Employment_opgave3 domain){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		new LogicTrans_opgave3<>(dataAccess).transaction(()-> employmentMapper.update(dataAccess, domain));
		
	}
	
	public void delete(Employment_opgave3 domain){
		DataAccess_opgave3 dataAccess = new DataAccess_opgave3();		
		new LogicTrans_opgave3<>(dataAccess).transaction(()-> employmentMapper.delete(dataAccess, domain));
		
	}
}
