package shop.Service;

import java.util.Date;

import shop.DAO.PersistenceLoginsDAO;
import shop.DTO.PersistenceLogins;

public class PersistenceLoginsServiceImpl implements PersistenceLoginsService {

	private PersistenceLoginsDAO persistenceLoginsDAO = new PersistenceLoginsDAO();
	
	@Override
	public PersistenceLogins insert(String username) {
		return persistenceLoginsDAO.insert(username);
	}

	@Override
	public PersistenceLogins select(String username) {
		return persistenceLoginsDAO.select(username);
	}

	@Override
	public PersistenceLogins selectByToken(String token) {
		return persistenceLoginsDAO.selectByToken(token);
	}

	@Override
	public PersistenceLogins update(String username) {
		return persistenceLoginsDAO.update(username);
	}

	@Override
	public PersistenceLogins refresh(String username) {
		// 토큰 조회
		PersistenceLogins persistenceLogins = persistenceLoginsDAO.select(username);
		
		if( persistenceLogins == null ) {
			// 토큰이 없는 경우, 토큰 등록
			persistenceLogins = persistenceLoginsDAO.insert(username);
		}
		else {
			// 토큰이 있는 경우, 토큰 수정
			persistenceLogins = persistenceLoginsDAO.update(username);
		}
		return persistenceLogins;
	}

	@Override
	public boolean isValid(String token) {
		PersistenceLogins persistenceLogins = persistenceLoginsDAO.selectByToken(token);
		
		// 토큰 없음
		if( persistenceLogins == null ) 
			return false;
		
		// 토큰 만료
		Date expiryDate = persistenceLogins.getExpiryDate();
		Date today = new Date();
		if( today.after(expiryDate) ) {
			return false;
		}
		// 토큰 유효
		return true;
	}

	@Override
	public boolean delete(String username) {
		boolean result = persistenceLoginsDAO.delete(username);
		return result;
	}

}
















