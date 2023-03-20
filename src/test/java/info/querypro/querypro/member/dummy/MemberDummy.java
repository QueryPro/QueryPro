package info.querypro.querypro.member.dummy;

import info.querypro.querypro.job.entity.Job;
import info.querypro.querypro.member.entity.Member;

/**
 * 멤버 더미 클래스.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public class MemberDummy {
    public static Member dummy(Job job) {
        return new Member(
                null,
                job,
                "memberId",
                "memberName",
                "memberNickname",
                "password",
                26,
                true,
                false
        );
    }
}
