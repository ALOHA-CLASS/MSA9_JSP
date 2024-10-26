package shop.DAO;

import java.sql.ResultSet;

import com.alohaclass.jdbc.dao.BaseDAOImpl;

import shop.DTO.PersistenceLogins;

public class PersistenceLoginsDAO extends BaseDAOImpl<PersistenceLogins> {
	
	@Override
	public PersistenceLogins map(ResultSet rs) throws Exception {
		PersistenceLogins logins = new PersistenceLogins();
		logins.setNo( rs.getLong("no") );
		logins.setId( rs.getString("id") );
		logins.setUsername( rs.getString("username") );
		logins.setToken( rs.getString("token") );
		logins.setExpiryDate( rs.getTimestamp("expiry_date") );
		logins.setCreatedAt( rs.getTimestamp("created_date") );
		logins.setUpdatedAt( rs.getTimestamp("updated_date") );
		return logins;
	}
	
	@Override
	public String table() {
		return "persistence_logins";
	}

	@Override
	public String pk() {
		return "no";
	}


}























