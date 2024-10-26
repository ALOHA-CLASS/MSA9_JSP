package shop.DAO;

import java.sql.ResultSet;

import com.alohaclass.jdbc.dao.BaseDAOImpl;

import shop.DTO.UserAuth;

public class UserAuthDAO extends BaseDAOImpl<UserAuth> {

	@Override
	public UserAuth map(ResultSet rs) throws Exception {
		UserAuth uesrAuth = new UserAuth();
		uesrAuth.setNo( rs.getLong("no") );
		uesrAuth.setId( rs.getString("id") );
		uesrAuth.setUsername( rs.getString("username") );
		uesrAuth.setAuth( rs.getString("auth") );
		uesrAuth.setCreatedAt( rs.getTimestamp("created_at") );
		uesrAuth.setUpdatedAt( rs.getTimestamp("updated_at") );
		return uesrAuth;
	}

	@Override
	public String pk() {
		return "no";
	}

	@Override
	public String table() {
		return "user_auth";
	}

}
