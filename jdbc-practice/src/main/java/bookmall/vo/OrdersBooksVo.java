package bookmall.vo;

public class OrdersBooksVo {
	private Long no;	
	private Long ordersCount;
	private Long bookNo;
	private String ordersNo;
	private String bookTitle;	
		
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrdersNo() {
		return ordersNo;
	}
	public Long getOrdersCount() {
		return ordersCount;
	}
	public void setOrdersCount(Long ordersCount) {
		this.ordersCount = ordersCount;
	}
	public void setOrdersNo(String ordersNo) {
		this.ordersNo = ordersNo;
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
	@Override
	public String toString() {
		return "주문번호: " + ordersNo + ", 도서번호: " + bookNo
				+ ", 주문도서명: " + bookTitle + ", 주문수량: " + ordersCount;
	}
}
