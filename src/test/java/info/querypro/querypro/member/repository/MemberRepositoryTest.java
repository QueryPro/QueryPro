package info.querypro.querypro.member.repository;

import static org.assertj.core.api.Assertions.assertThat;

import info.querypro.querypro.job.dummy.JobDummy;
import info.querypro.querypro.job.entity.Job;
import info.querypro.querypro.jobgroup.dummy.JobGroupDummy;
import info.querypro.querypro.jobgroup.entity.JobGroup;
import info.querypro.querypro.member.dummy.MemberDummy;
import info.querypro.querypro.member.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

/**
 * 회원 레포 테스트.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TestEntityManager entityManager;

    Job job;
    JobGroup jobGroup;
    Member member;

    @BeforeEach
    void setUp() {
        jobGroup = JobGroupDummy.dummy();
        job = JobDummy.dummy(jobGroup);
        member = MemberDummy.dummy(job);

        entityManager.persist(jobGroup);
        entityManager.persist(job);
    }

    @Test
    void save() {
        Member save = memberRepository.save(member);

        assertThat(save.getMemberId()).isEqualTo(member.getMemberId());
        assertThat(save.getMemberNo()).isEqualTo(member.getMemberNo());
        assertThat(save.getAge()).isEqualTo(member.getAge());
        assertThat(save.getMemberName()).isEqualTo(member.getMemberName());
        assertThat(save.getPassword()).isEqualTo(member.getPassword());
        assertThat(save.getNickname()).isEqualTo(member.getNickname());
        assertThat(save.getCreatedAt()).isEqualTo(member.getCreatedAt());
        assertThat(save.getJob()).isEqualTo(member.getJob());
        assertThat(save.isDeleted()).isFalse();
        assertThat(save.isNewcomered()).isTrue();



    }
}