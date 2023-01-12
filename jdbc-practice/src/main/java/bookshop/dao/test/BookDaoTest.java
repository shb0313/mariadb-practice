package bookshop.dao.test;

import java.util.List;

import bookshop.dao.AuthorDao;
import bookshop.dao.BookDao;
import bookshop.vo.AuthorVo;
import bookshop.vo.BookVo;

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
		vo.setAuthorNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("뉴문");
		vo.setAuthorNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("이클립스");
		vo.setAuthorNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("브레이킹던");
		vo.setAuthorNo(1L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아리랑");
		vo.setAuthorNo(2L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("젊은그들");
		vo.setAuthorNo(3L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아프나까 청춘이다");
		vo.setAuthorNo(4L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("귀천");
		vo.setAuthorNo(5L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("태백산맥");
		vo.setAuthorNo(2L);
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("풀하우스");
		vo.setAuthorNo(7L);
		dao.insert(vo);
	}
	
	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}

}