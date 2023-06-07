package hello.alone.member;

public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository = new MemoryMembersRepository();

    @Override
    public void join(Members member) {
        membersRepository.save(member);
    }

    @Override
    public Members findMember(Long memberId) {
        return membersRepository.findById(memberId);
    }
}
