package hello.alone.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMembersRepository implements MembersRepository{

    private static Map<Long, Members> store = new HashMap<>();

    @Override
    public void save(Members member) {
        store.put(member.getId(), member);
    }

    @Override
    public Members findById(Long memberId) {
        return store.get(memberId);
    }
}
