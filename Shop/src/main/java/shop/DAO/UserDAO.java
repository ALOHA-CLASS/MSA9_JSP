package shop.DAO;

import shop.DTO.Users;

public class UserDAO extends JDBConnection {

	/**
	 * 회원 가입
	 * @param user
	 * @return
	 */
	public int signup(Users user) {
		int result = 0;
		
		String sql = " INSERT INTO users(username, password, name, email, enabled )"
				   + " VALUES ( ?, ?, ?, ?, ? ) ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getName());
			psmt.setString(4, user.getEmail());
			psmt.setBoolean(5, user.getEnabled());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("회원 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
		
	/**
	 * 회원 번호로 조회
	 * @param no
	 * @return
	 */
	public Users select(int no) {
		
		String sql = " SELECT * "
				   + " FROM users"
				   + " WHERE no = ? ";
		
		Users user = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				user = new Users();
				user.setNo( rs.getInt("no") );
				user.setUsername( rs.getString("username") );
				user.setPassword( rs.getString("password") );
				user.setName( rs.getString("name") );
				user.setEmail( rs.getString("email") );
				user.setEnabled( rs.getBoolean("enabled") );
				user.setRegDate( rs.getTimestamp("reg_date") );
				user.setUpdDate( rs.getTimestamp("upd_date") );
			}
			
		} catch (Exception e) {
			System.err.println("회원 정보 번호로 조회 시 예외 발생");
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 회원 아이디로 조회
	 * @param username
	 * @return
	 */
	public Users select(String username) {
		String sql = " SELECT * "
				   + " FROM users"
				   + " WHERE username = ? ";
		
		Users user = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				user = new Users();
				user.setNo( rs.getInt("no") );
				user.setUsername( rs.getString("username") );
				user.setPassword( rs.getString("password") );
				user.setName( rs.getString("name") );
				user.setEmail( rs.getString("email") );
				user.setEnabled( rs.getBoolean("enabled") );
				user.setRegDate( rs.getTimestamp("reg_date") );
				user.setUpdDate( rs.getTimestamp("upd_date") );
			}
			
		} catch (Exception e) {
			System.err.println("회원 정보 아이디로 조회 시 예외 발생");
			e.printStackTrace();
		}
		return user;
	}
	
	
}




















