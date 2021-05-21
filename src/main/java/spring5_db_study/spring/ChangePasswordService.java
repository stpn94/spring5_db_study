package spring5_db_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//암호 변경 기능
public class ChangePasswordService {
	
	
	@Autowired
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 암호 변경
	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		// 만약 멤버가 null이면 멤버못찾음 예외
		if (member == null)
			throw new MemberNotFoundException();
		// 찾으면 changePassword실행
		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

}
