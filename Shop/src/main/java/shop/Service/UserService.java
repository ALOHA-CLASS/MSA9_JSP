package shop.Service;

import shop.DTO.Users;

public interface UserService {
	
	// 회원가입
	public int signup(Users user);
	
	// 로그인
	public Users login(Users user);
	
	// 회원 조회 (번호)
	public Users select(int no);
	
	// 회원 조회 (아이디)
	public Users select(String username);
	
	
}
