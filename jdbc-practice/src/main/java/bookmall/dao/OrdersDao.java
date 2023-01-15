package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrdersBooksVo;
import bookmall.vo.OrdersVo;

public class OrdersDao {
	public List<OrdersVo> findAll_O(){
		List<OrdersVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select b.no, b.orders_no, b.orders_price, b.orders_address, b.user_no, a.name, a.email\r\n"
					+ "from user a, orders b where a.no = b.user_no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrdersVo vo = new OrdersVo();
				vo.setNo(rs.getLong(1));
				vo.setOrdersNo(rs.getLong(2));
				vo.setOrdersPrice(rs.getLong(3));
				vo.setOrdersAddress(rs.getString(4));
				vo.setUserNo(rs.getLong(5));
				vo.setUserName(rs.getString(6));
				vo.setUserEmail(rs.getString(7));
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public void insert(OrdersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders\r\n"
					+ "select null, ?, ?, sum(a.price * b.cart_count), b.user_no\r\n"
					+ "from book a, cart b\r\n"
					+ "where a.no = b.book_no\r\n"
					+ "group by user_no";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getOrdersNo());			
			pstmt.setString(2, vo.getOrdersAddress());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<OrdersBooksVo> findAll_OB(){
		List<OrdersBooksVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select c.no, c.order_count, a.no, b.orders_no, a.title\r\n"
					+ "from book a, orders b, order_books c\r\n"
					+ "where a.no = c.book_no\r\n"
					+ "and c.orders_no = b.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrdersBooksVo vo = new OrdersBooksVo();
				vo.setNo(rs.getLong(1));
				vo.setOrdersCount(rs.getLong(2));
				vo.setBookNo(rs.getLong(3));
				vo.setOrdersNo(rs.getString(4));
				vo.setBookTitle(rs.getString(5));
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public void insert(OrdersBooksVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into order_books\r\n"
					+ "select null, b.cart_count, a.no, c.no\r\n"
					
					+ "from book a, cart b, orders c \r\n"
					+ "where a.no = b.book_no\r\n"
					+ "and b.user_no = c.user_no";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.10.115:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}	
}
