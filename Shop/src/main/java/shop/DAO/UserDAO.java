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
		
}







