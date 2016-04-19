package repetition.opgava4;

import java.util.Optional;

public class EmploymentLogic {
	
	private EmploymentMapper employmentMapper = new EmploymentMapper();
	
	public void creat(Employment domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> employmentMapper.create(dataAccess, domain));
	}
	
	public Optional<Employment> readOrganisation(int id){
		DataAccess dataAccess = new DataAccess();		
		return new LogicTrans<Optional<Employment>>(dataAccess).transaction(()-> employmentMapper.read(dataAccess, id));
	}
	
	public void update (Employment domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> employmentMapper.update(dataAccess, domain));
		
	}
	
	public void create(Employment domain){
		DataAccess dataAccess = new DataAccess();		
		new LogicTrans<>(dataAccess).transaction(()-> employmentMapper.create(dataAccess, domain));
		
	}
}
