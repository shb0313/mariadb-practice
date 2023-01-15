package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.vo.OrdersBooksVo;
import bookmall.vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();		
	}

	private static void testInsert() {
		OrdersVo voO = null;
		OrdersBooksVo voOB = null;
		OrdersDao dao = new OrdersDao();
		
		voO = new OrdersVo();
		voO.setOrdersNo(230113001L);
		voO.setOrdersAddress("부산 센텀");
		dao.insert(voO);		
		dao.insert(voOB);		
	}

	private static void testFindAll() {
		List<OrdersVo> list = new OrdersDao().findAll_O();
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
