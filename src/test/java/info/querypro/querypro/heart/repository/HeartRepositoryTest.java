package info.querypro.querypro.heart.repository;

import static org.assertj.core.api.Assertions.assertThat;

import info.querypro.querypro.heart.dummy.HeartDummy;
import info.querypro.querypro.heart.entity.Heart;
import info.querypro.querypro.job.dummy.JobDummy;
import info.querypro.querypro.job.entity.Job;
import info.querypro.querypro.jobgroup.dummy.JobGroupDummy;
import info.querypro.querypro.jobgroup.entity.JobGroup;
import info.querypro.querypro.member.dummy.MemberDummy;
import info.querypro.querypro.member.entity.Member;
import info.querypro.querypro.question.dummy.QuestionDummy;
import info.querypro.querypro.question.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

/**
 * 좋아요 레포 테스트.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class HeartRepositoryTest {

    @Autowired
    HeartRepository heartRepository;

    @Autowired
    TestEntityManager entityManager;

    JobGroup jobGroup;
    Job job;
    Member member;
    Question question;
    Heart heart;

    @BeforeEach
    void setUp() {
        jobGroup = JobGroupDummy.dummy();
        job = JobDummy.dummy(jobGroup);
        member = MemberDummy.dummy(job);
        question = QuestionDummy.dummy(member, job);
        heart = HeartDummy.dummy(member, question);

        entityManager.persist(jobGroup);
        entityManager.persist(job);
        entityManager.persist(member);
        entityManager.persist(question);
    }

    @Test
    void save() {
        Heart save = heartRepository.save(heart);

        assertThat(save.getMember()).isEqualTo(heart.getMember());
        assertThat(save.getQuestion()).isEqualTo(heart.getQuestion());
        assertThat(save.getPk()).isEqualTo(heart.getPk());
        assertThat(save.getPk().getMemberNo()).isEqualTo(heart.getMember().getMemberNo());
        assertThat(save.getPk().getQuestionNo()).isEqualTo(heart.getQuestion().getQuestionNo());
    }
}