package shop.DAO;

import java.sql.ResultSet;

import com.alohaclass.jdbc.dao.BaseDAOImpl;

import shop.DTO.Users;


public class UserDAO extends BaseDAOImpl<Users> {
	
	@Override
	public Users map(ResultSet rs) throws Exception {
		Users user = new Users();
		user.setNo( rs.getLong("no") );
		user.setId( rs.getString("id") );
		user.setUsername( rs.getString("username") );
		user.setPassword( rs.getString("password") );
		user.setName( rs.getString("name") );
		user.setEmail( rs.getString("email") );
		user.setEnabled( rs.getBoolean("enabled") );
		user.setCreatedAt( rs.getTimestamp("created_at") );
		user.setUpdatedAt( rs.getTimestamp("updated_at") );
		return user;
	}
	
	@Override
	public String table() {
		return "users";
	}
	
	@Override
	public String pk() {
		return "no";
	}
	

//	@Override
//	public List<Users> list() throws Exception {
//		String sql = " SELECT * FROM " + table();
//		List<Users> list = new ArrayList<Users>();
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			while( rs.next() ) {
//				Users user = map(rs);
//				list.add(user);
//			}
//		} catch (Exception e) {
//			System.err.println("UserDAO - list() 조회 중 에러");
//			e.printStackTrace();
//		}
//		return list;
//	}

//	@Override
//	public PageInfo<Users> page() throws Exception {
//		int total = count();
//		Page page = new Page(total);
//		
//		String sql = " SELECT * FROM users "
//				   + " LIMIT ?, ? ";
//		
//		PageInfo<Users> pageInfo = new PageInfo<>();
//		List<Users> list = new ArrayList<Users>();
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			while( rs.next() ) {
//				Users user = map(rs);
//				list.add(user);
//			}
//			pageInfo.setPage(page);
//			pageInfo.setList(list);
//		} catch (Exception e) {
//			System.err.println("UserDAO - page() 조회 중 에러");
//			e.printStackTrace();
//		}
//		return pageInfo;
//	}

//	@Override
//	public PageInfo<Users> page(PageInfo<Users> pageInfo) throws Exception {
//		Page page = pageInfo.getPage();
//		if( page == null || page.getTotal() == 0 ) {
//			int total = count(pageInfo);
//			page = new Page(total);
//		}
//		String searchCondition = getSearchOptions(pageInfo.getSearchOptions());
//		int searchCounditionCount = pageInfo.getSearchOptions().size();
//		String sql = " SELECT * "
//				   + " FROM users"
//				   + " WHERE 1=1"
//				   + "   AND ( "
//				   + searchCondition
//				   + "       )"
//				   + " LIMIT ?, ? ";
//		
//		List<Users> list = new ArrayList<Users>();
//		try {
//			psmt = con.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			int index = 1;
//			for (int i = 0; i < searchCounditionCount; i++) {
//				psmt.setString(index++, pageInfo.getKeyword());
//			}
//			psmt.setInt(index++, page.getIndex());
//			psmt.setInt(index++, page.getSize());
//			while( rs.next() ) {
//				Users user = map(rs);
//				list.add(user);
//			}
//			pageInfo.setPage(page);
//			pageInfo.setList(list);
//		} catch (Exception e) {
//			System.err.println("UserDAO - page() 조회 중 에러");
//			e.printStackTrace();
//		}
//		return pageInfo;
//	}

//	@Override
//	public PageInfo<Users> page(Page page) throws Exception {
//		if( page == null || page.getTotal() == 0 ) {
//			int total = count();
//			page = new Page(total);
//		}
//		String sql = " SELECT * "
//				   + " FROM users"
//				   + " LIMIT ?, ? ";
//		PageInfo<Users> pageInfo = new PageInfo<>();
//		List<Users> list = new ArrayList<Users>();
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			int index = 1;
//			psmt.setInt(index++, page.getIndex());
//			psmt.setInt(index++, page.getSize());
//			while( rs.next() ) {
//				Users user = map(rs);
//				list.add(user);
//			}
//			pageInfo.setPage(page);
//			pageInfo.setList(list);
//		} catch (Exception e) {
//			System.err.println("UserDAO - page() 조회 중 에러");
//			e.printStackTrace();
//		}
//		return pageInfo;
//	}

//	@Override
//	public PageInfo<Users> page(Page page, String keyword, List<String> searchOptions) throws Exception {
//		if( page == null || page.getTotal() == 0 ) {
//			int total = count(keyword, searchOptions);
//			page = new Page(total);
//		}
//		String searchCondition = getSearchOptions(searchOptions);
//		int searchCounditionCount = searchOptions.size();
//		String sql = " SELECT * "
//				   + " FROM users"
//				   + " WHERE 1=1"
//				   + "   AND ( "
//				   + searchCondition
//				   + "       )"
//				   + " LIMIT ?, ? ";
//		
//		PageInfo<Users> pageInfo = new PageInfo<>();
//		List<Users> list = new ArrayList<Users>();
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			int index = 1;
//			for (int i = 0; i < searchCounditionCount; i++) {
//				psmt.setString(index++, keyword);
//			}
//			psmt.setInt(index++, page.getIndex());
//			psmt.setInt(index++, page.getSize());
//			while( rs.next() ) {
//				Users user = map(rs);
//				list.add(user);
//			}
//			pageInfo.setPage(page);
//			pageInfo.setList(list);
//		} catch (Exception e) {
//			System.err.println("UserDAO - page() 조회 중 에러");
//			e.printStackTrace();
//		}
//		return pageInfo;
//	}

//	@Override
//	public PageInfo<Users> page(Page page, String keyword, List<String> searchOptions,
//			Map<String, String> filterOptions) throws Exception {
//		if( page == null || page.getTotal() == 0 ) {
//			int total = count(keyword, searchOptions);
//			page = new Page(total);
//		}
//		String searchCondition = getSearchOptions(searchOptions);
//		int searchCounditionCount = searchOptions.size();
//		String orderBy = getFilterOptions(filterOptions);
//		String sql = " SELECT * "
//				   + " FROM users"
//				   + " WHERE 1=1"
//				   + "   AND ( "
//				   + searchCondition
//				   + "       )"
//				   + orderBy
//				   + " LIMIT ?, ? ";
//		
//		PageInfo<Users> pageInfo = new PageInfo<>();
//		List<Users> list = new ArrayList<Users>();
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			int index = 1;
//			for (int i = 0; i < searchCounditionCount; i++) {
//				psmt.setString(index++, keyword);
//			}
//			psmt.setInt(index++, page.getIndex());
//			psmt.setInt(index++, page.getSize());
//			while( rs.next() ) {
//				Users user = map(rs);
//				list.add(user);
//			}
//			pageInfo.setPage(page);
//			pageInfo.setList(list);
//		} catch (Exception e) {
//			System.err.println("UserDAO - page() 조회 중 에러");
//			e.printStackTrace();
//		}
//		return pageInfo;
//	}

//	@Override
//	public Users select(Long no) throws Exception {
//		String sql = " SELECT * "
//				   + " FROM users "
//				   + " WHERE no = ? "
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setLong(1, no);
//			rs = psmt.executeQuery();
//			if( rs.next() ) {
//				Users user = map(rs);
//				return user;
//			}
//		} catch (Exception e) {
//			System.err.println("UserDAO - select(no) 조회 중 에러");
//			e.printStackTrace();
//		}
//		return null;
//	}

//	@Override
//	public Users selectById(String id) throws Exception {
//		String sql = " SELECT *"
//				   + " FROM users "
//				   + " WHERE id = ? "
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, id);
//			rs = psmt.executeQuery();
//			if( rs.next() ) {
//				Users user = map(rs);
//				return user;
//			}
//		} catch (Exception e) {
//			System.err.println("UserDAO - select(id) 조회 중 에러");
//			e.printStackTrace();
//		}
//		return null;
//	}

//	@Override
//	public int insert(Users entity) throws Exception {
//		int result = 0;
//		String sql = " INSERT INTO users ( id, username, password, name, email, enabled ) "
//				   + " VALUES ( ?, ?, ?, ?, ?, ? ) ";
//		try {
//			psmt = con.prepareStatement(sql);
//			int index = 1;
//			psmt.setString(index++, entity.getId() );
//			psmt.setString(index++, entity.getUsername());
//			psmt.setString(index++, entity.getPassword());
//			psmt.setString(index++, entity.getName());
//			psmt.setString(index++, entity.getEmail());
//			psmt.setBoolean(index++, entity.getEnabled());
//			result = psmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println("UserDAO - insert(entity) 도중 에러");
//			e.printStackTrace();
//		}
//		return result;
//	}

//	@Override
//	public int update(Users entity) throws Exception {
//		int result = 0;
//		String sql = " UPDATE users "
//				   + "    SET "
//				   + "      	username = ? "
//				   + "         ,password = ? "
//				   + " 		   ,name = ? "
//				   + "		   ,email = ? "
//				   + " 		   ,enabled = ? "
//				   + " WHERE no = ? ";
//		try {
//			psmt = con.prepareStatement(sql);
//			int index = 1;
//			psmt.setString(index++, entity.getUsername());
//			psmt.setString(index++, entity.getPassword());
//			psmt.setString(index++, entity.getName());
//			psmt.setString(index++, entity.getEmail());
//			psmt.setBoolean(index++, entity.getEnabled());
//			psmt.setLong(index++, entity.getNo());
//			result = psmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println("UserDAO - update(entity) 도중 에러");
//			e.printStackTrace();
//		}
//		return result;
//	}

//	@Override
//	public int updateById(Users entity) throws Exception {
//		int result = 0;
//		String sql = " UPDATE users "
//				   + "    SET "
//				   + "      	username = ? "
//				   + "         ,password = ? "
//				   + " 		   ,name = ? "
//				   + "		   ,email = ? "
//				   + " 		   ,enabled = ? "
//				   + " WHERE id = ? ";
//		try {
//			psmt = con.prepareStatement(sql);
//			int index = 1;
//			psmt.setString(index++, entity.getUsername());
//			psmt.setString(index++, entity.getPassword());
//			psmt.setString(index++, entity.getName());
//			psmt.setString(index++, entity.getEmail());
//			psmt.setBoolean(index++, entity.getEnabled());
//			psmt.setString(index++, entity.getId());
//			result = psmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println("UserDAO - updateById(entity) 도중 에러");
//			e.printStackTrace();
//		}
//		return result;
//	}

//	@Override
//	public int delete(Users entity) throws Exception {
//		int result = 0;
//		String sql = " DELETE FROM users "
//				   + " WHERE no = ? "
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setLong(1, entity.getNo());
//			result = psmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println("UserDAO - delete(entity) 도중 에러");
//			e.printStackTrace();
//		}
//		return result;
//	}

//	@Override
//	public int delete(Long no) throws Exception {
//		int result = 0;
//		String sql = " DELETE FROM users "
//				   + " WHERE no = ? "
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setLong(1, no);
//			result = psmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println("UserDAO - delete(no) 도중 에러");
//			e.printStackTrace();
//		}
//		return result;
//	}

//	@Override
//	public int deleteById(Users entity) throws Exception {
//		int result = 0;
//		String sql = " DELETE FROM users "
//				   + " WHERE id = ? "
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, entity.getId());
//			result = psmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println("UserDAO - delete(entity) 도중 에러");
//			e.printStackTrace();
//		}
//		return result;
//	}

//	@Override
//	public int deleteById(String id) throws Exception {
//		int result = 0;
//		String sql = " DELETE FROM users "
//				   + " WHERE id = ? "
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, id);
//			result = psmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println("UserDAO - delete(id) 도중 에러");
//			e.printStackTrace();
//		}
//		return result;
//	}

//	@Override
//	public int count() throws Exception {
//		int count = 0;
//		String sql = " SELECT COUNT(*) FROM users ";
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//			count = rs.getInt(1);
//			System.out.println("count : " + count);
//		} catch (Exception e) {
//			System.err.println("UserDAO - count() 도중 에러");
//			e.printStackTrace();
//		}
//		return count;
//	}

//	@Override
//	public int count(PageInfo<Users> pageInfo) throws Exception {
//		int count = 0;
//		String searchCondition = getSearchOptions(pageInfo.getSearchOptions());
//		int searchCounditionCount = pageInfo.getSearchOptions().size();
//		String sql = " SELECT COUNT(*) "
//				   + " FROM users "
//				   + " WHERE 1=1"
//				   + "   AND ( "
//				   + searchCondition
//				   + "       )"
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			int index = 1;
//			for (int i = 0; i < searchCounditionCount; i++) {
//				psmt.setString(index++, pageInfo.getKeyword());
//			}
//			count = rs.getInt(1);
//			System.out.println("count : " + count);
//		} catch (Exception e) {
//			System.err.println("UserDAO - count(PageInfo) 도중 에러");
//			e.printStackTrace();
//		}
//		return count;
//	}


//	@Override
//	public int count(String keyword, List<String> searchOptions) throws Exception {
//		int count = 0;
//		String searchCondition = getSearchOptions(searchOptions);
//		int searchCounditionCount = searchOptions.size();
//		String sql = " SELECT COUNT(*) "
//				   + " FROM users "
//				   + " WHERE 1=1"
//				   + "   AND ( "
//				   + searchCondition
//				   + "       )"
//				   ;
//		try {
//			psmt = con.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			int index = 1;
//			for (int i = 0; i < searchCounditionCount; i++) {
//				psmt.setString(index++, keyword);
//			}
//			count = rs.getInt(1);
//			System.out.println("count : " + count);
//		} catch (Exception e) {
//			System.err.println("UserDAO - count(keyword, searchOptions) 도중 에러");
//			e.printStackTrace();
//		}
//		return count;
//	}
	
}




















