package bookmall.dao.test;

import java.util.List;

import bookmall.dao.UserDao;
import bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();		
	}

	private static void testInsert() {
		UserVo vo = null;
		UserDao dao = new UserDao();
		
		vo = new UserVo();
		vo.setName("둘리");
		vo.setPhoneNumber("010-1111-0001");
		vo.setEmail("dooly@gmail.com");
		vo.setPassword(1234L);
		dao.insert(vo);
		
		vo = new UserVo();
		vo.setName("또치");
		vo.setPhoneNumber("010-2222-0002");
		vo.setEmail("ddochi@gmail.com");
		vo.setPassword(5678L);
		dao.insert(vo);
		
	}

	private static void testFindAll() {
		List<UserVo> list = new UserDao().findAll();
		for(UserVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
