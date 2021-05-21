package spring5_db_study.spring;
//
public class DuplicateMemberException extends RuntimeException {
	//중복 멤버 예외처리
	public DuplicateMemberException(String message) {
		//중복멤버 예외발생메세지를 받아서 출력
		super(message);
	}

}
