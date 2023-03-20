package info.querypro.querypro.member.repository;

import info.querypro.querypro.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 회원 레포.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public interface MemberRepository extends JpaRepository<Member, Long> {
}
