package bookmall.vo;

public class CartVo {
	private Long no;
	private Long cartCount;
	private Long userNo;
	private Long bookNo;
	private String bookTitle;
	private Long bookPrice;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getCartCount() {
		return cartCount;
	}
	public void setCartCount(Long cartCount) {
		this.cartCount = cartCount;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Long getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "제목: " + bookTitle + ", 수량: " + cartCount + ", 가격: " + bookPrice;
	}
	
	
}
