package bookmall.vo;

public class UserVo {
	private Long no;
	private String name;
	private String phoneNumber;
	private String email;
	private Long password;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "[회뤈번호: " + no + "] " + "이름: " + name + ", 전화번호: " + phoneNumber + ", 이메일: " + email;
	}
}
