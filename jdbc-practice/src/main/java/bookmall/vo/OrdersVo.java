package bookmall.vo;

public class OrdersVo {
	private Long no;
	private Long ordersNo;
	private Long ordersPrice;
	private String ordersAddress;
	private Long UserNo;
	private String UserName;
	private String UserEmail;
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}
	public Long getOrdersPrice() {
		return ordersPrice;
	}
	public void setOrdersPrice(Long ordersPrice) {
		this.ordersPrice = ordersPrice;
	}
	public String getOrdersAddress() {
		return ordersAddress;
	}
	public void setOrdersAddress(String ordersAddress) {
		this.ordersAddress = ordersAddress;
	}
	public Long getUserNo() {
		return UserNo;
	}
	public void setUserNo(Long userNo) {
		UserNo = userNo;
	}	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	@Override
	public String toString() {
		return "주문번호: " + ordersNo + ", 주문가격: " + ordersPrice + ", 배송지: "
				+ ordersAddress + ", 회원명: " + UserName + ", 회원이메일: " + UserEmail;
	}	
}
