package spring5_db_study;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring5_db_study.config.AppCtx;
import spring5_db_study.spring.ChangePasswordService;
import spring5_db_study.spring.Member;
import spring5_db_study.spring.MemberDao;
import spring5_db_study.spring.MemberNotFoundException;
import spring5_db_study.spring.WrongIdPasswordException;

public class MainForCPS {
	public static void main(String[] args) throws IOException {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);) {
			MemberDao memberDao = ctx.getBean(MemberDao.class);
			
			
//			memberDao.insert(new Member("test2@test2.co.kr", "test2", "test2", LocalDateTime.now()));
//			System.out.println("회원을 추가했습니다.\n");

			ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);
			cps.changePassword("test2@test2.co.kr", "test2", "newtest");
			System.out.println("암호를 변경했습니다.\n");

			Member member = memberDao.selectByEmail("test2@test2.co.kr");
			memberDao.delete(member);
			System.out.println("회원을 삭제했습니다.\n");

		} catch (MemberNotFoundException e) {
			System.err.println("존재하지 않는 이메일입니다.\n");
		} catch (WrongIdPasswordException e) {
			System.err.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}
}