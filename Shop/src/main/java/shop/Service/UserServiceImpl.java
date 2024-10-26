package shop.Service;

import java.sql.SQLException;
import java.util.UUID;

import shop.DAO.UserAuthDAO;
import shop.DAO.UserDAO;
import shop.DTO.Auth;
import shop.DTO.UserAuth;
import shop.DTO.Users;
import shop.utils.PasswordUtils;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO = new UserDAO(); 
	private UserAuthDAO userAuthDAO = new UserAuthDAO(); 

	@Override
	public int signup(Users user) {
		int result = 0;
		// 유효성 검사
		if( user == null || user.isEmpty() ) {
			return 0;
		}
		// 비밀번호 암호화
		String password = user.getPassword();
		if( password == null || password.equals("") ) {
			return 0;
		}
		String encodedPassword = PasswordUtils.encoded(password);
		user.setPassword(encodedPassword);
		try {
			result = userDAO.insert(user);
		} catch (Exception e) {
			try {
				userDAO.con.rollback();
				System.err.println("@UserServiceImpl - signup(user) : 회원가입 실패");
				return 0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		System.out.println("@UserServiceImpl - signup(user) : result : " + result);
		System.out.println("@UserServiceImpl - signup(user) : 회원가입 성공");
		
		// 회원 가입 성공 시, 사용자 권한 등록
		int result2 = 0;
		UserAuth userAuth = UserAuth.builder()
								.id(UUID.randomUUID().toString())
								.username(user.getUsername())
								.auth(Auth.USER.toString())
								.build();
		try {
			System.out.println("userAuth : "  + userAuth);
			result2 = userAuthDAO.insert(userAuth);
			System.out.println("@UserServiceImpl - signup(user) : result : " + result);
			System.out.println("@UserServiceImpl - signup(user) - 회원 권한 등록 성공");
		} catch (Exception e) {
			try {
				userAuthDAO.con.rollback();
				System.err.println("@UserServiceImpl - signup(user) : 회원 권한 등록 실패");
				return 0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		try {
			if( result > 0 ) userDAO.con.commit();
			else userDAO.con.rollback();
			
			if( result2 > 0 ) userAuthDAO.con.commit();
			else userAuthDAO.con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Users login(Users user) {
		
		
		Users joinedUser = userDAO.selectBy(where);
		
		String loginPassword = user.getPassword();
		String password = joinedUser.getPassword();
		
		PasswordUtils.check(loginPassword, password);
		return null;
	}

	@Override
	public Users select(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users select(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}













