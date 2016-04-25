package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.PersonDomain;

public class PersonDA {
	private static final String SELECT_ONE = "SELECT name, email, birthdate FROM person where id = ?";
	private static final String SELECT_MANY = "SELECT id, name, email, birthdate FROM person where UPPER(name) LIKE ? or UPPER(email) LIKE ? ORDER BY name";
	private static final String INSERT_ONE = "INSERT INTO person (name, email, birthdate) VALUES(?, ?, ?)";
	private static final String UPDATE_ONE = "UPDATE person SET name = ?, email = ?, birthdate = ? where id = ?";
	private static final String DELETE_ONE = "DELETE FROM person where id = ?";

	public void create(DataAccess access, PersonDomain domain) {
		Connection conn = access.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(INSERT_ONE);
			stmt.setString(1, domain.getName());
			stmt.setString(2, domain.getEmail());
			stmt.setDate(3, Date.valueOf(domain.getBirthdate()));
			int antal = stmt.executeUpdate();
			if (antal != 1) {
				throw new RuntimeException("Person allready exists");
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		} finally {
			cleanup(stmt);
		}
		
	}

	public Optional<PersonDomain> read(DataAccess access, long key) {
		Connection conn = access.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(SELECT_ONE);
			stmt.setLong(1, key);
			rs = stmt.executeQuery();
			if (rs.next()) {
				PersonDomain p = new PersonDomain();
				p.setId(key);
				p.setName(rs.getString("name"));
				p.setEmail(rs.getString("email"));
				p.setBirthdate(rs.getDate("birthdate").toLocalDate());
				return Optional.of(p);
			} else {
				return Optional.empty();
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		} finally {
			cleanup(rs, stmt);
		}
	}
	
	public void update(DataAccess access, PersonDomain domain) {
		Connection conn = access.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(UPDATE_ONE);
			stmt.setString(1, domain.getName());
			stmt.setString(2, domain.getEmail());
			stmt.setDate(3, Date.valueOf(domain.getBirthdate()));
			stmt.setLong(4, domain.getId());
			int antal = stmt.executeUpdate();
			if (antal != 1) {
				throw new RuntimeException("Person does not exist");
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		} finally {
			cleanup(stmt);
		}
		
	}

	public void delete(DataAccess access, PersonDomain domain) {
		Connection conn = access.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(DELETE_ONE);
			stmt.setLong(1, domain.getId());
			int antal = stmt.executeUpdate();
			if (antal != 1) {
				throw new RuntimeException("Person does not exist");
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		} finally {
			cleanup(stmt);
		}
		
	}

	public List<PersonDomain> list(DataAccess access, String search) {
		Connection conn = access.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			List<PersonDomain> list = new ArrayList<>();
			stmt = conn.prepareStatement(SELECT_MANY);
			stmt.setString(1, "%" + search.toUpperCase() + "%");
			stmt.setString(2, "%" + search.toUpperCase() + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				PersonDomain p = new PersonDomain();
				p.setId(rs.getLong("id"));
				p.setName(rs.getString("name"));
				p.setEmail(rs.getString("email"));
				p.setBirthdate(rs.getDate("birthdate").toLocalDate());
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("SQLException caught", e);
		} finally {
			cleanup(rs, stmt);
		}
	}


	private void cleanup(ResultSet rs, PreparedStatement stmt) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		cleanup(stmt);
		
	}

	private void cleanup(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		
	}

}
