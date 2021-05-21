package spring5_db_study.spring;

import java.time.LocalDateTime;
//멤버 등록 서비스
public class MemberRegisterService {
	private MemberDao memberDao;
	
	//DI(의존 주입)를 통한 의존 처리(직접 객체를 생성하지 않음)
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//이메일로 회원 데이터(Member 조회)
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			// 같은 이메일을 가진 회원이 이미 존재하지 않으면 익셉션 발생
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		//같은 이메일을 가진 회원이 존재하지 않으면 Member 객체 생성해서 DB에 삽입
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
