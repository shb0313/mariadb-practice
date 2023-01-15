package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();		
	}

	private static void testInsert() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();
		
		vo = new CategoryVo();
		vo.setCategory("소설");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setCategory("에세이");
		dao.insert(vo);
		
		vo = new CategoryVo();
		vo.setCategory("컴퓨터/IT");
		dao.insert(vo);
	}

	private static void testFindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
		
	}
}