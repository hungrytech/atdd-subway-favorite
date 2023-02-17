package nextstep;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import nextstep.member.domain.Member;
import nextstep.member.domain.MemberRepository;
import nextstep.member.domain.RoleType;

@Profile("test")
@Component
public class DataLoader {

	private final MemberRepository memberRepository;

	public DataLoader(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void loadData() {
		memberRepository.save(
			new Member(
				"admin@email.com",
				"password",
				20,
				List.of(RoleType.ROLE_ADMIN.name())
			)
		);
		memberRepository.save(
			new Member(
				"member@email.com",
				"password",
				20,
				List.of(RoleType.ROLE_MEMBER.name()
				)
			)
		);
	}
}
