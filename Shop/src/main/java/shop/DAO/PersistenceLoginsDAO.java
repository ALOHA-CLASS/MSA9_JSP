package shop.DAO;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import shop.DTO.PersistenceLogins;

public class PersistenceLoginsDAO extends JDBConnection {

	/**
	 * 토큰 생성
	 * @param username
	 * @return
	 */
	public PersistenceLogins insert(String username) {
		int result = 0;
		String sql = " INSERT INTO persistence_logins (username, token, expiry_date)"
				   + " VALUES (?, ?, ?) ";
		// 토큰 발행
		String token = UUID.randomUUID().toString();
		
		// 만료 시간 설정
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date expiryDate = calendar.getTime();
		Timestamp expiryTime = new Timestamp(expiryDate.getTime());
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, token);
			psmt.setTimestamp(3, expiryTime);
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("자동 로그인 정보 등록 중, 예외 발생");
			e.printStackTrace();
		}
		System.out.println("자동 로그인 정보(토큰) 등록 성공");
		
		PersistenceLogins logins = PersistenceLogins.builder()
												.username(username)
												.token(token)
												.expiryDate(expiryDate)
												.build();
		return logins;
	}
	
	/**
	 * 토큰 조회
	 * @param username
	 * @return
	 */
	public PersistenceLogins select(String username) {
		
		String sql = " SELECT * "
				   + " FROM persistence_logins "
				   + " WHERE username = ? ";
		PersistenceLogins logins = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				logins = PersistenceLogins.builder()
											.username(username)
											.token(rs.getString("token"))
											.expiryDate(rs.getTimestamp("expiry_date"))
											.regDate(rs.getTimestamp("reg_date"))
											.updDate(rs.getTimestamp("upd_date"))
											.build();
			}
			
		} catch (Exception e) {
			System.err.println("토큰 조회 시 예외 발생");
			e.printStackTrace();
		}
		return logins;
	}
	
	
	/**
	 * 토큰 조회
	 * - 인증 토큰으로 조회
	 * @param username
	 * @return
	 */
	public PersistenceLogins selectByToken(String token) {
		
		String sql = " SELECT * "
				   + " FROM persistence_logins "
				   + " WHERE token = ? ";
		PersistenceLogins logins = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, token);
			rs = psmt.executeQuery();
			if( rs.next() ) {
				logins = PersistenceLogins.builder()
											.username(rs.getString("username"))
											.token(rs.getString("token"))
											.expiryDate(rs.getTimestamp("expiry_date"))
											.regDate(rs.getTimestamp("reg_date"))
											.updDate(rs.getTimestamp("upd_date"))
											.build();
			}
			
		} catch (Exception e) {
			System.err.println("토큰 조회 시 예외 발생");
			e.printStackTrace();
		}
		return logins;
	}
	
	
	// 토큰 수정
	public PersistenceLogins update(String username) {
		String sql = " UPDATE persistence_logins"
				   + " SET token = ? "
				   + "    ,expiry_date = ? "
				   + "    ,upd_date = ? "
				   + " WHERE username = ? ";
		// 토큰 발행
		String token = UUID.randomUUID().toString();
				
		// 만료 시간 설정
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date expiryDate = calendar.getTime();
		Timestamp expiryTime = new Timestamp(expiryDate.getTime());
		
		// 수정 시간
		Timestamp updDate = new Timestamp( new Date().getTime() );
		
		PersistenceLogins logins = null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, token);
			psmt.setTimestamp(2, expiryTime);
			psmt.setTimestamp(3, updDate);
			psmt.setString(4, username);
			int result = psmt.executeUpdate();
			if( result > 0 ) {
				logins = PersistenceLogins.builder()
											.username(username)
											.token(token)
											.expiryDate(expiryDate)
											.updDate(updDate)
											.build();
				System.out.println("토큰 수정 성공!");
			} 
		} catch (Exception e) {
			System.err.println("토큰 수정 시, 예외 발생");
			e.printStackTrace();
		}
		return logins;
	}
	
	/**
	 * 토큰 삭제
	 * @param username
	 * @return
	 */
	public boolean delete(String username) {
		boolean result = false;
		String sql = " DELETE FROM persistence_logins "
				   + " WHERE username = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			result = psmt.executeUpdate() == 0 ? false : true;
		} catch (Exception e) {
			System.err.println("토큰 삭제 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
}























