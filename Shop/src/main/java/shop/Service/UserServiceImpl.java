package shop.Service;

import shop.DAO.UserDAO;
import shop.DTO.Users;
import shop.utils.PasswordUtils;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAO();
	
	@Override
	public int signup(Users user) {
		// 비밀번호 암호화
		// * 암호화 알고리즘 : SHA-256, Bcrypt ...
		// 123456 ---> FIJ3124890J12/@3J9
		String encodedPassword = PasswordUtils.encoded(user.getPassword());
		user.setPassword(encodedPassword);
		
		int result = userDAO.signup(user);
		if( result > 0 ) System.out.println("회원 가입 성공!");
		else 			 System.out.println("회원 가입 실패!");
		
		// 회원 기본 권한 등록...
		return result;
	}

}









