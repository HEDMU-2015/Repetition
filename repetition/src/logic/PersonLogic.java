package logic;

import java.util.List;
import java.util.Optional;

import domain.PersonDomain;

public class PersonLogic {
//	private PersonDA personda = new PersonDA();

	public void create(PersonDomain domain) {
		Personer.instance().create(domain);
//		DataAccess dataaccess = new DataAccess();
//		new LogicTrans<>(dataaccess)
//			.transaction(() -> personda.create(dataaccess, domain));				
	}

	public Optional<PersonDomain> read(String email) {
		return Personer.instance().read(email);
//		DataAccess dataaccess = new DataAccess();
//		return new LogicTrans<Optional<PersonDomain>>(dataaccess)
//			.transaction(() -> personda.read(dataaccess, key));				
	}

	public void update(PersonDomain domain) {
		Personer.instance().update(domain);
//		DataAccess dataaccess = new DataAccess();
//		new LogicTrans<>(dataaccess)
//			.transaction(() -> personda.update(dataaccess, domain));
	}

	public void delete(PersonDomain domain) {
		Personer.instance().delete(domain);
//		DataAccess dataaccess = new DataAccess();
//		new LogicTrans<>(dataaccess)
//			.transaction(() -> personda.delete(dataaccess, domain));
	}
	
	public List<PersonDomain> list(String search) {
		return Personer.instance().list(search);
//		DataAccess dataaccess = new DataAccess();
//		return new LogicTrans<List<PersonDomain>>(dataaccess)
//			.transaction(() -> personda.list(dataaccess, search));				
	}

}
