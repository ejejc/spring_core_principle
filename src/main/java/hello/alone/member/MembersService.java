package hello.alone.member;

public interface MembersService {

    void join(Members members);

    Members findMember(Long memberId);
}
