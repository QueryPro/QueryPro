package info.querypro.querypro.question.repository;

import static org.assertj.core.api.Assertions.assertThat;

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
 * Some description here.
 *
 * @author : 임태원
 * @since : 1.0
 **/
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestEntityManager entityManager;

    JobGroup jobGroup;
    Job job;
    Member member;
    Question question;

    @BeforeEach
    void setUp() {
        jobGroup = JobGroupDummy.dummy();
        job = JobDummy.dummy(jobGroup);
        member = MemberDummy.dummy(job);
        question = QuestionDummy.dummy(member, job);

        entityManager.persist(jobGroup);
        entityManager.persist(job);
        entityManager.persist(member);
    }

    @Test
    void save() {
        Question save = questionRepository.save(question);

        assertThat(save.getQuestionNo()).isEqualTo(question.getQuestionNo());
        assertThat(save.getContent()).isEqualTo(question.getContent());
        assertThat(save.getJob()).isEqualTo(question.getJob());
        assertThat(save.getMember()).isEqualTo(question.getMember());
        assertThat(save.isDisplayed()).isEqualTo(question.isDisplayed());
    }
}