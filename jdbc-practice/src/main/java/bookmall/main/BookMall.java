package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.OrdersDao;
import bookmall.dao.UserDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.OrdersBooksVo;
import bookmall.vo.OrdersVo;
import bookmall.vo.UserVo;


public class BookMall {

	public static void main(String[] args) {
				
		System.out.println("## 회원리스트");
		List<UserVo> userList = new UserDao().findAll();
		for(UserVo vo : userList) {
			System.out.println(vo);
		}
		System.out.println();
		
		System.out.println("## 카테고리");
		List<CategoryVo> CategoryList = new CategoryDao().findAll();
		for(CategoryVo vo : CategoryList) {
			System.out.println(vo);
		}
		System.out.println();
		
		System.out.println("## 상품");
		List<BookVo> bookList = new BookDao().findAll();
		for(BookVo vo : bookList) {
			System.out.println(vo);
		}
		System.out.println();
		
		System.out.println("## 카트");
		List<CartVo> cartList = new CartDao().findAll();
		for(CartVo vo : cartList) {
			System.out.println(vo);
		}
		System.out.println();
		
		System.out.println("## 주문");
		List<OrdersVo> ordersList = new OrdersDao().findAll_O();
		for(OrdersVo vo : ordersList) {
			System.out.println(vo);
		}
		System.out.println();
		
		System.out.println("## 주문 도서 리스트");
		List<OrdersBooksVo> ordersBookssList = new OrdersDao().findAll_OB();
		for(OrdersBooksVo vo : ordersBookssList) {
			System.out.println(vo);
		}
		

	}
}
