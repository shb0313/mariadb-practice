package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();	
	}

	private static void testInsert() {
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setTitle("트와일라잇");
		vo.setPrice(13000L);
		vo.setCategoryNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("JAVA의 정석");
		vo.setPrice(27000L);
		vo.setCategoryNo(3L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("모든 것은 기본에서 시작한다");
		vo.setPrice(16000L);
		vo.setCategoryNo(2L);
		dao.insert(vo);
	}

	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}		
	}
}
