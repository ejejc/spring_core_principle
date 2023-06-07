package hello.alone.member;

public interface MembersRepository {

    void save(Members member);

    Members findById(Long memberId);
}
