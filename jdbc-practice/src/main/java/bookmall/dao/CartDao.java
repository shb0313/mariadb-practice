package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao {
	public List<CartVo> findAll(){
		List<CartVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select c.no, c.cart_count, a.no, b.no, b.title, b.price\r\n"
					+ "from user a, book b, cart c where a.no = c.user_no and b.no = c.book_no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVo vo = new CartVo();
				vo.setNo(rs.getLong(1));
				vo.setCartCount(rs.getLong(2));
				vo.setUserNo(rs.getLong(3));
				vo.setBookNo(rs.getLong(4));
				vo.setBookTitle(rs.getString(5));
				vo.setBookPrice(rs.getLong(6));
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
	
	public void insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into cart values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getCartCount());
			pstmt.setLong(2, vo.getUserNo());
			pstmt.setLong(3, vo.getBookNo());
			
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
