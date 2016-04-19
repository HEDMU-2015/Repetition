package repetition.opgave3;

import java.util.Optional;

public class EmploymentLogic {
	
	private EmploymentMapper employmentMapper = new EmploymentMapper();
	
	public void create(Employment domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> employmentMapper.create(dataAccess, domain));
	}
	
	public Employment read(int id){
		DataAccess dataAccess = new DataAccess();		
		return new LogicTrans<Optional<Employment>>(dataAccess).transaction(()-> employmentMapper.read(dataAccess, id)).get();
	}
	
	public void update(Employment domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> employmentMapper.update(dataAccess, domain));
		
	}
	
	public void delete(Employment domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> employmentMapper.delete(dataAccess, domain));
		
	}
}
