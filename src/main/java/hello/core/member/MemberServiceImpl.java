package hello.core.member;

public class MemberServiceImpl implements MemberService {

    /**
     * 실제 할당하는 부분이 구현체를 의존하고 있다.
     * 즉 MemberService 구현체는 MemberRepository 인터페이스와 그의 구현체인 MemoryMemberRepository도 의존하고 있다 -> 잘못된 설계
     */
    private final MemberRepository memberRepository; // 인터페이스 안에 구현 객체를 넣어줘야 한다.

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
