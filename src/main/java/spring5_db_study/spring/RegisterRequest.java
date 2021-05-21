package spring5_db_study.spring;
//회원 가입을 처리할때 필요한 이메일,암호, 이름 데이터를 담고 있는 간단한 클래스
public class RegisterRequest {
	
	private String email;
	private String password;
	private String confirmPassword;
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//비밀번호 확인함수
	public boolean isPasswordEqualToConfirmPassword() {
		//입력암호와 확인암호가 같으면 True 틀리면 false
		return password.equals(confirmPassword);
	}
}
